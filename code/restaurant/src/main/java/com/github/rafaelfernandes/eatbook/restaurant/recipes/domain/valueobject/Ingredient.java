package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.entity.RecipeItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.UUID;

@Entity
@Table(name = "INGREDIENT", schema = "RESTAURANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsExclude
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "id")
    private RecipeItem recipeItem;


}

