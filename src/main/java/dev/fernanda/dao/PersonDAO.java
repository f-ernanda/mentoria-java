package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(Person person) {
       return jdbcTemplate.update("insert into people (name, cpf) values (?, ?)", person.getName(), person.getCpf()) > 0;
    }

    public List<Person> findById(int id) {
        return jdbcTemplate.query("select * from people where id = ?", new Object[] {id}, BeanPropertyRowMapper.newInstance(Person.class));
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from people", BeanPropertyRowMapper.newInstance(Person.class));
    }

    public boolean update(Person person) {
        return jdbcTemplate.update("update people set name = ?, cpf = ? where id = ?", person.getName(), person.getCpf(), person.getId()) > 0;
    }

    public boolean deleteById(int id) {
        return jdbcTemplate.update("delete from people people where id = ?", id) > 0;
    }
}




