package com.github.rafaelfernandes.eatbook.restaurant.recipes.application.response;

import com.github.rafaelfernandes.eatbook.restaurant.recipes.domain.valueobject.Measure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasureResponse {

    Map<Measure, String> measure;
    private Message message;
    private LocalDateTime timestamp;
}
