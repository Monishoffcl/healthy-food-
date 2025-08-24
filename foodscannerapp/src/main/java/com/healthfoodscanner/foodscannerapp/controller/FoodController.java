package com.healthfoodscanner.foodscannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthfoodscanner.foodscannerapp.model.FoodInfo;
import com.healthfoodscanner.foodscannerapp.service.FoodService;

@Controller
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/scan")
    public String scan(@RequestParam("foodName") String foodName, Model model) {
        FoodInfo result = foodService.scanFood(foodName);
        model.addAttribute("result", result);
        return "index";
    }
}
