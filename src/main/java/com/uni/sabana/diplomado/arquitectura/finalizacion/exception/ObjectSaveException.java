package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

public class ObjectSaveException extends  Exception{

    public ObjectSaveException(String message) {
        super(message);
    }

    public ObjectSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectSaveException(Throwable cause) {
        super(cause);
    }


}
