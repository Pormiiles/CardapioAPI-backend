package com.example.cardapio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardapio.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
