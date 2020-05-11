package com.codewithfazal.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.codewithfazal.demo.model.Alien;

//public interface AllienRepo extends CrudRepository<Alien, Integer> {
public interface AllienRepo extends JpaRepository<Alien, Integer> {
	List<Alien> findByaname(String aname);
	List<Alien> findByAidGreaterThan(int aid);
	@Query("FROM Alien WHERE aname =?1 ORDER BY aid DESC")
	List<Alien> findByAnameSorted(String aname);
}
