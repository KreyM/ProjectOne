package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import com.DaoImpl.UserDaoImpl;
import com.model.User;

@Controller
public class indexController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
/*	@RequestMapping("/goToRegister")
	public String goToRegister()
	{
		return "register";
	}*/

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
		
		
	
}
