package dev.fernanda.dao;

import dev.fernanda.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonDAOTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PersonDAO personDAO;


    private Person fernanda;
    private Person venicio;

    @Before
    public void setUp() {
        fernanda = new Person(3,"Fernanda", "333.333.333-33");
        venicio = new Person(4, "Venicio", "444.444.444-44");
    }

    @Test
    public void whenInsert_mustReturnPerson() {
        Mockito.when(jdbcTemplate.update(eq(Queries.INSERT), eq(fernanda.getName()), eq(fernanda.getCpf()))).thenReturn(1);
        Assert.assertTrue(personDAO.insert(fernanda));
    }

    @Test
    public void whenFindById_mustReturnNull_forEmptyDatabaseOrNonExistingPerson() {
        int id = 10;
        Mockito.when(jdbcTemplate.update(eq(Queries.FIND_BY_ID), eq(id))).thenReturn(0);
        Assert.assertNull(personDAO.findById(id));
    }

    @Test
    public void whenFindById_mustReturnValidPerson_forExistingPerson() {
        Mockito.when(jdbcTemplate.update(eq(Queries.FIND_BY_ID), eq(fernanda.getId()))).thenReturn(1);
        Assert.assertSame(fernanda, personDAO.findById(fernanda.getId()));
    }

    @Test
    public void whenFindAll_mustReturnEmptyList_forEmptyDatabase() {
        Mockito.when(jdbcTemplate.update(eq(Queries.FIND_ALL))).thenReturn(0);
        List<Person> people = personDAO.findAll();
        Assert.assertTrue((people).isEmpty());
    }

    @Test
    public void whenFindAll_mustReturnListOfPeople_forNonEmptyDatabase() {
        Mockito.when(jdbcTemplate.update(eq(Queries.FIND_ALL))).thenReturn(1);
        List<Person> people = new ArrayList<>();
        people.add(fernanda);
        Assert.assertSame(people, personDAO.findAll());
    }

    @Test
    public void whenUpdate_mustReturnFalse_forEmptyDatabaseOrNonExistingPerson() {
        Mockito.when(jdbcTemplate.update(eq(Queries.UPDATE), eq(fernanda.getId()), eq(fernanda.getName()), eq(fernanda.getCpf()))).thenReturn(0);
        Assert.assertFalse(personDAO.update(venicio));
    }

    @Test
    public void whenUpdate_mustReturnTrue_forExistingPerson() {
        Mockito.when(jdbcTemplate.update(eq(Queries.UPDATE), eq(fernanda.getId()), eq(fernanda.getName()), eq(fernanda.getCpf()))).thenReturn(1);
        Assert.assertTrue(personDAO.update(fernanda));
    }

    @Test
    public void whenDeleteById_mustReturnFalse_forEmptyDatabaseOrNonExistingPerson() {
        Mockito.when(jdbcTemplate.update(eq(Queries.DELETE_BY_ID), eq(fernanda.getId()))).thenReturn(0);
        Assert.assertFalse(personDAO.deleteById(11));
    }

    @Test
    public void whenDeleteById_mustReturnTrue_forExistingPerson() {
        Mockito.when(jdbcTemplate.update(eq(Queries.DELETE_BY_ID), eq(fernanda.getId()))).thenReturn(1);
        Assert.assertTrue(personDAO.deleteById(3));
    }

}