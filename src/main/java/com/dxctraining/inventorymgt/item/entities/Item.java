package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
@Table(name="items")
@Inheritance(strategy =InheritanceType.JOINED)
public class Item {
	@Id
	@GeneratedValue
	private int id;
	private String itemname;
	
	@ManyToOne
	private Supplier supplier;
	public Item() {
		
	}
	public Item(String itemname,Supplier supplier) {
		this.itemname=itemname;
		this.supplier=supplier;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item that = (Item) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
