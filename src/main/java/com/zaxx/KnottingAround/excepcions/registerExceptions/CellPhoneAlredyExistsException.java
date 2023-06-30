package com.zaxx.KnottingAround.excepcions.registerExceptions;

import javax.naming.AuthenticationException;

public class CellPhoneAlredyExistsException extends AuthenticationException {
    public CellPhoneAlredyExistsException(final String msg){
        super(msg);
    }
}
