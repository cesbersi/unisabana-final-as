package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

public class ObjectDeleteException extends  Exception{

    public ObjectDeleteException(String message) {
        super(message);
    }

    public ObjectDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectDeleteException(Throwable cause) {
        super(cause);
    }


}
