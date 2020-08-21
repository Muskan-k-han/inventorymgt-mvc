package com.dxctraining.inventorymgt.supplier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNotFoundException;
@Repository
public class SupplierDaoImpl implements ISupplierDao {
	
	@PersistenceContext
    private EntityManager entityManager1;
	
	 @Override
	    public Supplier findSupplierById(int id) {
	        Supplier supplier=entityManager1.find(Supplier.class,id);
	        if(supplier==null){
	            throw new SupplierNotFoundException("supplier not found for id="+id);
	        }
	        return supplier;
	    }
	 @Override
	    public Supplier add(Supplier supplier) {
	        entityManager1.persist(supplier);
	        return supplier;
	    }
	 @Override
	    public void remove(int id) {
	     Supplier supplier= findSupplierById(id) ;
	     entityManager1.remove(supplier);
	    }

	 @Override
	    public List<Supplier> allSuppliers() {
	        String jpaql="from Supplier";
	        TypedQuery<Supplier>query=entityManager1.createQuery(jpaql,Supplier.class);
	        List<Supplier>suppliersList=query.getResultList();
	           return suppliersList;
	 }
}

