package com.example.UC.dao;

import com.example.UC.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

        int insertPerson(UUID id, Person person);

        List<Person> selectAllpeople();
}
