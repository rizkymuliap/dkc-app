package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;
//import java.util.List;

import com.dkc.models.entities.achievement;


public interface achievementRepos extends CrudRepository<achievement,String>{
   // List<achievement> findByNameContains(String name);
}
