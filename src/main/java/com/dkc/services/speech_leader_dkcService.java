package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.speech_leader_dkc;
import com.dkc.models.repos.speech_leader_dkcRepos;

import jakarta.transaction.Transactional;

//import java.util.List;

@Service
@Transactional
public class speech_leader_dkcService {
    
    @Autowired
    private speech_leader_dkcRepos Speech_leader_dkcRepos;

    public speech_leader_dkc save(speech_leader_dkc data)
    {
        return Speech_leader_dkcRepos.save(data);
    }

    public speech_leader_dkc findOne(String id)
    {
        return Speech_leader_dkcRepos.findById(id).get();
    }

    public Iterable<speech_leader_dkc> findAll()
    {
        return Speech_leader_dkcRepos.findAll();
    }

    public void removeOne(String id)
    {
        Speech_leader_dkcRepos.deleteById(id);
    }

    // public List<speech_leader_dkc> findByName(String name)
    // {
    //     return Speech_leader_dkcRepos.findByNameContains(name);
    // }
}
