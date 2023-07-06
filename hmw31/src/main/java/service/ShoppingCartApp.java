package edu.hillel.service;

import edu.hillel.model.Cart;
import edu.hillel.model.Product;
import edu.hillel.repo.ProductRepository;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ShoppingCartApp {
  private final ProductRepository productRepository;
  private final Cart cart;

  public ShoppingCartApp(ProductRepository productRepository, Cart cart) {
    this.productRepository = productRepository;
    this.cart = cart;
  }

  public void addToCart(int productId) {
    Product product = productRepository.getProductById(productId);
    if (product != null) {
      cart.addProduct(product);
      log.info("Product added to cart: " + product.getName());
    } else {
      log.error("Product not found.");
    }
  }

  public void removeFromCart(int productId) {
    Product product = productRepository.getProductById(productId);
    if (product != null) {
      cart.removeProduct(productId);
      log.info("Product removed from cart: " + product.getName());
    } else {
      log.error("Product not found in cart.");
    }
  }

  public void displayCart() {
    List<Product> products = cart.getProducts();
    if (products.isEmpty()) {
      log.warn("Cart is empty.");
    } else {
      log.info("Cart contents:");
      for (Product product : products) {
        System.out.println(product.getName() + " - $" + product.getCost());
      }
    }
  }
}