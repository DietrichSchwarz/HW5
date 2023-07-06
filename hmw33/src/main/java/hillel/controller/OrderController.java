package edu.hillel.controller;

import edu.hillel.dto.Order;
import edu.hillel.repo.OrderRepository;
import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
  private OrderRepository orderRepository;

  @Autowired
  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @GetMapping("/{id}")
  public String getOrderById(@PathVariable UUID id, Model model) {
    model.addAttribute("order", orderRepository.getOrderById(id));

    return "order/orderById";
  }

  @GetMapping
  public String getAllOrders(Model model) {
    model.addAttribute("orders", orderRepository.getAllOrders());

    return "order/allOrders";
  }

  @GetMapping("/create")
  public String createOrder(@ModelAttribute("order") Order order) {
    return "order/addOrder";
  }

  @PostMapping
  public String addOrder(@ModelAttribute("order") Order order) {
    orderRepository.addOrder(order);
    return "redirect:/orders";
  }
}