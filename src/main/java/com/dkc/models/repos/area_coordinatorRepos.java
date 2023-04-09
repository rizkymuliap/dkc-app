package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.area_coordinator;

//import java.util.List;

public interface area_coordinatorRepos extends CrudRepository<area_coordinator,String>{
   // List<area_coordinator> findByNameContains(String name);
}
