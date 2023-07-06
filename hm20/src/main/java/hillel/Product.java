package edu.hillel;

import java.time.LocalDateTime;
import lombok.Value;

@Value
public class Product {
  int id;
  ProductType productType;
  double price;
  boolean isDiscountAvailable;
  LocalDateTime createdDate;
}