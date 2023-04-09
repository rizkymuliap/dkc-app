package com.dkc.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.data_potensi;
import com.dkc.models.repos.data_potensiRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class data_potensiService {
    
    @Autowired
    private data_potensiRepos Data_potensiRepos;

    public data_potensi save(data_potensi data)
    {
        return Data_potensiRepos.save(data);
    }

    public data_potensi findOne(String id)
    {
        return Data_potensiRepos.findById(id).get();
    }

    public Iterable<data_potensi> findAll()
    {
        return Data_potensiRepos.findAll();
    }

    public void removeOne(String id)
    {
        Data_potensiRepos.deleteById(id);
    }

    // public List<data_potensi> findByName(String name)
    // {
    //     return Data_potensiRepos.findByNameContains(name);
    // }
}
