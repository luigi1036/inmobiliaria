package com.tucasa.dto;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    @NotNull(message = "El id de la propiedad no puede ser nulo")
    @NotBlank(message = "El id de la propiedad no puede estar vacio")
    private String idProperty;
    @NotNull(message = "El id del usuario no puede ser nulo")
    @NotBlank(message = "El id del usuario no puede estar vacio")
    private String idUser;
    private LocalDateTime date;
    private boolean status;
}
