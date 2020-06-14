package com.sklepinternytowy.fromTarhonskiy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellItemRepository extends JpaRepository<SellItem,Long> {
    SellItem findByKodProduktu(String kodProduktu);
    void deleteByKodProduktu(String kodProduktu);

}
