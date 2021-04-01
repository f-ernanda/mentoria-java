package dev.fernanda.spring.dao;

import dev.fernanda.model.Person;
import dev.fernanda.model.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createPerson(String name, String cpf) {
        jdbcTemplate.update("insert into people (name, cpf) values (?, ?)", name, cpf);
    }

    public List<Person> readPerson(int id) {
        return jdbcTemplate.query("select * from people where id = ?", new Object[] {id}, new PersonMapper());
    }

    public List<Person> readPeople() {
        return jdbcTemplate.query("select * from people", new PersonMapper());
    }

    public void updatePerson(int id, String name, String cpf) {
        jdbcTemplate.update("update people set name = ?, cpf = ? where id = ?", name, cpf, id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("delete from people people where id = ?", id);
    }
}
