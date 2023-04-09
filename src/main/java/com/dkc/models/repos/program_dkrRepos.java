package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.program_dkr;

//import java.util.List;

public interface program_dkrRepos extends CrudRepository<program_dkr,String>{
    //List<program_dkr> findByNameContains(String name);
}
