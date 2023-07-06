package edu.hillel.config;

import edu.hillel.model.Cart;
import edu.hillel.repo.ProductRepository;
import edu.hillel.service.ConsoleShoppingCartApp;
import edu.hillel.service.ShoppingCartApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public ProductRepository productRepository() {
    return new ProductRepository();
  }

  @Bean
  public Cart cart() {
    return new Cart();
  }

  @Bean
  public ShoppingCartApp shoppingCartApp(ProductRepository productRepository, Cart cart) {
    return new ShoppingCartApp(productRepository, cart);
  }

  @Bean
  public ConsoleShoppingCartApp consoleShoppingCartApp(ShoppingCartApp shoppingCartApp) {
    return new ConsoleShoppingCartApp(shoppingCartApp);
  }
}
