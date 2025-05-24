package com.learners.demo.controller;

import com.learners.demo.entity.Inventory;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


    @PostMapping("/add")
    public String addInventory(@Valid @RequestBody Inventory inventory) {
        if (inventory == null) {
            return "Invalid inventory data!";
        }
        Inventory newInventory = new Inventory.InventoryBuilder()
                .setName(inventory.getName())
                .setQuantity(inventory.getQuantity())
                .setPrice(inventory.getPrice())
                .setDescription(inventory.getDescription())
                .build();
        // Here you would typically save the inventory to a database
        return String.format("Inventory added: %s, Quantity: %d, Price: %.2f",
                newInventory.getName(), newInventory.getQuantity(), newInventory.getPrice());
    }
}
