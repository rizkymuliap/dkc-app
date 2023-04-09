package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.agenda;

//import java.util.List;

public interface agendaRepos extends CrudRepository<agenda,String>{
   // List<agenda> findByNameContains(String name);
}
