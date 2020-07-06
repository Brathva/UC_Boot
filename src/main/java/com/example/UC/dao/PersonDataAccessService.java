package com.example.UC.dao;

import com.example.UC.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(List<Person> person) {
        //DB.add(new Person(person.getName()));
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
        if(personMayBe.isEmpty())
        {
            return 0;
        }
        DB.remove(personMayBe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if(indexOfPersonToUpdate >=0 ){
                DB.set(indexOfPersonToUpdate, new Person(id, p.getName()));
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
