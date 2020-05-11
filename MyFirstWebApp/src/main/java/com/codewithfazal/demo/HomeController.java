package com.codewithfazal.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//to tell it's a controller
@Controller
public class HomeController {
	//to map our specific url/request agnist method.inthis case we r getting home request
	@RequestMapping("home")
	//@RequestParam("name") map name param to whatever is declare
	//public String home(@RequestParam("name") String myName, HttpSession session) {
	//this is how we r using http request	
	//public String home(HttpServletRequest request) {
		/*
		 * HttpSession session = request.getSession(); String name =
		 * request.getParameter("name");
		 * System.out.println("Hi "+name+" to Controller"); session.setAttribute("name",
		 * name);
		 */
		////HttpServletRequest way end
		
		
		
		//System.out.println("Hi "+myName+" to Controller"); 
		//session.setAttribute("name",myName);
		
		//we r telling spring return/load us home.jsp
		//return "home";
	//}
	
	//ModelAndView all our data(model) and view which we r returning in our controller is going to dispatcher servlet.
	//dispatcher servlet has combination of both ModelAndView 
	/*public ModelAndView home(@RequestParam("name") String myName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		return mv;
	}*/
	
	public ModelAndView home(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		return mv;
	}
}
