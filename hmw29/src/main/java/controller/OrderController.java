package edu.hillel.controller;

import edu.hillel.dto.Order;
import edu.hillel.service.OrderService;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/orders")
public class OrderController {
  private final OrderService service = new OrderService();

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response addOrder(Order order) {
    return Response.ok(service.addOrder(order)).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOrderById(@PathParam("id") UUID id) {
    return Response.ok(service.getOrderById(id)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOrders() {
    return Response.ok(service.getAllOrders()).build();
  }
}