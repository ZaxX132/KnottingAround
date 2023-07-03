package com.zaxx.KnottingAround.excepcions.orderExcepsions;

import javax.naming.AuthenticationException;

public class AmigurumiOutOfStock extends AuthenticationException {
    public AmigurumiOutOfStock(final String msg){
        super(msg);
    }
}
