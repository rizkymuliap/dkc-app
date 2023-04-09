package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.data_potensi;

//import java.util.List;

public interface data_potensiRepos extends CrudRepository<data_potensi,String> {
   // List<data_potensi> findByNameContains(String name);
}
