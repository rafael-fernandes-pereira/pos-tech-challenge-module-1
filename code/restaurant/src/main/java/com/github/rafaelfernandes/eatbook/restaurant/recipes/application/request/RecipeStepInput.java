package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class RecipeStepInput {

    private String step;
    private Integer position;

}
