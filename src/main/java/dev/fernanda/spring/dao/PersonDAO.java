package dev.fernanda.spring.dao;

import dev.fernanda.model.Person;

import java.util.List;

public interface PersonDAO {

    void createPerson(String name, String cpf);
    List<Person> readPerson(int id);
    List<Person> readPeople();
    void updatePerson(int id, String name, String cpf);
    void deletePerson(int id);
}
