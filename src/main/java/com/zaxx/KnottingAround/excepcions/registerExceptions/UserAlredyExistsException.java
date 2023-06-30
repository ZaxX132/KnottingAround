package com.zaxx.KnottingAround.excepcions.registerExceptions;

import javax.naming.AuthenticationException;

public class UserAlredyExistsException extends AuthenticationException {
    public UserAlredyExistsException(final String msg){
        super(msg);
    }
}
