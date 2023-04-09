package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.gp_report_dkr;
import com.dkc.models.repos.gp_report_dkrRepos;

import jakarta.transaction.Transactional;

//import java.util.List;

@Service
@Transactional
public class gp_report_dkrService {
    
    @Autowired
    private gp_report_dkrRepos Gp_report_dkrRepos;

    public gp_report_dkr save(gp_report_dkr data){
        return Gp_report_dkrRepos.save(data);
    }

    public gp_report_dkr findOne(String id)
    {
        return Gp_report_dkrRepos.findById(id).get();
    }

    public Iterable<gp_report_dkr> findAll()
    {
        return Gp_report_dkrRepos.findAll();
    }

    public void removeOne(String id)
    {
        Gp_report_dkrRepos.deleteById(id);
    }

    // public List<gp_report_dkr> findByName(String name)
    // {
    //     return Gp_report_dkrRepos.findByNameContains(name);
    // }

}
