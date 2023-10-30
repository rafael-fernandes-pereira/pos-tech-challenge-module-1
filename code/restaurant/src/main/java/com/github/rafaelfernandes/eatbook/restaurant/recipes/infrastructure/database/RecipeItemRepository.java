package com.github.rafaelfernandes.eatbook.restaurant.recipes.infrastructure.database;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeItemRepository extends JpaRepository<RecipeItem, UUID> {
}
