package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.service;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.RecipeInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.request.RecipeStepInput;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response.Message;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response.RecipeResponse;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.exception.RecipeFoundException;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.exception.RecipeNotFoundException;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.service.Save;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.service.Search;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final Save save;
    private final Search search;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RecipeResponse> create(@RequestBody @Valid RecipeInput input) throws RecipeFoundException {

        Recipe recipeExist = search.searchByName(input.getName());

        if (!ObjectUtils.isEmpty(recipeExist)){
            throw new RecipeFoundException();
        }

        RecipeResponse response = new RecipeResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setRecipe(save.execute(input));
        Message message = new Message();
        message.setMessage("Receita cadastrada com sucesso!");
        message.setStatus(HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RecipeResponse> getById(@PathVariable("id") @Valid UUID id) throws RecipeNotFoundException {

        Optional<Recipe> recipe = search.searchById(id);

        if (recipe.isEmpty()) throw new RecipeNotFoundException();

        RecipeResponse response = new RecipeResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setRecipe(recipe.get());
        Message message = new Message();
        message.setMessage("Receita encontrada!");
        message.setStatus(HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RecipeResponse> searchByName(
            @RequestParam(value = "name", required = true) String name
    ) throws RecipeNotFoundException {

        Optional<Recipe> recipe = Optional.ofNullable(search.searchByName(name));

        if (recipe.isEmpty()) throw new RecipeNotFoundException();

        RecipeResponse response = new RecipeResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setRecipe(recipe.get());
        Message message = new Message();
        message.setMessage("Receita encontrada!");
        message.setStatus(HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
