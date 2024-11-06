package com.example.unittesting_tasks.shoppingCart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Item, Integer> items = new HashMap<>();

    public void addItem(Item item, int quantity){
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getItemCount() {
        return items.size();
    }
}
