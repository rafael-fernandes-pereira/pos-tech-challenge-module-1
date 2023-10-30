package com.github.rafaelfernandes.eatbook.restaurant.recipes.infrastructure.database;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    @Query("SELECT I FROM Ingredient I WHERE I.name IN :LIST")
    List<Ingredient> findAllByNames(@Param("LIST") List<String> itemNames);
}
