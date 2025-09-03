package com.feirinha.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ItemsDTO {
  @NotBlank @NotEmpty @NotNull private String name;
  @NotNull @Positive private Integer quantity;
}
