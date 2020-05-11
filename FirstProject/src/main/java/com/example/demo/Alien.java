package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@component is used to tell spring container create object of this class
@Component
//@scope define pattern spring is using.when pattern is prototype the instance of objected is not injected be default
//it is injected only when we called it.
//by default spring use singelton pattern which means that no matter if we call instance of class twice it will
//it only once
@Scope("prototype")
public class Alien {
	private int aid;
	private String aname;
	private String tech;
	//@Autowired we r telling alien class there is laptop object search for it. laptop obj is created by @component 
	//and add it to spring container.it tells springs that this class is dependent on laptop class
	//autowire by default search obj by type we can use @Qualifier to search by name.
	@Autowired
	@Qualifier("lap1") //@Qualifier("lap1") search class lap1 object by name
	private Laptop laptop;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void show() {
		System.out.println("in show");
		laptop.compile();
	}
}
