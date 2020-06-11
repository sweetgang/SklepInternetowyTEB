package com.sklepinternytowy.fromTarhonskiy;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SellItemRequest {
    private String name;
    private  String kodProduktu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKodProduktu() {
        return kodProduktu;
    }

    public void setKodProduktu(String kodProduktu) {
        this.kodProduktu = kodProduktu;
    }


}
