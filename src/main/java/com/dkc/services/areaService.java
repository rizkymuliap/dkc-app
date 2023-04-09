package com.dkc.services;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.area;
import com.dkc.models.repos.areaRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class areaService {
    
    @Autowired
    private areaRepos AreaRepos;

    public area save(area data)
    {
        return AreaRepos.save(data);
    }

    public area findOne(String id)
    {
        return AreaRepos.findById(id).get();
    }

    public Iterable<area> findAll(){
        return AreaRepos.findAll();
    }

    public void removeOne(String id)
    {
        AreaRepos.deleteById(id);
    }

    // public List<area> findByName(String name)
    // {
    //     return AreaRepos.findByNameContains(name);
    // }
}
