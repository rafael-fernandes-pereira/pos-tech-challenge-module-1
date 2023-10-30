package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Measure;
import lombok.Data;

@Data
public class RecipeItemInput {

    private IngredientInput ingredient;
    private Measure measure;
    private Integer amount;

}
