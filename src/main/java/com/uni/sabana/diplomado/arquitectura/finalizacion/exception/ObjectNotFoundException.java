
package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

/**
 * @author cabernal
 */
public class ObjectNotFoundException extends Exception {

    private static final long serialVersionUID = 7517402519869352660L;

    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String typeObject, String id) {
        super(String.format("No se encontró el dato %s con el id: %s", typeObject, id));
    }
}
