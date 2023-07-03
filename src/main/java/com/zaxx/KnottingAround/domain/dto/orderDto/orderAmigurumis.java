package com.zaxx.KnottingAround.domain.dto.orderDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class orderAmigurumis {
    @NotBlank
    private int idAmigurumi;
    @NotBlank
    @Min(1)
    @Max(5)
    private int cantidad;
}
