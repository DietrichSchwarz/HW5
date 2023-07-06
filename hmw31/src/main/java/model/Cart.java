package edu.hillel.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Value;

@Value
public class Cart {
  List<Product> products;

  public Cart() {
    products = new ArrayList<>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void removeProduct(int id) {
    products.removeIf(product -> product.getId() == id);
  }
}