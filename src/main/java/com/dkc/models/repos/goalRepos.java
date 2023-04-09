package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.goal;

//import java.util.List;

public interface goalRepos extends CrudRepository<goal,String>{
    //List<goal> findByNameContains(String name);
    Iterable<goal> findByType(String type);
}
