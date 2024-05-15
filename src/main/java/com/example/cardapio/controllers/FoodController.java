package com.example.cardapio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.domain.Food;
import com.example.cardapio.dtos.FoodDataDTO;
import com.example.cardapio.repositories.FoodRepository;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Food>> getAll() {
        List<Food> foodList = this.foodRepository.findAll();

        return ResponseEntity.ok(foodList);
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveNewFood(@RequestBody FoodDataDTO data) {
        Food newFood = new Food(data);

        this.foodRepository.save(newFood);
    }
}
