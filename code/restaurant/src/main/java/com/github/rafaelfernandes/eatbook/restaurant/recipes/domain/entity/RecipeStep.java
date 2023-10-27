package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "RECIPE_STEP", schema = "RESTAURANT")
@Data
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @Column(name = "step", length = 100, nullable = false)
    private String step;

    @Column(name = "order", nullable = false)
    private Integer order;
}

