package com.learners.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learners.demo.entity.Inventory;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(InventoryController.class);

    @PostMapping("/add")
    public ResponseEntity<String> addInventory(@Valid @RequestBody Inventory inventory) {
        if (inventory == null) {
            return new ResponseEntity<>("Invalid inventory data!", HttpStatus.CREATED);
        }
        Inventory newInventory = new Inventory.InventoryBuilder()
                .setName(inventory.getName())
                .setQuantity(inventory.getQuantity())
                .setPrice(inventory.getPrice())
                .setDescription(inventory.getDescription())
                .build();

        String response = null;
        try {
            response = new ObjectMapper().writeValueAsString(newInventory);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        ResponseEntity <String> responseEntity = new ResponseEntity<>(response, headers, HttpStatus.CREATED);
        logger.debug(responseEntity.toString());
        return responseEntity;
    }
}
