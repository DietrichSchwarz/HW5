package edu.hillel.repo;

import edu.hillel.model.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.Value;

@Value
public class ProductRepository {
  List<Product> products;

  public ProductRepository() {
    products = new ArrayList<>();
    products.add(new Product(1, "Product 1", 10.0));
    products.add(new Product(2, "Product 2", 20.0));
    products.add(new Product(3, "Product 3", 30.0));
  }

  public List<Product> getAllProducts() {
    return products;
  }

  public Product getProductById(int id) {
    for (Product product : products) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }
}