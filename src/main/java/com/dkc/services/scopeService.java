package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.scope;
import com.dkc.models.repos.scopeRepos;

import jakarta.transaction.Transactional;

//import java.util.List;

@Service
@Transactional
public class scopeService {
    
    @Autowired
    private scopeRepos ScopeRepos;

    public scope save(scope data)
    {
        return ScopeRepos.save(data);
    }

    public scope findOne(String id)
    {
        return ScopeRepos.findById(id).get();
    }

    public Iterable<scope> findAll()
    {
        return ScopeRepos.findAll();
    }

    public void removeOne(String id)
    {
        ScopeRepos.deleteById(id);
    }

    // public List<scope> findByName(String name)
    // {
    //     return ScopeRepos.findByNameContains(name);
    // }
}
