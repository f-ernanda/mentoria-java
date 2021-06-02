package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person insert(Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("insert into people (name, cpf) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getName());
            statement.setString(2, person.getCpf());
            return statement;
            }, keyHolder);
        int id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        person.setId(id);
        return person;
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




