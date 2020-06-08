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


}
