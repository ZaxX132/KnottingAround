package com.zaxx.KnottingAround.domain.dto.orderDto;

import com.zaxx.KnottingAround.persistence.entity.OrderAmigurumiEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CustomerNewOrder {
    @NotBlank
    private String metodo;
    private String comentario;
    @NotNull
    private List<orderAmigurumis> amigurumis;
}
