package com.dkc.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.dkr;
import com.dkc.models.repos.dkrRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class dkrService {
    
    @Autowired
    private dkrRepos DkrRepos;

    public dkr save(dkr data)
    {
        return DkrRepos.save(data);
    }

    public dkr findOne(String id)
    {
        return   DkrRepos.findById(id).get();
    }

    public Iterable<dkr> findAll()
    {
        return DkrRepos.findAll();
    }

    public void removeOne(String id)
    {
        DkrRepos.deleteById(id);
    }

    // public List<dkr> findByName(String name)
    // {
    //     return DkrRepos.findByNameContains(name);
    // }
}
