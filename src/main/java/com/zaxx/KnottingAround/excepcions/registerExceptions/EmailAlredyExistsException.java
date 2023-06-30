package com.zaxx.KnottingAround.excepcions.registerExceptions;

import javax.naming.AuthenticationException;

public class EmailAlredyExistsException extends AuthenticationException {
    public EmailAlredyExistsException(final String msg){
        super(msg);
    }
}
