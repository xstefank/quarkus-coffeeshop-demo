package me.escoffier.quarkus.coffeeshop;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/barista")
@Produces(MediaType.APPLICATION_JSON)
public class BaristaResource {

    private Random random = new Random();

    @ConfigProperty(name = "barista.name")
    String name;

    @POST
    public CompletionStage<Beverage> prepare(Order order) {
        System.out.println("Barista " + name + " is going to prepare a " + order.getProduct());
        return makeIt(order)
            .thenApply(beverage -> {
                System.out.printf("Order %s for %s is ready%n%n", order.getProduct(), order.getName());
                return beverage;
            });
    }

    private CompletionStage<Beverage> makeIt(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Preparing a " + order.getProduct());
            prepare();
            return new Beverage(order, name);
        });
    }

    private void prepare() {
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
