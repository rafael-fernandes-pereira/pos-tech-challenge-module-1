package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Ingredient;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Measure;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class RecipeItemInput {

    private IngredientInput ingredient;
    private Measure measure;
    private Integer amount;

}
