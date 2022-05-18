package com.simplilearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.simplilearn.entity.Recipie;



@Repository
public interface RecipieRepository extends JpaRepository<Recipie, Integer>{
 
	@Query("SELECT u FROM Recipie u WHERE u.name = ?1")
	Recipie Findbyname(String name);
	
	@Query("SELECT u FROM Recipie u WHERE u.category = ?1")
	List<Recipie> findByCategory(String category);
}
