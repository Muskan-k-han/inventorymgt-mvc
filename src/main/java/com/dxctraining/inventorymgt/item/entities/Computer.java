package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
@Entity
@Table(name="computer")
public class Computer extends Item {
	@Id
	@GeneratedValue
	private int id;
	private int deskSpace;
	public Computer() {
		
	}
	public Computer(String name,Supplier supplier,int deskSpace) {
		super(name,supplier);
		this.deskSpace=deskSpace;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeskSpace() {
		return deskSpace;
	}
	public void setDeskSpace(int deskSpace) {
		this.deskSpace = deskSpace;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Computer that = (Computer) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
	
	

}
