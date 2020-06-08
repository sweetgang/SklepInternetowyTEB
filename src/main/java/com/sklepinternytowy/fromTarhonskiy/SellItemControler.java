package com.sklepinternytowy.fromTarhonskiy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/sklep/kup/")
public class SellItemControler {

    private SellItemRepository sellItemRepository;

    @GetMapping()
    public String firstFunction(Model model){
        model.addAttribute("list_of_item",sellItemRepository.findAll());
        model.addAttribute("newAtribute","ALLOHA");
        return "index";
    }
    @DeleteMapping("{kodProduktu}")
    public void kupItem (@PathVariable String kodProduktu){
        System.out.println(kodProduktu);
        sellItemRepository.deleteByKodProduktu(kodProduktu);
    }



}
