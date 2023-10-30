package com.github.rafaelfernandes.eatbook.restaurant.recipes.infrastructure.database;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    Recipe findByName(String name);
}
