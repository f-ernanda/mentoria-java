package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class PersonDAOTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PersonDAO personDAO;

    private Person fernanda;

    @Before
    public void setUp() {
        fernanda = new Person("Fernanda", "333.333.333-33");
    }

    @Test
    public void whenInsertNewPerson_shouldReturnAPerson() {
        Mockito.when(jdbcTemplate.update(any(String.class), eq(fernanda.getName()), eq(fernanda.getCpf()))).thenReturn(1);
        boolean result = personDAO.insert(fernanda);
        Assert.assertTrue(result);
    }
}