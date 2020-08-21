package com.dxctraining.inventorymgt.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ItemServiceImpl implements IItemService{
	@Autowired
    private IItemDao dao;
	
	@Override
    public Item findItemById(int id) {
       Item item= dao.findItemById(id);
        return item;
    }
	 @Override
	    public Item add(Item item) {
	        validate(item);
	        item=dao.add(item);
	        return item;
	    }
	 @Override
	    public void remove(int id) {
	       dao.remove(id);
	    }
	   public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Item can't be null");
	        }
	   }
	        @Override
		    public List<Computer> allComputer(){
		        List<Computer>allcomputer=dao.allComputer();
		        return allcomputer;
		    }
		   @Override
		    public List<Phone> allPhone(){
		        List<Phone>allPhone=dao.allPhone();
		        return allPhone;
		    
	   }

}
