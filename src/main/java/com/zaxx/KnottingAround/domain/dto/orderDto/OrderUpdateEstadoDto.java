package com.zaxx.KnottingAround.domain.dto.orderDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderUpdateEstadoDto {
    @NotBlank
    @Min(0)
    private Integer id;
    @NotBlank
    private Boolean estado;
}
