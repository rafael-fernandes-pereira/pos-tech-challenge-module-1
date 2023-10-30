package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Ingredient;
import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Measure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "RECIPE_ITEM", schema = "RESTAURANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonBackReference
    private Recipe recipe;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ingredient_id", nullable = false)
    @JsonBackReference
    private Ingredient ingredient;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure", length = 20, nullable = false)
    private Measure measure;

    @Column(name = "amount")
    private Integer amount;
}
