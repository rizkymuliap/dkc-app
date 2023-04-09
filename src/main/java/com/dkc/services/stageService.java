package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.stage;
import com.dkc.models.repos.stageRepos;

import jakarta.transaction.Transactional;
//import java.util.List;

@Service
@Transactional 
public class stageService {
    
    @Autowired
    private stageRepos StageRepos;

    public stage save(stage data)
    {
        return StageRepos.save(data);
    }

    public stage findOne(String id)
    {
        return StageRepos.findById(id).get();
    }

    public Iterable<stage> findAll()
    {
        return StageRepos.findAll();
    }

    public void  removeOne(String id)
    {
        StageRepos.deleteById(id);
    }

    // public List<stage> findByName(String name)
    // {
    //     return StageRepos.findByNameContains(name);
    // }
}
