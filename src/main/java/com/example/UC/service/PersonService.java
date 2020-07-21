package com.example.UC.service;

import com.example.UC.dao.PersonDao;
import com.example.UC.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addperson(List<Person> person)
    {

        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople()
    {
        return personDao.selectAllpeople();
    }

    public Optional<Person> getPersonById(UUID id)
    {
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id)
    {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person)
    {
        return personDao.updatePersonById(id, person);
    }
}