package com.example.UC.dao;

import com.example.UC.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(List<Person> person) {
        person.stream().forEach((person1) -> DB.add(new Person(UUID.randomUUID(), person1.getName())));
        return 1;
    }

    @Override
    public List<Person> selectAllpeople()
    {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isPresent())
        {
            return 0;
        }
        DB.remove(personMayBe.get());
        return 1;
    }


    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).map(person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            if(indexOfPersonToUpdate >=0 ){
                DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

}
