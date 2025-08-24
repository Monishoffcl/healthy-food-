package com.healthfoodscanner.foodscannerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodInfo {
    private String foodName;
    private int calories;
    private String healthBenefits;
    private String goodForIntake;
    private String imageUrl;
}
