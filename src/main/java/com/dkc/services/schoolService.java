package com.dkc.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.school;
import com.dkc.models.repos.schoolRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class schoolService {
 
    @Autowired
    private schoolRepos SchoolRepos;

    public school save(school data)
    {
        return SchoolRepos.save(data);
    }

    public school findOne(String id)
    {
        return SchoolRepos.findById(id).get();
    }

    public Iterable<school> findAll()
    {
        return SchoolRepos.findAll();
    }

    public void removeOne(String id)
    {
        SchoolRepos.deleteById(id);
    }

    // public List<school> findByName(String name)
    // {
    //     return SchoolRepos.findByNameContains(name);
    // }
}
