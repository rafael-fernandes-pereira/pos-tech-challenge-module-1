package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponse {

    private Recipe recipe;
    private Message message;
    private LocalDateTime timestamp;
}
