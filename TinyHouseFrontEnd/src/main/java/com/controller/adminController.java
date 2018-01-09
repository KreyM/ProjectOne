package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.*;
import com.model.Supplier;

import javax.validation.Valid;

@Controller
public class adminController 
{
	@Autowired 
	 SupplierDaoImpl supplierDaoImpl;
	 
	 @Autowired
	 CategoryDaoImpl categoryDaoImpl;
	 
	@RequestMapping("/adding")
	public String adding()
	{
		return "adding";
	}
	
	@RequestMapping(value="/saveSupplier", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveSupplierData(@RequestParam("sid")int sid, @RequestParam("supplierName")String supplierName )
	{
		ModelAndView mv= new ModelAndView();
		Supplier ss = new Supplier();
		ss.setSid(sid);
		ss.setSupplierName(supplierName);
		supplierDaoImpl.insertSupplier(ss);
		mv.setViewName("adding");
		return mv;
	}

}
