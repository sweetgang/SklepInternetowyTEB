package com.sklepinternytowy.fromTarhonskiy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/sklep/kup", method = {RequestMethod.GET,
        RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class SellItemControler {

    private SellItemRepository sellItemRepository;

    @GetMapping()
    public String firstFunction(Model model){
        addLinkAttribute(model);
        model.addAttribute("list_of_item",sellItemRepository.findAll());
        model.addAttribute("newAtribute","ALLOHA");
        return "index";
    }
//    @PostMapping()
//    public String addItem(@RequestBody SellItemRequest sellItemRequest,Model model){
//        SellItem sellItem = new SellItem(OL,sellItemRequest.getName(),sellItemRequest.getKodProduktu());
//        sellItemRepository.save(sellItem);
//        model.addAttribute("newAtribute","You added item");
//        return "index";
//    }
//    @PutMapping()
//    public String updateItem(@RequestBody SellItemRequest sellItemRequest,Model model){
//        SellItem sellItem = new SellItem(OL,sellItemRequest.getName(),sellItemRequest.getKodProduktu());
//        sellItemRepository.save(sellItem);
//        model.addAttribute("newAtribute","Your updates added");
//        return "index";
//    }

    @DeleteMapping("{kodProduktu}")
    public String kupItem( @PathVariable String kodProduktu, Model model){
        sellItemRepository.deleteByKodProduktu(kodProduktu);
        model.addAttribute("newAtribute","You bought item" + kodProduktu);
        return "index";
    }
    public Model addLinkAttribute(Model model){
        model.addAttribute("link1","indexGetByKodTowaru.html");
        model.addAttribute("link1name"," Find item ==>");
        model.addAttribute("link2","indexPost.html");
        model.addAttribute("link2name"," Add item ==>");
        model.addAttribute("link3","indexPut.html");
        model.addAttribute("link3name"," Update item ==>");
        model.addAttribute("link4","indexDelete.html");
        model.addAttribute("link4name"," Buy item ==>");
        return model;
    }
}
