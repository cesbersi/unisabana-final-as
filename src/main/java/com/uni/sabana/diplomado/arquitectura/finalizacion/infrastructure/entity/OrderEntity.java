package com.uni.sabana.diplomado.arquitectura.finalizacion.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "El nombre no puede estar vacio")
    @Basic
    private String name;

    @Min(value = 1, message = "La cantidad minima es 1")
    @Basic
    private Integer quantity;

    @Basic
    private String idTransaction;

    @Basic
    private String podName;
}
