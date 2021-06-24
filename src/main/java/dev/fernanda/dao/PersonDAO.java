package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;


@Repository
public class PersonDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(Person person) {
        return jdbcTemplate.update(Queries.INSERT, person.getName(), person.getCpf()) > 0;
    }

    private static final RowMapper<Person> personMapper = (ResultSet resultSet, int rowNum) -> {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setCpf(resultSet.getString("cpf"));
        return person;
    };

    public Person findById(int id) {
        return jdbcTemplate.query(Queries.FIND_BY_ID, resultSet -> resultSet.next() ? personMapper.mapRow(resultSet, 1) : null, id);
    }

    public List<Person> findAll() {
        return jdbcTemplate.query(Queries.FIND_ALL, BeanPropertyRowMapper.newInstance(Person.class));
    }

    public boolean update(Person person) {
        return jdbcTemplate.update(Queries.UPDATE, person.getName(), person.getCpf(), person.getId()) > 0;
    }

    public boolean deleteById(int id) {
        return jdbcTemplate.update(Queries.DELETE_BY_ID, id) > 0;
    }


}






