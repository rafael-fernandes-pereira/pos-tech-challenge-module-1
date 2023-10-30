package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request;

import lombok.Data;


@Data
public class RecipeStepInput {

    private String step;
    private Integer position;

}
