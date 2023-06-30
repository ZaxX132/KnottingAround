package com.zaxx.KnottingAround.excepcions.registerExceptions;

import javax.naming.AuthenticationException;

public class NickNameAlredyExistsException extends AuthenticationException {
    public NickNameAlredyExistsException(final String msg){
        super(msg);
    }
}
