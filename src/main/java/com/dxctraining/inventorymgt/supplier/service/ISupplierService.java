package com.dxctraining.inventorymgt.supplier.service;

import java.util.List;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierService {
	Supplier findSupplierById(int id);

    Supplier add(Supplier supplier);

    void remove(int id);
    List<Supplier> allSuppliers();
    public boolean authentication(int id,String password);
}
