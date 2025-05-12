package com.codedecode.foodcatalouge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String itemName;
    private String itemDescription;
    private boolean veg;
    private int price;
    private int restaurantId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int quantity;
    //@Builder.Default
    //private int quantity = 0;


}
