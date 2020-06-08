package com.sklepinternytowy.fromTarhonskiy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellItemRepository extends CrudRepository<SellItem,Long> {
    void deleteByKodProduktu(String kodProduktu);

}
