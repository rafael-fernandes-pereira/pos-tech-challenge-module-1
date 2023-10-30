package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.dto;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.IngredientInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.RecipeInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.RecipeItemInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.RecipeStepInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.RecipeItem;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.RecipeStep;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Ingredient;

import java.util.List;
import java.util.stream.Collectors;


public class Converter {

    public static Ingredient toEntity(IngredientInput input){

        Ingredient ingredient = new Ingredient();
        ingredient.setName(input.getName().toUpperCase());

        return ingredient;
    }

    public static RecipeItem toEntity(RecipeItemInput input) {

        Ingredient ingredient = Converter.toEntity(input.getIngredient());

        RecipeItem recipeItem = new RecipeItem();
        recipeItem.setIngredient(ingredient);
        recipeItem.setAmount(input.getAmount());
        recipeItem.setMeasure(input.getMeasure());

        return recipeItem;
    }


    public static RecipeStep toEntity(RecipeStepInput input){

        RecipeStep recipeStep = new RecipeStep();
        recipeStep.setStep(input.getStep().toUpperCase());
        recipeStep.setPosition(input.getPosition());

        return recipeStep;
    }

    public static Recipe toEntity(RecipeInput input){

        List<RecipeItem> recipeItemList = input.getItens()
                .stream()
                .map(Converter::toEntity)
                .collect(Collectors.toList());

        List<RecipeStep> recipeStepList = input.getSteps()
                .stream()
                .map(Converter::toEntity)
                .collect(Collectors.toList());

        Recipe recipe = new Recipe();
        recipe.setName(input.getName().toUpperCase());
        recipe.setRecipeItems(recipeItemList);
        recipe.setRecipeSteps(recipeStepList);

        return recipe;

    }

}
