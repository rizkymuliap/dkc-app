package com.dkc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.program_dkc;
import com.dkc.models.repos.program_dkcRepos;

import jakarta.transaction.Transactional;

//import java.util.List;;

@Service
@Transactional
public class program_dkcService {
    
    @Autowired
    private program_dkcRepos Program_dkcRepos;

    public program_dkc save(program_dkc data)
    {
        return Program_dkcRepos.save(data);
    }

    public program_dkc findOne(String id)
    {
        return Program_dkcRepos.findById(id).get();
    }

    public Iterable<program_dkc> findAll()
    {
        return Program_dkcRepos.findAll();
    }

    public void removeOne(String id)
    {
        Program_dkcRepos.deleteById(id);
    }

    // public List<program_dkc> findByName(String name)
    // {
    //     return Program_dkcRepos.findByNameContains(name);
    // }
}
