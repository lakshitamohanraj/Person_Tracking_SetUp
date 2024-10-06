package com.lakshita.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakshita.person.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
}
