package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.structure_dkr;
//import java.util.List;

public interface structure_dkrRepos extends CrudRepository<structure_dkr,String>{
    //List<structure_dkr> findByNameContains(String name);
}
