package com.learn.resource;

import com.learn.entity.Item;
import com.learn.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemResource {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/item")
    public Item getItem() {
        return new Item(1, "Bat", 10.50, 100);
    }

    @GetMapping("/b-item")
    public Item getItemFromBusinessService() {
        return itemBusinessService.retrieveItem();
    }
}
