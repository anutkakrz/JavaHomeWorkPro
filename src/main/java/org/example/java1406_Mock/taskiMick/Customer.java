package org.example.java1406_Mock.taskiMick;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

public class Customer {
    private int id;
    private String name;
}

@AllArgsConstructor
@Getter
class Item {
    private int id;
    private String name;
}

@AllArgsConstructor
@Getter
class PurchaseOrder {
    private int id;
    private Customer customer;
    private Item item;
}

interface OrderRepository {
    void save(PurchaseOrder order);

    PurchaseOrder findById(int id);
}

class OrderRepositoryImpl implements OrderRepository {
    private Map<Integer, PurchaseOrder> orders = new HashMap<>();

    @Override
    public void save(PurchaseOrder order) {
        orders.put(order.getId(), order);
    }

    @Override
    public PurchaseOrder findById(int id) {
        return orders.get(id);
    }
}

class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(PurchaseOrder order) {
        orderRepository.save(order);
    }

    public PurchaseOrder getOrder(int id) {
        return orderRepository.findById(id);
    }
}


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    PurchaseOrder order;
    @BeforeEach
    void setUp() {

    }



    @Test
    void testPlaceOrder() {
        orderService.placeOrder(order);
        verify(orderRepository).save(order);
    }

    @Test
    void testGetOrder() {
        orderService.getOrder(1);
        verify(orderRepository).findById(1);
    }

}
