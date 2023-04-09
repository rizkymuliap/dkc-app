package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.dkr;

//import java.util.List;

public interface dkrRepos extends CrudRepository<dkr,String>{
    //List<dkr> findByNameContains(String name);
}
