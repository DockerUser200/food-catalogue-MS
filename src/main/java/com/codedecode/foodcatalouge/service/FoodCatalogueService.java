package com.codedecode.foodcatalouge.service;

import com.codedecode.foodcatalouge.dto.FoodCataloguePage;
import com.codedecode.foodcatalouge.dto.FoodItemDTO;
import com.codedecode.foodcatalouge.dto.RestaurantDTO;
import com.codedecode.foodcatalouge.entity.FoodItem;
import com.codedecode.foodcatalouge.mapper.FoodItemMapper;
import com.codedecode.foodcatalouge.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.foodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.foodItemToFoodItemDTO(savedFoodItem);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItemDTO> foodItemsList = fetchFoodItemList(restaurantId);
        RestaurantDTO restaurantDetails = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemsList, restaurantDetails);
    }

    private List<FoodItemDTO> fetchFoodItemList(Integer restaurantId) {
        List<FoodItem> foodItem = foodItemRepository.findByRestaurantId(restaurantId);
        return foodItem.stream().map(FoodItemMapper.INSTANCE::foodItemToFoodItemDTO).toList();
    }

    private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchById/" + restaurantId, RestaurantDTO.class);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItemDTO> foodItemsList, RestaurantDTO restaurantDetails) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemsList);
        foodCataloguePage.setRestaurant(restaurantDetails);
        return foodCataloguePage;
    }

}
