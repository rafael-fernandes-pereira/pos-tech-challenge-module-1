package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.advice;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response.Message;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response.RecipeResponse;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.exception.RecipeFoundException;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.exception.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = {
    "com.github.rafaelfernandes.eatbook.restaurant.recipes.application.service"
})
public class RecipeControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RecipeFoundException.class)
    public RecipeResponse handleRecipeFound(RecipeFoundException recipeFoundException){
        RecipeResponse recipeResponse = new RecipeResponse();
        Message message = new Message();
        recipeResponse.setMessage(message);
        message.setStatus(HttpStatus.CONFLICT);
        message.setMessage("Receita já está cadastrada!");

        return recipeResponse;

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecipeNotFoundException.class)
    public RecipeResponse handleRecipeFound(RecipeNotFoundException recipeFoundException){
        RecipeResponse recipeResponse = new RecipeResponse();
        Message message = new Message();
        recipeResponse.setMessage(message);
        message.setStatus(HttpStatus.NOT_FOUND);
        message.setMessage("Receita não existe!");

        return recipeResponse;

    }

}
