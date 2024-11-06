package com.example.unittesting_tasks;

import com.example.unittesting_tasks.shoppingCart.Item;
import com.example.unittesting_tasks.shoppingCart.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    ShoppingCart cart;
    Item item1, item2;


    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        item1 = new Item("Apple", 10.0);
        item2 = new Item("Books", 15.30);
    }

    @Test
    void testAddItem() {
        cart.addItem(item1, 1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testRemoveItem() {
        cart.addItem(item2, 1);
        cart.removeItem(item2);
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void testGetTotalPrice() {
        cart.addItem(item1, 5);
        cart.addItem(item2, 10);
        assertEquals(203.0, cart.getTotalPrice());
    }

}
