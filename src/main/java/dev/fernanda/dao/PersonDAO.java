package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Person person) {
        jdbcTemplate.update("insert into people (name, cpf) values (?, ?)", person.getName(), person.getCpf());
    }

    RowMapper<Person> personMapper = (ResultSet resultSet, int rowNum) -> {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setCpf(resultSet.getString("cpf"));
        return person;
    };

    public List<Person> readPerson(int id) {
        return jdbcTemplate.query("select * from people where id = ?", new Object[] {id}, personMapper);
    }

    public List<Person> readPeople() {
        return jdbcTemplate.query("select * from people", personMapper);
    }

    public void update(Person person) {
        jdbcTemplate.update("update people set name = ?, cpf = ? where id = ?", person.getName(), person.getCpf(), person.getId());
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("delete from people people where id = ?", id);
    }

}




