package com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject;

public enum Measure {

    TEASPOON("Colher de chá"),
    TABLESPOON("Colher de sopa"),
    CUP("Copo"),
    GRAM("Grama"),
    KILOGRAM("Kilograma"),
    MILLILITER("Mililitros"),
    LITER("Litro"),
    PIECE("Parte");

    private String displayName;

    Measure(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
