package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.scout_document;
//import java.util.List;

public interface scout_documentRepos extends CrudRepository<scout_document,String>{
    //List<scout_document> findByNameContains(String name);
}
