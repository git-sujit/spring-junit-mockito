package com.learn.business;

import com.learn.entity.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {
    public Item retrieveItem() {
        return new Item(1, "Business Bat", 10.50, 100);
    }
}
