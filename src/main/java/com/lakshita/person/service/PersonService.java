package com.lakshita.person.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakshita.person.model.Person;
import com.lakshita.person.repository.PersonRepo;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = getPersonById(id);
        if (person != null) {
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setEmail(personDetails.getEmail());
            person.setAge(personDetails.getAge());
            return personRepo.save(person);
        }
        return null;
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}

