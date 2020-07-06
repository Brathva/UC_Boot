package com.example.UC.dao;

import com.example.UC.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

        int insertPerson(List<Person> person);

        List<Person> selectAllpeople();

        int deletePersonById(UUID id);

        int updatePersonById(UUID id, Person person);

        Optional<Person> selectPersonById(UUID id);
}
