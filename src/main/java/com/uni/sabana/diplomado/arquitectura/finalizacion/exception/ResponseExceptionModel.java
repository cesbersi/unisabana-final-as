package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseExceptionModel {

    private String message;
    private int code;
    private String timestamp;
}
