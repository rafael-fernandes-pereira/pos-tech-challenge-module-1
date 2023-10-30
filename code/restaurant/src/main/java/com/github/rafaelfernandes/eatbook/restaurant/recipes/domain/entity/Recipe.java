package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "RECIPE", schema = "RESTAURANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<RecipeItem> recipeItems;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<RecipeStep> recipeSteps;
}