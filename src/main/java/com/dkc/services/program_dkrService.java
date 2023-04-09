package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.program_dkr;
import com.dkc.models.repos.program_dkrRepos;

//import java.util.List;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class program_dkrService {
    
    @Autowired
    private program_dkrRepos Program_dkrRepos;

    public program_dkr save(program_dkr data)
    {
        return Program_dkrRepos.save(data);
    }

    public program_dkr findOne(String id)
    {
        return Program_dkrRepos.findById(id).get();
    }

    public Iterable<program_dkr> findAll()
    {
        return Program_dkrRepos.findAll();
    }

    public void removeOne(String id)
    {
        Program_dkrRepos.deleteById(id);
    }

    // public List<program_dkr> findByName(String name)
    // {
    //     return Program_dkrRepos.findByNameContains(name);
    // }
}
