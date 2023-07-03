package com.zaxx.KnottingAround.advice;

import com.zaxx.KnottingAround.excepcions.orderExcepsions.AmigurumiNotExistsException;
import com.zaxx.KnottingAround.excepcions.orderExcepsions.AmigurumiOutOfStock;
import com.zaxx.KnottingAround.excepcions.registerExceptions.CellPhoneAlredyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class newOrderAmigurumiExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AmigurumiNotExistsException.class)
    public ResponseEntity<?> amigurumiNotExistsException(AmigurumiNotExistsException exception) {
        String exceptionMessage = exception.getMessage();
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("amigurumi", exceptionMessage);
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AmigurumiOutOfStock.class)
    public ResponseEntity<?> amigurumiOutOfStockException(AmigurumiOutOfStock exception) {
        String exceptionMessage = exception.getMessage();
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("amigurumi", exceptionMessage);
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
}
