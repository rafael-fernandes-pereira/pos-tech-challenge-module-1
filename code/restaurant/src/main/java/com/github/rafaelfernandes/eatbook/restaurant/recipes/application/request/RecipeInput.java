package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request;

import lombok.Data;

import java.util.List;

@Data
public class RecipeInput {

    private String name;
    private List<RecipeItemInput> itens;
    private List<RecipeStepInput> steps;

}
