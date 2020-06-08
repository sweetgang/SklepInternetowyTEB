package com.sklepinternytowy.fromTarhonskiy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner {

    private final SellItemRepository sellItemRepository;

    public LoadDatabase(SellItemRepository sellItemRepository) {
        this.sellItemRepository = sellItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        sellItemRepository.save(new SellItem(0L,"Myszka Gamingowa","PP034511"));
        sellItemRepository.save(new SellItem(0L,"Monitor LCD","PM001122"));
        sellItemRepository.save(new SellItem(0L,"Karta graficzna","PC192601"));
        sellItemRepository.save(new SellItem(0L,"Słuchawki douszne","PW000002"));

    }
}