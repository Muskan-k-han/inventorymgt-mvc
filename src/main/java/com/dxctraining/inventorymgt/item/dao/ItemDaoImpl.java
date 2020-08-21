package com.dxctraining.inventorymgt.item.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.exceptions.ItemNotFoundException;

@Repository
public class ItemDaoImpl implements IItemDao{
	@PersistenceContext
    private EntityManager entityManager;
	
	 @Override
	    public Item findItemById(int id) {
	        Item item=entityManager.find(Item.class,id);
	        if(item==null){
	            throw new ItemNotFoundException("item not found for id="+id);
	        }
	        return item;
	    }
	 @Override
	    public Item add(Item item) {
	        entityManager.persist(item);
	        return item;
	    }
	 @Override
	    public void remove(int id) {
	     Item item= findItemById(id) ;
	     entityManager.remove(item);
	    }

	 @Override
	    public List<Computer> allComputer() {
	        String jpaql="from Computer";
	        TypedQuery<Computer>query=entityManager.createQuery(jpaql,Computer.class);
	        List<Computer>computerList=query.getResultList();
	        return computerList;
	    }
	 @Override
	    public List<Phone> allPhone() {
	        String jpaql="from Phone";
	        System.out.println("inside 4");
	        TypedQuery<Phone>query=entityManager.createQuery(jpaql,Phone.class);
	        List<Phone>phoneList=query.getResultList();
	        return phoneList;
	    }

}
