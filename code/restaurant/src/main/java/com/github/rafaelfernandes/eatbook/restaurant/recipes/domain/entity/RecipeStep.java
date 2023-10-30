package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "RECIPE_STEP", schema = "RESTAURANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonBackReference
    private Recipe recipe;

    @Column(name = "step", length = 100, nullable = false)
    private String step;

    @Column(name = "position", nullable = false)
    private Integer position;
}

