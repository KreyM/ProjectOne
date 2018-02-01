package com.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CartItemDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.CartItem;
import com.model.Product;
import com.model.User;

@Controller
public class indexController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	 @Autowired
	 CartDaoImpl cartDaoImpl;
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	@RequestMapping("/index")
	public String home()
	{
		return "index";
	}
	@RequestMapping("/aboutUs")
	public String companyInfo()
	{
		return "aboutUs";
	}
	 @Autowired
		private CartItemDaoImpl cartItemDaoImpl;
	 
		private User user;
		CartItem cartItem = new CartItem();
	@RequestMapping(value="/goToRegister" , method=RequestMethod.GET)
	 public ModelAndView goToRegister()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="/saveRegister" , method=RequestMethod.POST)
	 public ModelAndView saveRegister(@Valid @ModelAttribute("user")User user, BindingResult result)
	{
		ModelAndView mav= new ModelAndView();
		if(result.hasErrors())
		{	
			mav.setViewName("register");
			return mav;
		}
		else
		{
		user.setRole("ROLE_USER");
		userDaoImpl.insertUser(user);
		//userDaoImpl.insertUser(user);
		mav.setViewName("index");
		}
		return mav;
	}
	@RequestMapping("/productList")
	public ModelAndView prodlist() 
	{
		ModelAndView mav =new ModelAndView();
		mav.addObject("prodList",productDaoImpl.retrieve());
		mav.setViewName("productAdmin");
		return mav;
	}
	
	@RequestMapping(value="/productCustList")
	public ModelAndView getCustTable(@RequestParam("cid") int cid)
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("prodList", productDaoImpl.getProdBycatId(cid));
		mav.setViewName("productCustList");
		System.out.println("check pheli tarik");
		return mav;
	}
	 @RequestMapping(value="prodDetails/{pid}")
	 public ModelAndView prodDet(@PathVariable("pid")int pid)
	 {
		 System.out.println("pid "+pid+"entered prod details");
		 ModelAndView mv=new ModelAndView();
		 Product prod= productDaoImpl.findByPID(pid);
		 mv.addObject("prod", prod);
		 mv.setViewName("productDetails");
		 return mv;
	 }
	 @RequestMapping(value="addingCartDemo/{pid}")
	 public ModelAndView addingCartDemo(@PathVariable("pid")int pid)
	 {
		 System.out.println("pid "+pid+"entered cart details");
		 ModelAndView mv=new ModelAndView();
		 Product prod= productDaoImpl.findByPID(pid);
		 mv.addObject("prod", prod);
		 mv.setViewName("cart");
		 return mv;
	 }
	 

	 
	 @RequestMapping(value="addToCart/{pid}")
	 public String addtocart(@PathVariable("pid")int pid, Principal principal, Model model) {
System.out.println("path way entry");
		Product product = productDaoImpl.findByPID(pid);//get(pid);
			User user = userDaoImpl.findUserByEmail(principal.getName());
			Cart cart = user.getCart();
			System.out.println(" hi= cart id");
			System.out.println(cart.getId());
			System.out.println(product.getPid()+"== product id");
			CartItem cartItem = cartItemDaoImpl.getCartItemByCartIdAndProductId(cart.getId(), product.getPid());
			Set<CartItem> cartItems = null;
			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setTotalPrice(product.getPrice());
				cart.setGrandTotal(cart.getGrandTotal() + product.getPrice());
				cart.setTotalItems(cart.getTotalItems() + 1);
				cartItems = new HashSet<CartItem>();
				cartItems.add(cartItem);
				cart.setCartItem(cartItems);
				cartDaoImpl.updateCart(cart);
				
			} else {
				System.out.println("entering into else");
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(cartItem.getTotalPrice() + product.getPrice());
				cartItem.getCart().setGrandTotal(cart.getGrandTotal() + product.getPrice());
				cartItem.getCart().setTotalItems(cart.getTotalItems() + 1);
				cartItemDaoImpl.update(cartItem);
			}
			

			
		

			return "redirect:/cart";

		}/*
	 @RequestMapping(value="/addToCart/{id}", method=RequestMethod.POST)
	 public String addtocart(@PathVariable("pid") int pid, Principal principal, Model model) {
System.out.println("path way entry");
			Product product = productDaoImpl.findByPID(pid);//get(pid);
			User user = userDaoImpl.findUserByEmail(principal.getName());
			Cart cart = user.getCart();
			
			CartItem cartItem = cartItemDaoImpl.getCartItemByCartIdAndProductId(cart.getCartId(), product.getPid());
			Set<CartItem> cartItems = null;
			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setTotalPrice(product.getPrice());
				cart.setGrandTotal(cart.getGrandTotal() + product.getPrice());
				cart.setTotalItems(cart.getTotalItems() + 1);
				cartItems = new HashSet<CartItem>();
				cartItems.add(cartItem);
				cart.setCartItem(cartItems);
				cartDaoImpl.updateCart(cart);
				
			} else {
				System.out.println("entering into else");
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(cartItem.getTotalPrice() + product.getPrice());
				cartItem.getCart().setGrandTotal(cart.getGrandTotal() + product.getPrice());
				cartItem.getCart().setTotalItems(cart.getTotalItems() + 1);
				cartItemDaoImpl.update(cartItem);
			}
			

			
		

			return "redirect:/cart/user/viewcart";

		}*/
	@ModelAttribute
	public void getData(Model m)
	{
		m.addAttribute("catList", categoryDaoImpl.retrieve());
	}
		
	@RequestMapping("/goToLogin")
	public String goToLogin()
	{
		return "login";
	}
	
	@RequestMapping("/userLogged")
	public String userLogged()
	{
		return "redirect:/index";
	}
	
	@RequestMapping("/error")
	public String userError()
	{
		return "error";
	}
	@RequestMapping("/goToReLogin")
	public String goToReLogin()
	{
		return "redirect:/goToLogin";
	}
}
