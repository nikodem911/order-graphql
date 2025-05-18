package com.order.ordergraphql.infrastructure.inmemory;

import com.order.ordergraphql.domain.customer.Customer;
import com.order.ordergraphql.domain.order.Order;
import com.order.ordergraphql.domain.order.OrderItem;
import com.order.ordergraphql.domain.product.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Getter
@Slf4j
class InMemoryDB {
    private final List<Product> products = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public InMemoryDB() {
        generateRandomData(10, 10, 100);
    }

    public void generateRandomData(int numProducts, int numCustomers, int numOrders) {
        log.info("Generating random data for {} products, {} customers and {} orders", numProducts, numCustomers, numOrders);
        var faker = new Faker();
        var random = new Random();
        // Generate products
        for (int i = 0; i < numProducts; i++) {
            String id = String.valueOf(i + 1);
            String name = faker.commerce().productName();
            String ean = faker.number().digits(13);
            double price = Double.parseDouble(faker.commerce().price(10.0, 1000.0).replace(",", "."));
            
            products.add(new Product(id, name, ean, price));
        }
        
        // Generate customers
        for (int i = 0; i < numCustomers; i++) {
            String id = String.valueOf(i + 1);
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            
            customers.add(new Customer(id, firstName, lastName));
        }
        
        // Generate orders
        for (int i = 0; i < numOrders; i++) {
            String orderId = String.valueOf(i + 1);
            
            // Select a random customer
            String customerId = customers.get(random.nextInt(customers.size())).id();
            
            // Generate random number of order items (between 1 and 10)
            int numOrderItems = random.nextInt(10) + 1;
            List<OrderItem> orderItems = new ArrayList<>();
            
            for (int j = 0; j < numOrderItems; j++) {
                String itemId = orderId + "-" + (j + 1);
                
                // Select a random product
                String productId = products.get(random.nextInt(products.size())).id();
                
                // Generate random quantity (between 1 and 100)
                int quantity = random.nextInt(100) + 1;
                
                orderItems.add(new OrderItem(itemId, productId, quantity));
            }
            
            orders.add(new Order(orderId, orderItems, customerId));
        }
    }
}

