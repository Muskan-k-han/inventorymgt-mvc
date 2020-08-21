package com.dxctraining.inventorymgt.supplier.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.SessionData;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
@Controller
public class SupplierController {
	@Autowired
	private ISupplierService service1;
	

	@Autowired
    private SessionData session;
	
	@PostConstruct
	public void init() {
		Supplier supplier1=new Supplier("Arpit","112233");
		service1.add(supplier1);
		Supplier supplier2=new Supplier("Honey","aabbcc");
		service1.add(supplier2);
	}
	
	@GetMapping("/supplierprofile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
		
		if(!session.isUserLoggedIn())
		{
            return new ModelAndView("login");
        }
       Supplier supplier=service1.findSupplierById(id);
       ModelAndView modelAndView=new ModelAndView("details","supplier",supplier);
       return modelAndView;
    }
	@GetMapping("/login")
    public ModelAndView loginpage(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }
	@GetMapping("/processinglogin")
    public ModelAndView processLogin(@RequestParam("id") int id, @RequestParam("password") String password){
         boolean correct=service1.authentication(id,password);
         if(!correct){
          ModelAndView modelAndView= new ModelAndView("login");
          return modelAndView;
         }
         session.saveLogin(id);
         Supplier supplier=service1.findSupplierById(id);
         ModelAndView mav=new ModelAndView("details","supplier",supplier);
         return mav;
    }
	 @GetMapping("/logout")
	    public ModelAndView logout(){
	       session.clear();
	       ModelAndView mav=new ModelAndView("login");
	       return mav;
	    }


    @GetMapping("/listallsupplier")
    public ModelAndView allSupplier(){
    	if(!session.isUserLoggedIn())
		{
            return new ModelAndView("login");
        }
    	List<Supplier>supplierValues=service1.allSuppliers();
        ModelAndView modelAndView=new ModelAndView("list","supplier",supplierValues);
        return modelAndView;
    }
    @GetMapping("/addsupplier")
    public ModelAndView supplierPage(){
        ModelAndView modelView=new ModelAndView("addsupplier");
        return modelView;
    }
    @GetMapping("/processaddsupplier")
    public ModelAndView processRegister(@RequestParam("suppliername") String name,@RequestParam("password") String password){
        Supplier supplier=new Supplier(name,password);
        supplier=service1.add(supplier);
        ModelAndView modelView=new ModelAndView("details","supplier",supplier);
        return modelView;
    }
    @GetMapping("/postaddsupplier")
    public ModelAndView postRegisterPage(){
        CreateSupplierRequest supplierData=new CreateSupplierRequest();
        ModelAndView modelView=new ModelAndView("postaddsupplier","supplier",supplierData);
        return modelView;
    }
    @PostMapping("/processpostadd")
    public ModelAndView processRegister(@ModelAttribute("supplier") CreateSupplierRequest supplierData){
        System.out.println("name="+supplierData.getName());
        Supplier supplier=new Supplier(supplierData.getName(),supplierData.getPassword());
        supplier=service1.add(supplier);
        ModelAndView mv=new ModelAndView("details","supplier",supplier);
        return mv;
    }


}