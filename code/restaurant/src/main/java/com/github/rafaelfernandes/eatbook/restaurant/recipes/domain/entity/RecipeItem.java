package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Ingredient;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Measure;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "RECIPE_ITEM", schema = "RESTAURANT")
@Data
public class RecipeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure", length = 20, nullable = false)
    private Measure measure;

    @Column(name = "amount")
    private Integer amount;
}
