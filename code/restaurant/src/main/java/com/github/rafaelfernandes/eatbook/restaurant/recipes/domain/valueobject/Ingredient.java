package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "INGREDIENT", schema = "RESTAURANT")
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
}

