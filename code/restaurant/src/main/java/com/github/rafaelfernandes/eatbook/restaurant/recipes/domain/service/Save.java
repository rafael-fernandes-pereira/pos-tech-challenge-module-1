package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.service;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.RecipeInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.dto.Converter;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.RecipeItem;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Ingredient;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.infrastructure.database.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Save {

    private final IngredientRepository ingredientRepository;
    private final RecipeItemRepository recipeItemRepository;
    private final RecipeStepRepository recipeStepRepository;
    private final RecipeRepository recipeRepository;

    public Recipe execute(RecipeInput input){

        Recipe recipe = Converter.toEntity(input);

        List<String> ingredientListToSave = recipe.getRecipeItems()
                .stream()
                .map(RecipeItem::getIngredient)
                .map(Ingredient::getName)
                .collect(Collectors.toList());

        List<Ingredient> ingredientListSaved = ingredientRepository.findAllByNames(ingredientListToSave);

        List<RecipeItem> recipeItemsToSave = new ArrayList<>();

        for (RecipeItem item: recipe.getRecipeItems()){
            Ingredient ingredient = ingredientListSaved.stream()
                    .filter(ingredient1 -> ingredient1.getName().equals(item.getIngredient().getName()))
                    .findFirst()
                    .orElse(null);

            Ingredient ingredientSaved = (Objects.isNull(ingredient)) ? ingredientRepository.save(item.getIngredient()) : ingredient;

            item.setIngredient(ingredientSaved);

            recipeItemsToSave.add(item);

        }

        Recipe recipeSaved = recipeRepository.save(recipe);

        recipeItemsToSave.forEach(item -> item.setRecipe(recipeSaved));

        recipeItemRepository.saveAll(recipeItemsToSave);

        recipe.getRecipeSteps()
                .forEach(recipeStep -> recipeStep.setRecipe(recipeSaved))
        ;

        recipeStepRepository.saveAll(recipe.getRecipeSteps());

        return recipeSaved;

    }

}
