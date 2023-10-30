package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject;

import lombok.Getter;

@Getter
public enum Measure {

    TEASPOON("Colher de chá"),
    TABLESPOON("Colher de sopa"),
    CUP("Xícara"),
    GRAM("Grama"),
    KILOGRAM("Kilograma"),
    MILLILITER("Mililitros"),
    LITER("Litro"),
    PIECE("Parte");

    private final String displayName;

    Measure(String displayName) {
        this.displayName = displayName;
    }


}
