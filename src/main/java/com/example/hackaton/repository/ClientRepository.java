package com.example.hackaton.repository;

import com.example.hackaton.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client,Long> {
    List<Client> findAll();
    Optional<Client> findById(long id);
    Optional<Client> findByLoginName(String name);
    Optional<Client> findByAnswer(String name);
}
