package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.auth;

public interface authRepos extends CrudRepository<auth,String>{
    auth findByToken(String token);

    void deleteByToken(String token);
}
