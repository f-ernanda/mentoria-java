package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.Mockito.*;

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
    public void whenInsert_mustReturnPerson() {
        /*
        Mockito.when(jdbcTemplate.update(any(String.class), eq(fernanda.getName()), eq(fernanda.getCpf()))).thenReturn(1);
        Person result = personDAO.insert(fernanda);
        Assert.assertSame(fernanda, result);
        */
    }

    @Test
    public void whenFindById_mustReturnNull_forEmptyDatabaseOrNonExistingPerson() {
    }

    @Test
    public void whenFindById_mustReturnValidPerson_forExistingPerson() {
    }

    @Test
    public void whenFindAll_mustReturnEmptyList_forEmptyDatabase() {
    }

    @Test
    public void whenFindAll_mustReturnListOfPeople_forNonEmptyDatabase() {
    }

    @Test
    public void whenUpdate_mustReturnFalse_forEmptyDatabaseOrNonExistingPerson() {
    }

    @Test
    public void whenUpdate_mustReturnTrue_forExistingPerson() {
    }

    @Test
    public void whenDeleteById_mustReturnFalse_forEmptyDatabaseOrNonExistingPerson() {
    }

    @Test
    public void whenDeleteById_mustReturnTrue_forExistingPerson() {
    }

}