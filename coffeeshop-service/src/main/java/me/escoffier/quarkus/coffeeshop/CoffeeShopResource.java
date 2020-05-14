package me.escoffier.quarkus.coffeeshop;

import io.smallrye.mutiny.Uni;
import me.escoffier.quarkus.coffeeshop.http.BaristaService;
import me.escoffier.quarkus.coffeeshop.model.Beverage;
import me.escoffier.quarkus.coffeeshop.model.Order;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CoffeeShopResource {

    @Inject
    @RestClient
    BaristaService barista;

    @POST
    @Path("/http")
    public Uni<Beverage> http(Order order) {
        return barista.order(order.setOrderId(getId()));
    }

    // orders channel

    // queue channel

    @POST
    @Path("/messaging")
    public Order messaging(Order order) {
        order.setOrderId(getId());
        
        return order;
    }

    private String getId() {
        return UUID.randomUUID().toString();
    }

}
