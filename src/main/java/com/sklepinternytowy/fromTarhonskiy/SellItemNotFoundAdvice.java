package com.sklepinternytowy.fromTarhonskiy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
class SellItemNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SellItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String sellItemNotFoundHandler(SellItemNotFoundException ex) {
        return ex.getMessage();
    }
}