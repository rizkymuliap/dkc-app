package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.structure_dkr;
import com.dkc.models.repos.structure_dkrRepos;

import jakarta.transaction.Transactional;
//import java.util.List;

@Service
@Transactional
public class structure_dkrService {
    
    @Autowired
    private structure_dkrRepos Structure_dkrRepos;

    public structure_dkr save(structure_dkr data)
    {
        return Structure_dkrRepos.save(data);
    }

    public structure_dkr findOne(String id)
    {
        return Structure_dkrRepos.findById(id).get();
    }

    public Iterable<structure_dkr> findAll()
    {
        return Structure_dkrRepos.findAll();
    }

    public void removeOne(String id)
    {
        Structure_dkrRepos.deleteById(id);
    }

    // public List<structure_dkr> findByName(String name)
    // {
    //     return Structure_dkrRepos.findByNameContains(name);
    // }
}
