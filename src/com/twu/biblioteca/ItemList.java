package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class ItemList {
    protected List<Item> list;

    public ItemList() {
        this.list = new LinkedList<>();
    }

    public List<Item> getList() {
        return list;
    }

    public Item findBookByName(String name) {
        return this.list.stream().filter(item -> item.getTitle().equals(name)).findFirst().orElse(null);
    }
}
