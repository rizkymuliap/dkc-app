package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.stage;
//import java.util.List;

public interface stageRepos extends CrudRepository<stage,String>{
    //List<stage> findByNameContains(String name);
}
