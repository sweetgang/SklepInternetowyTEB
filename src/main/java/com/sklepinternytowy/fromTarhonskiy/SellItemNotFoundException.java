package com.sklepinternytowy.fromTarhonskiy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SellItemNotFoundException extends RuntimeException {

    SellItemNotFoundException(String  kodProduktu) {
        super("Could not find item " + kodProduktu);
    }
}