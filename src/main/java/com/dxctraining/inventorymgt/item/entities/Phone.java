package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity

@Table(name="phone")
public class Phone extends Item{
	@Id
	@GeneratedValue
	private int id;
	private int storageMemory;
	public Phone() {
		
	}
	public Phone(String name,Supplier supplier,int storageMemory) {
		super(name,supplier);
		this.storageMemory=storageMemory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStorageMemory() {
		return storageMemory;
	}
	public void setStorageSpace(int storageMemory) {
		this.storageMemory = storageMemory;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone that = (Phone) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
