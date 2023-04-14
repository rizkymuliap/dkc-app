package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.dkr;

public interface dkrRepos extends CrudRepository<dkr,String>{
    dkr findByUsernameAndPassword(String username, String password);
}
