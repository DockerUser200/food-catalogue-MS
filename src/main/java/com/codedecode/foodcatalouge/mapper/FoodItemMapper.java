package com.codedecode.foodcatalouge.mapper;

import com.codedecode.foodcatalouge.dto.FoodItemDTO;
import com.codedecode.foodcatalouge.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem foodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO foodItemToFoodItemDTO(FoodItem foodItem);

}
