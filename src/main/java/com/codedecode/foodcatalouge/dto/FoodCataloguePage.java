package com.codedecode.foodcatalouge.dto;

import com.codedecode.foodcatalouge.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

    private List<FoodItemDTO> foodItemsList;
    private RestaurantDTO restaurant;

}
