package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.User;

@Controller
public class indexController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
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
	

	@RequestMapping(value="/goToRegister" , method=RequestMethod.GET)
	 public ModelAndView goToRegister()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="/saveRegister" , method=RequestMethod.POST)
	 public ModelAndView saveRegister(@ModelAttribute("user")User user, BindingResult result)
	{
		ModelAndView mav= new ModelAndView();
		if(result.hasErrors())
		{	
			mav.setViewName("register");
		
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
	
	@RequestMapping(value="/productCustList")
	public ModelAndView getCustTable(@RequestParam("cid") int cid)
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("prodList", productDaoImpl.getProdBycatId(cid));
		mav.setViewName("productCustList");
		return mav;
	}
	
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
