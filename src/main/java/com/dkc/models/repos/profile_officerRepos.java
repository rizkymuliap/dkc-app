package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.profile_officer;

//import java.util.List;

public interface profile_officerRepos extends CrudRepository<profile_officer,String>{
   // List<profile_officer> findByNameContains(String name);
}
