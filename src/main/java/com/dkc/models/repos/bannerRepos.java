package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.banner;

//import java.util.List;
public interface bannerRepos extends CrudRepository<banner,String>{
   // List<banner> findByNameContains(String name);
}
