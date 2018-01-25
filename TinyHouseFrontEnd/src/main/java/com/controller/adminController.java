package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.ProductDao;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.model.*;

@Controller
@RequestMapping("/admin")
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
		mv.setViewName("modal");
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
		mv.setViewName("modal");
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
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources"+filename));
			fos.write(imagebyte);
			fos.close();
			System.out.println("working");
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("not working");
		}
		
		return "modal";
	}
	
	@ModelAttribute
	public void loadingDataInPage(Model m)
	{
		m.addAttribute("satList", supplierDaoImpl.retrieve());
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		m.addAttribute("prodList",productDaoImpl.retrieve());
	}
	
	@RequestMapping("/productList")
	public ModelAndView prodlist() 
	{
		ModelAndView mav =new ModelAndView();
		mav.addObject("prodList",productDaoImpl.retrieve());
		mav.setViewName("productAdmin");
		return mav;
	}
	
	@RequestMapping("/supplierList")
	public ModelAndView supplierList() 
	{
		ModelAndView mav =new ModelAndView();
		mav.addObject("satList",supplierDaoImpl.retrieve());
		mav.setViewName("supplierAdmin");
		return mav;
	}
	
	@RequestMapping("/categoryList")
	public ModelAndView categoryList() 
	{
		ModelAndView mav =new ModelAndView();
		mav.addObject("catList",categoryDaoImpl.retrieve());
		mav.setViewName("categoryAdmin");
		return mav;
	}
	
	@RequestMapping("/deleteProduct/{pid}")
	public String deleteProduct(@PathVariable("pid")int pid) 
	{
		productDaoImpl.deleteProduct(pid);
		return "deleteModal";
	
	}
	/*157*/
	@RequestMapping("/updateProd")
	public ModelAndView updateProduct(@RequestParam("pid") int pid)
	{
		ModelAndView mav =new ModelAndView();
		Product p=productDaoImpl.findByPID(pid);
		
		mav.addObject("prod",p);
		mav.addObject("catList",categoryDaoImpl.retrieve());
		mav.addObject("satList", supplierDaoImpl.retrieve());
		mav.setViewName("updateProduct");
		return mav;
	/*	167*/
	}
		
	@RequestMapping(value="/productUpdate", method=RequestMethod.POST)
	/*@Transactional*/
	/*public String updateMyProduct(@ModelAttribute("product")Product product,@RequestParam("imgName")MultipartFile fileDetail,Model m)
	{
			
			 System.out.println("Before update");
			 
			productDaoImpl.updateProduct(product);
			 System.out.println("product added");
			//String path=" E:\\FashionFrontEnd\\ECommFrontEnd\\ECommFrontEnd\\src\\main\\webapp\\resources\\images\\";
			String path = "E:/FashionFrontEnd/ECommFrontEnd/ECommFrontEnd/src/main/webapp/resources/images/";
			 String totalFileWithPath=path+String.valueOf(product.getPid())+".jpg";
			File productImage=new File(totalFileWithPath);
			System.out.println("total file path" + totalFileWithPath);
			if(!fileDetail.isEmpty())
			{
			 try
			 {
				 System.out.println("In try block");
				byte fileBuffer[]=fileDetail.getBytes();
				System.out.println("Get Bytes" + fileDetail.getBytes()+ fileBuffer);
				FileOutputStream fos=new FileOutputStream(productImage);
				System.out.println("output stream object");
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				System.out.println("output stream object created");
				bs.write(fileBuffer);
				System.out.println("write buffer");
				bs.close();
				System.out.println("image uploaded");
			 }
			 catch(FileNotFoundException ex)
			 {
				 System.out.println("exception arised " + ex);
				 ex.printStackTrace();
			 }
			 
			 catch(Exception e)
			 {
				 System.out.println("In catch block");
				 m.addAttribute("error",e.getMessage());
			  }
			}
			else
			{
				 System.out.println("In else block");
				m.addAttribute("error","Problem in File Uploading");
			}
			 System.out.println("Out of try block");
			Product product1=new Product();
			System.out.println("Product object created");
			m.addAttribute(product1);		
		
		return "redirect:/Product";
		
	}*/
/*172*//*
 * ACCORDING TO MAAM . ABOVE BHAVANA
 */ public String updateProd(HttpServletRequest request, @RequestParam("file")MultipartFile file)
	{
		System.out.println("somewhat");
		int pid= request.getIntHeader("pid");
			//	getParameter("pid"); 
		Product prod = new Product();
		prod.setPname(request.getParameter("pname"));
		System.out.println("somewhat");
		prod.setPrice(Double.parseDouble(request.getParameter("price")));
		prod.setDescription(request.getParameter("description"));
		prod.setStock(Integer.parseInt(request.getParameter("stock")));
		String cat=request.getParameter("pCategory");
		String sat=request.getParameter("pSupplier");
		System.out.println("somewhat");
		prod.setCategory(categoryDaoImpl.findByCategoryId(Integer.parseInt(cat)));
		prod.setSupplier(supplierDaoImpl.findBySupplierId(Integer.parseInt(sat)));
		String filepath= request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImgName(filename);System.out.println("b4 b4 somewhat after update");
		productDaoImpl.update(prod);System.out.println(" b4 somewhat after update");
		System.out.println("File path "+filepath);
		System.out.println("somewhat after update");
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources"+filename));
			fos.write(imagebyte);
			fos.close();
			System.out.println("working");
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("not working");
		}
		
		return "modal";
	}
	
}
