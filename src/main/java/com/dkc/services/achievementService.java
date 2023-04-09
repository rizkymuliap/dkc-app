package com.dkc.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.achievement;
import com.dkc.models.repos.achievementRepos;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class achievementService {
    
    @Autowired
    private achievementRepos AchievementRepos;

    public achievement save(achievement data)
    {
        return AchievementRepos.save(data);
    }

    public achievement findOne(String id)
    {
        return AchievementRepos.findById(id).get();
    }

    public Iterable<achievement> findAll()
    {
        return AchievementRepos.findAll();
    }

    public void removeOne(String id)
    {
        AchievementRepos.deleteById(id);
    }

    // public List<achievement> findByName(String name)
    // {
    //     return AchievementRepos.findByNameContains(name);
    // }
}
