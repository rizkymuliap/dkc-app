package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.speech_leader_dkc;
//import java.util.List;

public interface speech_leader_dkcRepos extends CrudRepository<speech_leader_dkc,String>{
   // List<speech_leader_dkc> findByNameContains(String name);
}
