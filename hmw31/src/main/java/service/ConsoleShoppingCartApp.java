package edu.hillel.service;

import java.util.Scanner;

public class ConsoleShoppingCartApp {
  private final ShoppingCartApp shoppingCartApp;
  private final Scanner scanner;

  public ConsoleShoppingCartApp(ShoppingCartApp shoppingCartApp) {
    this.shoppingCartApp = shoppingCartApp;
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    while (true) {
      displayMenu();
      String choice = scanner.nextLine();
      switch (choice) {
        case "1":
          addToCart();
          break;
        case "2":
          removeFromCart();
          break;
        case "3":
          displayCart();
          break;
        case "4":
          System.out.println("Exiting the program.");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private void displayMenu() {
    System.out.println("=== Shopping Cart Menu ===");
    System.out.println("1. Add product to cart");
    System.out.println("2. Remove product from cart");
    System.out.println("3. Display cart contents");
    System.out.println("4. Exit");
    System.out.print("Enter your choice: ");
  }

  private void addToCart() {
    System.out.print("Enter product ID: ");
    int productId = Integer.parseInt(scanner.nextLine());
    shoppingCartApp.addToCart(productId);
  }

  private void removeFromCart() {
    System.out.print("Enter product ID: ");
    int productId = Integer.parseInt(scanner.nextLine());
    shoppingCartApp.removeFromCart(productId);
  }

  private void displayCart() {
    shoppingCartApp.displayCart();
  }
}