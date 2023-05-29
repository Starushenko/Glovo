package com.example.glovo.service;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.glovo.entity.OrderEntity;
import com.example.glovo.entity.ProductEntity;
import com.example.glovo.model.Order;
import com.example.glovo.repository.OrderRepository;
import com.example.glovo.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class OrderServiceTest {

    private OrderService orderService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderRepository, productRepository);
    }

    @Test
    public void testGetOrder() {
        OrderEntity orderEntity = OrderEntity.builder()
                .id(1)
                .date("2023-05-25")
                .cost(100)
                .build();
        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(ProductEntity.builder()
                .id(1)
                .name("Product 1")
                .cost(50)
                .order(1)
                .build());
        productEntities.add(ProductEntity.builder()
                .id(2)
                .name("Product 2")
                .cost(75)
                .order(1)
                .build());

        when(orderRepository.findById(1)).thenReturn(Optional.of(orderEntity));
        when(productRepository.findByOrder(1)).thenReturn(productEntities);

        Order result = orderService.get(1);

        verify(orderRepository).findById(1);
        verify(productRepository).findByOrder(1);

        assertEquals(1, result.getId());
        assertEquals("2023-05-25", result.getDate());
        assertEquals(100, result.getCost());
        assertEquals(2, result.getProducts().size());
        assertEquals("Product 1", result.getProducts().get(0).getName());
        assertEquals(50, result.getProducts().get(0).getCost());
        assertEquals("Product 2", result.getProducts().get(1).getName());
        assertEquals(75, result.getProducts().get(1).getCost());
    }

    @Test
    public void testGetOrders() {
        List<OrderEntity> orderEntities = new ArrayList<>();
        orderEntities.add(OrderEntity.builder()
                .id(1)
                .date("2023-05-25")
                .cost(100)
                .build());
        orderEntities.add(OrderEntity.builder()
                .id(2)
                .date("2023-05-26")
                .cost(200)
                .build());

        when(orderRepository.findAll()).thenReturn(orderEntities);
        List<Order> result = orderService.getOrders();
        verify(orderRepository).findAll();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("2023-05-25", result.get(0).getDate());
        assertEquals(100, result.get(0).getCost());
        assertEquals(2, result.get(1).getId());
        assertEquals("2023-05-26", result.get(1).getDate());
        assertEquals(200, result.get(1).getCost());
    }

    @Test
    public void testCreateOrder() {
        Order order = Order.builder()
                .date("2023-05-27")
                .cost(150)
                .products(new ArrayList<>())
                .build();
        OrderEntity orderEntity = OrderEntity.builder()
                .id(3)
                .date("2023-05-27")
                .cost(150)
                .build();

        when(orderRepository.save(Mockito.any(OrderEntity.class))).thenReturn(orderEntity);

        Order result = orderService.create(order);

        verify(orderRepository).save(Mockito.any(OrderEntity.class));
        verify(productRepository, times(0)).save(Mockito.any(ProductEntity.class));


        assertEquals(3, result.getId());
        assertEquals("2023-05-27", result.getDate());
        assertEquals(150, result.getCost());
        assertEquals(0, result.getProducts().size());
    }

    @Test
    public void testDeleteOrder() {
        orderService.delete(4);
        verify(orderRepository).deleteById(4);
    }
}
