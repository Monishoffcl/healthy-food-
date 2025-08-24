package com.healthfoodscanner.foodscannerapp.service;

import com.healthfoodscanner.foodscannerapp.model.FoodInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FoodService {

    private static final Map<String, FoodInfo> FOOD_DB = new HashMap<>();

    static {
        // Indian
        FOOD_DB.put("idli", new FoodInfo("Idli", 39, "Light, steamed, easily digestible", "Yes", "/images/idli.jpg"));
        FOOD_DB.put("biryani", new FoodInfo("Biryani", 300, "Protein-rich but oily", "Occasionally", "/images/biryani.jpg"));
        FOOD_DB.put("samosa", new FoodInfo("Samosa", 262, "Fried, high in carbs and fat", "No", "/images/samosa.jpg"));

        // Global
        FOOD_DB.put("sushi", new FoodInfo("Sushi", 130, "Rich in omega-3s, lean protein", "Yes", "/images/sushi.jpg"));
        FOOD_DB.put("pizza", new FoodInfo("Pizza", 285, "Tasty but high in sodium", "No", "/images/pizza.jpg"));
        FOOD_DB.put("salad", new FoodInfo("Salad", 80, "High in fiber and vitamins", "Yes", "/images/salad.jpg"));
        FOOD_DB.put("burger", new FoodInfo("Burger", 295, "High fat, low nutrition", "No", "/images/burger.jpg"));
        FOOD_DB.put("pasta", new FoodInfo("Pasta", 221, "Good source of carbs", "Moderate", "/images/pasta.jpg"));
        FOOD_DB.put("apple", new FoodInfo("Apple", 52, "Rich in fiber and vitamin C", "Yes", "/images/apple.jpg"));
        FOOD_DB.put("banana", new FoodInfo("Banana", 89, "Great for energy and potassium", "Yes", "/images/banana.jpg"));
    }

    public FoodInfo scanFood(String foodName) {
        return FOOD_DB.getOrDefault(
                foodName.toLowerCase(),
                new FoodInfo(foodName, 0, "Information not available", "Unknown", "/images/unknown.jpg")
        );
    }
}



