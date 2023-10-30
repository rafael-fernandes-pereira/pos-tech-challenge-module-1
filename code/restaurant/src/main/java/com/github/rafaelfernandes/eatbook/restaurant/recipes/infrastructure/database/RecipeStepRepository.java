package com.github.rafaelfernandes.eatbook.restaurant.recipes.infrastructure.database;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, UUID> {
}
