/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

/**
 *
 * @author cabernal
 */
public class FirmaNoValidaException extends Exception {

    private static final long serialVersionUID = 7517402519869352660L;

    public FirmaNoValidaException() {
        super();
    }

    public FirmaNoValidaException(String message) {
        super(String.format("La firma no es valida. [" + message + "]"));
    }
}
