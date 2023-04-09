package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.program_dkc;

//import java.util.List;

public interface program_dkcRepos extends CrudRepository<program_dkc, String>{
   // List<program_dkc> findByNameContains(String name);
}
