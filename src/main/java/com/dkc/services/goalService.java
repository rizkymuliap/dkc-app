package com.dkc.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.goal;
import com.dkc.models.repos.goalRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class goalService {
    
    @Autowired
    private goalRepos GoalRepos;

    public goal save(goal data)
    {
        return GoalRepos.save(data);
    }

    public goal findOne(String id)
    {
        return GoalRepos.findById(id).get();
    }

    public Iterable<goal> findAll()
    {
        return GoalRepos.findAll();
    }

    public void removeOne(String id)
    {
        GoalRepos.deleteById(id);
    }

    public Iterable<goal> findByType(String type) {
        return GoalRepos.findByType(type);
      }

    // public List<goal> findByName(String name)
    // {
    //    return  GoalRepos.findByNameContains(name);
    // }
}
