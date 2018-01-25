package com.controller;


import java.security.Principal;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.*;
import com.model.*;

@Controller
public class CartController 
{

	@Autowired 
	 SupplierDaoImpl supplierDaoImpl;
	 
	 @Autowired
	 CategoryDaoImpl categoryDaoImpl;
	 
	 @Autowired
	 ProductDaoImpl productDaoImpl ;
	 
	 @Autowired
	 CartDaoImpl cartDaoImpl;
	 
	 @Autowired
	 OrdersDaoImpl ordersDaoImpl;
	 
	 @Autowired
	 UserDaoImpl userDaoImpl;
	 
	 @RequestMapping(value="/prodDetails/{pid}")
	 public ModelAndView prodDet (@PathVariable("pid")int pid)
	 {
		 System.out.println("entered prod details");
		 ModelAndView mv=new ModelAndView();
		 Product prod= productDaoImpl.findByPID(pid);
		 mv.addObject("prod", prod);
		 mv.setViewName("productDetails");
		 return mv;
	 }
	
	 
	 @RequestMapping(value="/addToCart", method=RequestMethod.POST)
	 public ModelAndView addtocart(HttpServletRequest request)
	 {
		 ModelAndView mv=new ModelAndView();
		 Principal principal =request.getUserPrincipal();
		 String userEmail=principal.getName();
		 //
		 try
		 {
			/* User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			 
			 String email=user.getEmail();*/
			 
			 System.out.println("hello");
			 int pid =Integer.parseInt(request.getParameter("pid"));
					 //Integer.parseInt(request.getParameter("pid"));
			 System.out.println(pid);
			 Double price=Double.parseDouble(request.getParameter("price"));
			 int qty=Integer.parseInt(request.getParameter("pQty"));
			 System.out.println("cart entery 2");
			 String pname=request.getParameter("pname");
			 String imgName=request.getParameter("imgName");
			 System.out.println(imgName);
			 Cart cartExist= cartDaoImpl.getCartById(pid, userEmail);//(pid,userEmail);
			 System.out.println("cart entery 21");
			 if(cartExist==null)
			 {
				 System.out.println("cart entery 3");
				 Cart cm=new Cart();
				 cm.setCartPrice(price);
				 cm.setCartProductId(pid);
				 cm.setCartStock(qty);
				 cm.setCartImage(imgName);
				 cm.setCartProductName(pname);
			 
				 User u=userDaoImpl.findUserByEmail(userEmail);
				 cm.setCartUserDetails(u);
				 cartDaoImpl.insertCart(cm);
			 }
			 else if(cartExist!=null)
			 {
				 Cart cm=new Cart();
				 cm.setCartId(cartExist.getCartId());
				 cm.setCartPrice(price);
				 cm.setCartProductId(pid);
				 cm.setCartStock(cartExist.getCartStock()+qty);
				 cm.setCartImage(imgName);
				 cm.setCartProductName(pname);
			 
				 User u=userDaoImpl.findUserByEmail(userEmail);
				 cm.setCartUserDetails(u);
				 cartDaoImpl.updateCart(cm);
				 
			 }
			 mv.addObject("cartInfo", cartDaoImpl.findByCartID(userEmail));
			 mv.setViewName("cart");
			 return mv;
		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
			 System.out.println("adding cart not successful");
			 mv.addObject("cartInfo", cartDaoImpl.findByCartID(userEmail));
			 mv.setViewName("cart");
			 return mv;
		}
		 
	 }
	 
	 @RequestMapping(value="/checkout" , method=RequestMethod.GET)
		
	 public ModelAndView goToCheckout( HttpServletRequest req)
	{ 
    
        ModelAndView mv= new ModelAndView();
		Principal principal=req.getUserPrincipal();
		String userEmail= principal.getName();
		User u=userDaoImpl.findUserByEmail(userEmail);
		 List<Cart> cart=cartDaoImpl.findByCartID(userEmail);
		 mv.addObject("user",u);
		 mv.addObject("cart",cart);
		 
	return mv;

	}

	 @RequestMapping(value="/orderProcess" , method=RequestMethod.POST)
		 public ModelAndView orderProcess(HttpServletRequest req)
		{ 
	    
            ModelAndView mv= new ModelAndView("ack");
			Orders ord=new Orders();
			Principal principal=req.getUserPrincipal();
			String userEmail= principal.getName();
			List<Cart> cart= cartDaoImpl.findByCartID(userEmail);
			User u=userDaoImpl.findUserByEmail(userEmail);
			 Double total= Double.parseDouble(req.getParameter("total"));
			 String payment =req.getParameter(userEmail);
			 ord.setUser(u);
			 ord.setPayment(payment);
			 ord.setTotal(total);
			 ordersDaoImpl.insertOrder(ord);
             mv.addObject("orderDetails",u);
             mv.addObject("u",userDaoImpl.findUserByEmail(userEmail));
             mv.addObject("cart",cart);
             //mv.setViewName("ack");
			 return mv;
	
		}
	 
	 @RequestMapping("/ack")
	 public String ack()
	 {
		 return "ack";
	 }
	 
	 @RequestMapping(value="/goToCart" , method=RequestMethod.GET)
		
	 public ModelAndView goToCart( HttpServletRequest req)
	{ 
    
        ModelAndView mv= new ModelAndView();
		Principal principal=req.getUserPrincipal();
		String userEmail= principal.getName();
		mv.addObject("cartInfo",cartDaoImpl.findByCartID(userEmail));
		 mv.setViewName("cart");
	return mv;

	}
	 
	 @RequestMapping(value="/deleteCart/{cartId }")
	 public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId, HttpServletRequest req)
	 {

	        ModelAndView mv= new ModelAndView();
			Principal principal=req.getUserPrincipal();
			String userEmail= principal.getName();
			cartDaoImpl.deleteCart(cartId);
			mv.addObject("cartInfo",cartDaoImpl.findByCartID(userEmail));
			mv.setViewName("cart");
			return mv;
			
	 }
	 
	 


}
