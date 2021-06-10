package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;


@Repository
public class PersonDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person insert(Person person) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("people").usingGeneratedKeyColumns("id");
        person.setId(simpleJdbcInsert.executeAndReturnKey(person.toMap()).intValue());
        return person;
    }

    private static final RowMapper<Person> personMapper = (ResultSet resultSet, int rowNum) -> {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setCpf(resultSet.getString("cpf"));
        return person;
    };

    public Person findById(int id) {
        return jdbcTemplate.query("select * from people where id = ?", resultSet -> resultSet.next() ? personMapper.mapRow(resultSet, 1) : null, id);
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






