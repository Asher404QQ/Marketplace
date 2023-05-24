package ru.kors.marketplace.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private String structure;
    private int price;
    private int weight;
    private String author;
}
