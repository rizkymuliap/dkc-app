package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.sk_dkr;
import com.dkc.models.repos.sk_dkrRepos;

import jakarta.transaction.Transactional;
//import java.util.List;

@Service
@Transactional
public class sk_dkrService {
    
    @Autowired
    private sk_dkrRepos Sk_dkrRepos;

    public sk_dkr save(sk_dkr data)
    {
        return Sk_dkrRepos.save(data);
    }

    public sk_dkr findOne(String id)
    {
        return Sk_dkrRepos.findById(id).get();
    }

    public Iterable<sk_dkr> findAll()
    {
        return Sk_dkrRepos.findAll();
    }

    public void removeOne(String id)
    {
        Sk_dkrRepos.deleteById(id);
    }

    // public List<sk_dkr> findByName(String name)
    // {
    //     return Sk_dkrRepos.findByNameContains(name);
    // }
}
