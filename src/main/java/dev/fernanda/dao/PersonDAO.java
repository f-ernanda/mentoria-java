package dev.fernanda.dao;

import dev.fernanda.model.Person;
import dev.fernanda.model.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PersonDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createPerson(Person person) {
        jdbcTemplate.update("insert into people (name, cpf) values (?, ?)", person.getName(), person.getCpf());
    }

    public List<Person> readPerson(int id) {
        return jdbcTemplate.query("select * from people where id = ?", new Object[] {id}, new PersonMapper());
    }

    public List<Person> readPeople() {
        return jdbcTemplate.query("select * from people", new PersonMapper());
    }

    public void updatePerson(Person person) {
        jdbcTemplate.update("update people set name = ?, cpf = ? where id = ?", person.getName(), person.getCpf(), person.getId());
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("delete from people people where id = ?", id);
    }
}
