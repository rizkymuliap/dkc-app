package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.area;
//import java.util.List;

public interface areaRepos extends CrudRepository<area,String>{
    //List<area> findByNameContains(String name);
}
