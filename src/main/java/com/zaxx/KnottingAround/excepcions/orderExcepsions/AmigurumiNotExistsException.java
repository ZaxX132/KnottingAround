package com.zaxx.KnottingAround.excepcions.orderExcepsions;

import javax.naming.AuthenticationException;

public class AmigurumiNotExistsException extends AuthenticationException {
    public AmigurumiNotExistsException(final String msg){
        super(msg);
    }
}
