package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.product;

//import java.util.List;

public interface productRepos extends CrudRepository<product,String>{
    //List<product> findByNameContains(String name);
}
