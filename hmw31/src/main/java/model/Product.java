package edu.hillel.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  int id;
  String name;
  Double cost;
}
