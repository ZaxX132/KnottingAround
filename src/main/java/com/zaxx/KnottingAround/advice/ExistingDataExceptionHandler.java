package com.zaxx.KnottingAround.advice;

import com.zaxx.KnottingAround.excepcions.registerExceptions.CellPhoneAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.EmailAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.NickNameAlredyExistsException;
import com.zaxx.KnottingAround.excepcions.registerExceptions.UserAlredyExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExistingDataExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CellPhoneAlredyExistsException.class)
    public ResponseEntity<?> cellPhoneExistsException(CellPhoneAlredyExistsException exception) {
        String exceptionMessage = exception.getMessage();
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("celular", exceptionMessage);
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlredyExistsException.class)
    public ResponseEntity<?> userAlreadyExistsException(UserAlredyExistsException exception) {
        String exceptionMessage = exception.getMessage();
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("usuario", exceptionMessage);
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NickNameAlredyExistsException.class)
    public ResponseEntity<?> NickNameAlreadyExistsException(NickNameAlredyExistsException exception) {
        String exceptionMessage = exception.getMessage();
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("apodo", exceptionMessage);
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlredyExistsException.class)
    public ResponseEntity<?> EmailAlreadyExistsException(EmailAlredyExistsException exception) {
        String exceptionMessage = exception.getMessage();
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("correo", exceptionMessage);
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
}
