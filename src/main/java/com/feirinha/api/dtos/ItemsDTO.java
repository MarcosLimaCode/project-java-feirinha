package com.feirinha.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemsDTO {
  @NotBlank private String name;
  @NotBlank private Integer quantity;
}
