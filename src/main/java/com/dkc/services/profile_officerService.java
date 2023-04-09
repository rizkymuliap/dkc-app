package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.profile_officer;
import com.dkc.models.repos.profile_officerRepos;

import jakarta.transaction.Transactional;

//import java.util.List;

@Service
@Transactional
public class profile_officerService {
    
    @Autowired
    private profile_officerRepos Profile_officerRepos;

    public profile_officer save(profile_officer data)
    {
        return Profile_officerRepos.save(data);
    }

    public profile_officer findOne(String id)
    {
        return Profile_officerRepos.findById(id).get();
    }

    public Iterable<profile_officer> findAll()
    {
        return Profile_officerRepos.findAll();
    }

    public void removeOne(String id)
    {
        Profile_officerRepos.deleteById(id);
    }

    // public List<profile_officer> findByName(String name)
    // {
    //     return Profile_officerRepos.findByNameContains(name);
    // }
}
