package edu.hillel.dto;


import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
  UUID id = UUID.randomUUID();
  String name;
  double cost;
}
