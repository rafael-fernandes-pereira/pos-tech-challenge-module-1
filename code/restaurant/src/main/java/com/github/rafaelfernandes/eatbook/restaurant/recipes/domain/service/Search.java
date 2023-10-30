package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.service;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.infrastructure.database.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Search {

    private final RecipeRepository recipeRepository;

    public Recipe searchByName(String name){

        return recipeRepository.findByName(name.toUpperCase());

    }

    public Optional<Recipe> searchById(UUID id){

        return recipeRepository.findById(id);

    }

}
