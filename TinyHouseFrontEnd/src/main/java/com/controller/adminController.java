package com.controller;

import java.io.BufferedOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.*;

@Controller
public class adminController 
{
	@Autowired 
	 SupplierDaoImpl supplierDaoImpl;
	 
	 @Autowired
	 CategoryDaoImpl categoryDaoImpl;
	 
	 @Autowired
	 ProductDaoImpl productDaoImpl ;
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
	
	@RequestMapping(value="/saveCategory", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveCategoryData(@RequestParam("cid")int cid, @RequestParam("cname")String cname )
	{
		ModelAndView mv= new ModelAndView();
		Category cc = new Category();
		cc.setCid(cid);
		cc.setCname(cname);
		categoryDaoImpl.insertCategory(cc);
		mv.setViewName("adding");
		return mv;
	}
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	@Transactional 
	public String saveProduct(HttpServletRequest request, @RequestParam("file")MultipartFile file)
	{
		
		Product prod = new Product();
		prod.setPname(request.getParameter("pname"));
		prod.setPrice(Double.parseDouble(request.getParameter("price")));
		prod.setDescription(request.getParameter("description"));
		prod.setStock(Integer.parseInt(request.getParameter("stock")));
		prod.setCategory(categoryDaoImpl.findByCategoryId(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setSupplier(supplierDaoImpl.findBySupplierId(Integer.parseInt(request.getParameter("pSupplier"))));
		String filepath= request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImgName(filename);
		productDaoImpl.insertProduct(prod);
		System.out.println("File path "+filepath);
		/*try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream
		}
		catch()*/
		
		return "hi";
	}

}
