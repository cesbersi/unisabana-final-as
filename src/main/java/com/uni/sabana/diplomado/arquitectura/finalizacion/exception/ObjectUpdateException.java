package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

public class ObjectUpdateException extends  Exception{

    public ObjectUpdateException(String message) {
        super(message);
    }

    public ObjectUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectUpdateException(Throwable cause) {
        super(cause);
    }


}
