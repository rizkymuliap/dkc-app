package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.school;

//import java.util.List;

public interface schoolRepos extends CrudRepository<school,String>{
    //List<school> findByNameContains(String name);
}
