package com.sklepinternytowy.fromTarhonskiy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping
public class SellItemControler {

    private SellItemRepository sellItemRepository;

    @RequestMapping(value = "/sklep/kup",method = RequestMethod.GET)
    public String firstFunction(Model model){
        addLinkAttribute(1,model);
        model.addAttribute("list_of_item",sellItemRepository.findAll());
        model.addAttribute("newAtribute","ALLOHA");
        return "index";
    }
    @RequestMapping(value = "/sklep/kup/{kodProduktu}",method = RequestMethod.GET)
    public String findItem( @PathVariable String kodProduktu,Model model){
        addLinkAttribute(1,model);
        model.addAttribute("list_of_item",sellItemRepository.findByKodProduktu(kodProduktu));
        model.addAttribute("newAtribute","ALLOHA");
        return "index";
    }

    @RequestMapping(value = "/sklep/kup",method = RequestMethod.POST)
    public String addItem(@RequestBody SellItemRequest sellItemRequest,Model model){
        addLinkAttribute(2,model);
        SellItem sellItem = new SellItem(0L,sellItemRequest.getName(),sellItemRequest.getKodProduktu());
        sellItemRepository.save(sellItem);
        model.addAttribute("newAtribute","You added item");
        return "index";
    }

    @RequestMapping(value = "/sklep/kup",method = RequestMethod.PUT)
    public String updateItem(@RequestBody SellItemRequest sellItemRequest,Model model){
        addLinkAttribute(3,model);
        Long id = sellItemRepository.findByKodProduktu(sellItemRequest.getKodProduktu()).getId();
        SellItem sellItem = new SellItem(id,sellItemRequest.getName(),sellItemRequest.getKodProduktu());
        sellItemRepository.save(sellItem);
        model.addAttribute("newAtribute","Your updates added");
        return "index";
    }

    @RequestMapping(value = "/sklep/kup/{kodProduktu}",method = RequestMethod.DELETE)
    public String kupItem( @PathVariable String kodProduktu, Model model){
        addLinkAttribute(4,model);
        sellItemRepository.deleteByKodProduktu(kodProduktu);
        model.addAttribute("newAtribute","You bought item" + kodProduktu);
        return "index";
    }

    public Model addLinkAttribute(int numberDeletedLink, Model model){
        ArrayList<String> linkValue = new ArrayList<String> ();
        linkValue.addAll(Arrays.asList("/index.html","/indexGetByKodTowaru.html","/indexPost.html",
              "/indexPut.html","/indexDelete.html"));
        List<String> linkValueText = new ArrayList<String> ();
        linkValueText.addAll( Arrays.asList(" Find all item ==>"," Find item ==>"," Add item ==>",
                " Update item ==>"," Buy item ==>"));
        linkValue.remove(numberDeletedLink);
        linkValueText.remove(numberDeletedLink);

        model.addAttribute("link1",linkValue.get(0));
        model.addAttribute("link1name",linkValueText.get(0));
        model.addAttribute("link2",linkValue.get(1));
        model.addAttribute("link2name",linkValueText.get(1));
        model.addAttribute("link3",linkValue.get(2));
        model.addAttribute("link3name",linkValueText.get(2));
        model.addAttribute("link4",linkValue.get(3));
        model.addAttribute("link4name",linkValueText.get(3));
        return model;
    }
}
