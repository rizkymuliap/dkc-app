package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.area_coordinator;
import com.dkc.models.repos.area_coordinatorRepos;

import jakarta.transaction.Transactional;

//import java.util.List;;

@Service
@Transactional
public class area_coordinatorService {
    
    @Autowired
    private area_coordinatorRepos Area_coordinatorRepos;

    public area_coordinator save(area_coordinator data)
    {
        return Area_coordinatorRepos.save(data);
    }

    public area_coordinator findOne(String id)
    {
        return Area_coordinatorRepos.findById(id).get();
    }

    public Iterable<area_coordinator> findAll()
    {
        return Area_coordinatorRepos.findAll();
    }

    public void removeOne(String id)
    {
        Area_coordinatorRepos.deleteById(id);
    }

    // public List<area_coordinator> findByName(String name)
    // {
    //     return Area_coordinatorRepos.findByNameContains(name);
    // }
}
