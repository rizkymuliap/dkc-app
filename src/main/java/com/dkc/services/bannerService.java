package com.dkc.services;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.banner;
import com.dkc.models.repos.bannerRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class bannerService {
    
    @Autowired
    private bannerRepos BannerRepos;

    public banner save(banner data)
    {
        return BannerRepos.save(data);
    }

    public banner findOne(String id)
    {
        return BannerRepos.findById(id).get();
    }

    public Iterable<banner> findAll()
    {
        return BannerRepos.findAll();
    }

    public void removeOne(String id)
    {
        BannerRepos.deleteById(id);
    }

    // public List<banner> findByName(String name){
    //     return BannerRepos.findByNameContains(name);
    // }
}
