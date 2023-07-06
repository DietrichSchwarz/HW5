package edu.hillel;

public interface ProductBuilder {
  ProductBuilder buildProductType(ProductType productType);

  ProductBuilder buildPrice(double price);

  ProductBuilder buildIsDiscountAvailable(boolean isDiscountAvailable);

  Product getProduct();
}