package com.dxctraining.inventorymgt.ui;

import java.util.*;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.exceptions.ItemNotFoundException;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;



@Component
public class InventoryUi {
	
	@Autowired
	private ISupplierService service1;
	
	@Autowired
	private IItemService service2;
	
	@PostConstruct
	private void runapp() {
		try {
			List<Item> list=new ArrayList<>();
			Supplier supplier1=new Supplier("muskan");
			supplier1=service1.add(supplier1);
			Supplier supplier2=new Supplier("pompy");
			supplier2=service1.add(supplier2);
			Item item1=new Item("computer",supplier1);
			list.add(item1);
			Item item2=new Item("notebook",supplier1);
			list.add(item2);
			Item item3=new Item("pen",supplier1);
			list.add(item3);
			Computer item4=new Computer("Dell",supplier2,360);
			list.add(item4);
			Phone item5=new Phone("Vivo",supplier2,500);
			list.add(item5);
			service2.add(item2);
			service2.add(item1);
			service2.add(item3);
			service2.add(item4);
			service2.add(item5);
			service2.remove(3);
			list.remove(item1);
			int id2=item5.getId();
			int id1 = supplier1.getId();
			Supplier fetched = service1.findSupplierById(id1);
			System.out.println("Supplier :"+fetched.getId()+"name :"+fetched.getName());
			Item fetchedItem=service2.findItemById(id2);
			Supplier supplierinfo=fetchedItem.getSupplier();
			System.out.println("Item id"+fetchedItem.getId()+"Item name"+fetchedItem.getItemname()+"Supplier name :"+supplierinfo.getName());
			for(Item item:list) {
				display(item);
			}
		}catch (InvalidArgumentException e) {
			e.printStackTrace();
		}

		catch (ItemNotFoundException e) {
			e.printStackTrace();
		}

}

	private void display(Item item) {
		if(item instanceof Computer) {
			computeritem(item);
		}
		if(item instanceof Phone) {
			phoneitem(item);
		}
		System.out.println("name :"+item.getItemname()+"Supplier :"+item.getSupplier());
		
		
	}

	private void phoneitem(Item item) {
		Phone pitem=(Phone)item;
		System.out.println("Phone name :"+pitem.getItemname()+"Supplier :"+pitem.getSupplier()+"Storage :"+pitem.getStorageMemory());
		
	}

	private void computeritem(Item item) {
		Computer citem=(Computer)item;
		System.out.println("Computer name :"+citem.getItemname()+"Supplier :"+citem.getSupplier()+"Desk Size :"+citem.getDeskSpace());
		
	}
}
