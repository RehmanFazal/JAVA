package com.codewithfazal.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.codewithfazal.demo.dao.AllienRepo;
import com.codewithfazal.demo.model.Alien;

//@Controller
//@RestController to tell spring we tell spring that its a rest controller and when we use this we don't need to use
//@ResponseBody
@RestController
public class AlienController {

	@Autowired
	AllienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	//@RequestMapping("/alien")
	//@PostMapping it is used to tell that this is a post request
	//@RequestBody it is used to tell that we may send raw data as input
	//consumes = {"application/json"} which type of data we r expecting from user
	@PostMapping(path = "/alien", consumes = {"application/json"})
	public Alien addAlien1(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping(path = "/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted";
	}
	
	@RequestMapping("/getAlien") 
	public ModelAndView getAlien(@RequestParam int aid) {
		Alien alien =  repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByaname("ALI"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByAnameSorted("ALI"));
		
		ModelAndView mv = new ModelAndView("show_allien.jsp"); 
		mv.addObject(alien);
		return mv; 
	}
	
	@RequestMapping("/aliens") 
	//@ResponseBody it tells spring that we r not returning view name(which by default is expected) but returning data.
	@ResponseBody
	public String getAliens() {
		return repo.findAll().toString();
	}
	
	//produces = {"application/xml"} produce response only in xml format
	//@RequestMapping(path="/aliens1",produces = {"application/xml"})
	@RequestMapping(path="/aliens1")
	@ResponseBody
	public List<Alien> getAliens1() {
		return repo.findAll();
	}
	
	//{aid} its a wild card as it is enclosed in {} we r telling spring that we would be providing aid in future to get
	//data for
	//@RequestMapping("/alien/{aid}")
	//@GetMapping it is used to tell that this is a get request by default it is get so if we don't specify it 
	//doesn't make any difference
	@GetMapping("/alien/{aid}")
	//@ResponseBody no using cause we change controller annotation
	//@PathVariable is telling spring that whatever is after path pass it as a parameter
	public String getSingleAlien(@PathVariable int aid) {
		return repo.findById(aid).toString();
	}
	
	@RequestMapping("/alien1/{aid}") 
	//@ResponseBody
	public Optional<Alien> getSingleAlien1(@PathVariable int aid) {
		return repo.findById(aid);
	}
	
	@RequestMapping("/getAllAlien") 
	public ModelAndView getAllAlien() {
		//Alien alien = repo.findById(aid).orElse(new Alien()); 
		Iterable<Alien> alien = repo.findAll();
		System.out.println(alien);
		ModelAndView mv = new ModelAndView("show_allien.jsp");
		mv.addObject(alien); 
		return mv; 
    }
	 

}
