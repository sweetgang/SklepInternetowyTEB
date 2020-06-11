package com.sklepinternytowy.fromTarhonskiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SellItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private  String kodProduktu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
