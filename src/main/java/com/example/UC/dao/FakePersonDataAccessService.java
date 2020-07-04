package com.example.UC.dao;

import com.example.UC.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllpeople()
    {
        return DB;
    }
}
