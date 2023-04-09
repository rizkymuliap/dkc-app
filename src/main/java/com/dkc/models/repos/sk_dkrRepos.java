package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.sk_dkr;
//import java.util.List;

public interface sk_dkrRepos extends CrudRepository<sk_dkr,String>{
   // List<sk_dkr> findByNameContains(String name);
}
