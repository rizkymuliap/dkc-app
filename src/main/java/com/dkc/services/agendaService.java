package com.dkc.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.agenda;
import com.dkc.models.repos.agendaRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class agendaService {
    
    @Autowired
    private agendaRepos AgendaRepos;

    public agenda save(agenda data)
    {
        //return data;
        return AgendaRepos.save(data);
    }

    public agenda findOne(String id)
    {
        return AgendaRepos.findById(id).get();
    }

    public Iterable<agenda> findAll(){
        return AgendaRepos.findAll();
    }

    public void removeOne(String id)
    {
        AgendaRepos.deleteById(id);
    }

    // public List<agenda> findByName(String name)
    // {
    //     return AgendaRepos.findByNameContains(name);
    // } 
}
