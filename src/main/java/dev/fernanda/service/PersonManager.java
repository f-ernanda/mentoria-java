package dev.fernanda.service;

import dev.fernanda.dao.PersonDAO;
import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManager {

    @Autowired
    private PersonDAO personDAO;

    public Person insertPerson(String name, String cpf) {
        return personDAO.insert(new Person(name, cpf));
    }

    public Person findById(int id) {
        return personDAO.findById(id);
    }

    public List<Person> findAll() {
        return personDAO.findAll();
    }

    public boolean updatePerson(int id, String name, String cpf) {
        if(findById(id) != null) {
            personDAO.update(new Person(id, name, cpf));
            return true;
        }
        return false;
    }

    public boolean deletePerson(int id) {
        if(findById(id) != null) {
            personDAO.deleteById(id);
            return true;
        }
        return false;
    }

}
