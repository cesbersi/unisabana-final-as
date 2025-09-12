package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;

public class ObjectFindException extends  Exception{

    public ObjectFindException(String message) {
        super(message);
    }

    public ObjectFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectFindException(Throwable cause) {
        super(cause);
    }


}
