package com.tucasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rent {

    @Id
    private String id;
    private String idProperty;
    private String idUser;
    private LocalDateTime date;
    private boolean status;
}
