package com.learners.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class Inventory {
    private final String id = UUID.randomUUID().toString();

    @NotNull private String name;
    @NotNull private String description;
    @NotNull private Integer quantity;
    @NotNull private Double price;

    public Inventory() {
        super();
    }

    public Inventory(InventoryBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }


    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static class InventoryBuilder {
        String name;
        String description;
        Integer quantity;
        Double price;

        public InventoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public InventoryBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public InventoryBuilder setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public InventoryBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }
    }
}
