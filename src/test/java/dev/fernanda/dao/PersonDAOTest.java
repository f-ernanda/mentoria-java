package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;


@RunWith(MockitoJUnitRunner.class)
public class PersonDAOTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @Autowired
    private PersonDAO personDAO;

    private Person fernanda;

    @Before
    public void setUp() {
        fernanda = new Person("Fernanda", "333.333.333-33");
    }

    @Test
    @DisplayName("Should return a person when insert a person")
    public void shouldReturnAPerson_whenInsertNewPerson() {
        ReflectionTestUtils.setField(personDAO, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.queryForObject("insert into people (name, cpf) values (?, ?)", Boolean.class)).thenReturn(true);
        boolean result = personDAO.insert(fernanda);
        Assert.assertSame(true, result);
    }
}