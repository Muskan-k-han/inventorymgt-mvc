package com.dxctraining.inventorymgt.supplier.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.supplier.dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;


@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {
	@Autowired
    private ISupplierDao dao;
	@Override
    public Supplier findSupplierById(int id) {
       Supplier supplier= dao.findSupplierById(id);
        return supplier;
    }
	 @Override
	    public Supplier add(Supplier supplier) {
	        validate(supplier);
	        supplier=dao.add(supplier);
	        return supplier;
	    }
	 @Override
	    public void remove(int id) {
	       dao.remove(id);
	    }

	   public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Supplier can't be null");
	        }
	   }
	   
	        @Override
		    public List<Supplier> allSuppliers(){
		        List<Supplier>allsuppliers=dao.allSuppliers();
		        return allsuppliers;
		    }
	        
	        @Override
		    public boolean authentication(int id, String password){
		       Supplier supplier= dao.findSupplierById(id);
		       String storedPassword=supplier.getPassword();
		       boolean equals= storedPassword.equals(password);
		       return equals;
		    }

}
