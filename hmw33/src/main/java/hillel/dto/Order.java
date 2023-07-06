package edu.hillel.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {
  UUID id = UUID.randomUUID();
  Date date = new Date();
  double cost;
  List<Product> products;
}