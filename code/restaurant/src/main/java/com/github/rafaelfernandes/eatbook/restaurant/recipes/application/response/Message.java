package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private HttpStatus status;
    private String message;
}
