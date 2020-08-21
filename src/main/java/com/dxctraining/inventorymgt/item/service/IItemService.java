package com.dxctraining.inventorymgt.item.service;

import java.util.List;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;

public interface IItemService {
	Item findItemById(int id);

    Item add(Item item);

    void remove(int id);
    List<Computer> allComputer();
    List<Phone> allPhone();
    
}
