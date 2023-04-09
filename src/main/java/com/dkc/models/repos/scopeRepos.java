package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.scope;

//import java.util.List;

public interface scopeRepos extends CrudRepository<scope,String> {
    //List<scope> findByNameContains(String name);
}
