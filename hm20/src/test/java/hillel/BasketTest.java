package edu.hillel;

import java.util.Arrays;
import java.util.HashMap;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;


public class BasketTest {

  @Test
  void getAllProductsWithPriceTest() {
    Basket basket = new Basket();
    Basket expectedBasket = new Basket();
    ProductBuilder book = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(50);
    ProductBuilder book2 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(300);
    ProductBuilder book3 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(450);
    basket.add(book.getProduct());
    basket.add(book2.getProduct());
    basket.add(book3.getProduct());

    expectedBasket.add(book2.getProduct());
    expectedBasket.add(book3.getProduct());

    Assertions.assertEquals(expectedBasket.getProductList(),
        basket.getAllProductsWithPrice(ProductType.BOOK, 250));
  }

  @Test
  void getAllDiscountedProductsTest() {
    Basket basket = new Basket();
    Basket expectedBasket = new Basket();
    ProductBuilder book = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(50);
    ProductBuilder book2 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(300)
        .buildIsDiscountAvailable(false);
    ProductBuilder book3 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(450)
        .buildIsDiscountAvailable(true);
    basket.add(book.getProduct());
    basket.add(book2.getProduct());
    basket.add(book3.getProduct());

    book3
        .buildPrice(450 * 0.9)
        .buildIsDiscountAvailable(false);
    expectedBasket.add(book3.getProduct());

    Assertions.assertEquals(expectedBasket.getProductList(),
        basket.getAllDiscountedProducts(ProductType.BOOK));
  }

  @Test
  @SneakyThrows
  void getCheapestProductTest() {
    Basket basket = new Basket();
    Basket expectedBasket = new Basket();
    ProductBuilder book = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(50);
    ProductBuilder book2 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(300)
        .buildIsDiscountAvailable(false);
    ProductBuilder book3 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(450)
        .buildIsDiscountAvailable(true);
    basket.add(book.getProduct());
    basket.add(book2.getProduct());
    basket.add(book3.getProduct());

    expectedBasket.add(book.getProduct());

    Assertions.assertEquals(expectedBasket.getProductList().get(0),
        basket.getCheapestProduct(ProductType.BOOK));
  }

  @Test
  void getLastCreatedProductsTest() throws InterruptedException {
    Basket basket = new Basket();
    Basket expectedBasket = new Basket();
    ProductBuilder book = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(50);
    Thread.sleep(100);
    ProductBuilder toy = new ProductBuilderImpl()
        .buildProductType(ProductType.TOY)
        .buildPrice(200);
    Thread.sleep(100);
    ProductBuilder book2 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(300)
        .buildIsDiscountAvailable(false);
    Thread.sleep(100);
    ProductBuilder toy2 = new ProductBuilderImpl()
        .buildProductType(ProductType.TOY)
        .buildPrice(400);
    Thread.sleep(100);
    ProductBuilder book3 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(450)
        .buildIsDiscountAvailable(true);
    basket.add(book.getProduct());
    basket.add(toy.getProduct());
    basket.add(book2.getProduct());
    basket.add(toy2.getProduct());
    basket.add(book3.getProduct());

    expectedBasket.add(book3.getProduct());
    expectedBasket.add(toy2.getProduct());
    expectedBasket.add(book2.getProduct());

    Assertions.assertEquals(expectedBasket.getProductList(),
        basket.getLastCreatedProducts(3));
  }

  @Test
  void calculateProductTypeTotalPriceTest() {
    Basket basket = new Basket();
    double expectedTotalPrice = 125.0;
    ProductBuilder book = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(50);
    ProductBuilder book2 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(75)
        .buildIsDiscountAvailable(false);
    ProductBuilder book3 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(450);
    basket.add(book.getProduct());
    basket.add(book2.getProduct());
    basket.add(book3.getProduct());

    Assertions.assertEquals(expectedTotalPrice,
        basket.calculateProductTypeTotalPrice(ProductType.BOOK, 75));
  }

  @Test
  void groupProductsByTypeTest() {
    Basket basket = new Basket();
    Map<ProductType, List<Product>> expectedMap = new HashMap<>();
    ProductBuilder book = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(50);
    ProductBuilder toy = new ProductBuilderImpl()
        .buildProductType(ProductType.TOY)
        .buildPrice(200);
    ProductBuilder book2 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(300);
    ProductBuilder toy2 = new ProductBuilderImpl()
        .buildProductType(ProductType.TOY)
        .buildPrice(400);
    ProductBuilder book3 = new ProductBuilderImpl()
        .buildProductType(ProductType.BOOK)
        .buildPrice(450);
    basket.add(book.getProduct());
    basket.add(toy.getProduct());
    basket.add(book2.getProduct());
    basket.add(toy2.getProduct());
    basket.add(book3.getProduct());

    expectedMap.put(ProductType.BOOK, Arrays.asList(
        book.getProduct(),
        book2.getProduct(),
        book3.getProduct()
    ));
    expectedMap.put(ProductType.TOY, Arrays.asList(
        toy.getProduct(),
        toy2.getProduct()
    ));

    Assertions.assertEquals(expectedMap,
        basket.groupProductsByType());
  }
}
