package edu.hillel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Value;

@Value
public class Basket {
  List<Product> productList;

  public Basket() {
    productList = new ArrayList<>();
  }

  public void add(Product product) {
    productList.add(product);
  }

  public List<Product> getAllProductsWithPrice(ProductType productType,
                                               float price) {
    return productList.stream()
        .filter(
            product -> product.getProductType().equals(productType) && product.getPrice() > price)
        .collect(Collectors.toList());
  }

  public List<Product> getAllDiscountedProducts(ProductType productType) {
    return productList.stream()
        .filter(
            product -> product.getProductType().equals(productType) &&
                product.isDiscountAvailable())
        .map(product -> {
          double discountedPrice = product.getPrice() * 0.9;
          return new Product(product.getId(), product.getProductType(), discountedPrice,
              false,
              product.getCreatedDate());
        })
        .collect(Collectors.toList());
  }

  public Product getCheapestProduct(ProductType productType) throws Exception {
    return productList.stream()
        .filter(product -> product.getProductType().equals(productType))
        .min(Comparator.comparing(Product::getPrice))
        .orElseThrow(
            () -> new Exception("Product [category:" + productType.toString() + "] not found"));
  }

  public List<Product> getLastCreatedProducts(int amount) {
    return productList.stream()
        .sorted(Comparator.comparing(Product::getCreatedDate).reversed())
        .limit(amount)
        .collect(Collectors.toList());
  }

  public double calculateProductTypeTotalPrice(ProductType productType, double price) {
    LocalDateTime now = LocalDateTime.now();
    return productList.stream()
        .filter(
            product -> product.getProductType().equals(productType)
                && product.getPrice() <= price
                && product.getCreatedDate().getYear() == now.getYear())
        .mapToDouble(Product::getPrice)
        .sum();
  }

  public Map<ProductType, List<Product>> groupProductsByType() {
    return productList.stream()
        .collect(Collectors.groupingBy(Product::getProductType));
  }
}