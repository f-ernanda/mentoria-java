package dev.fernanda.service;

import dev.fernanda.dao.PersonDAO;
import dev.fernanda.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class PersonManagerTest {

    @Mock
    PersonDAO personDAO;

    @InjectMocks
    PersonManager personManager;

    private Person fernanda;

    @Before
    public void setUp() {
        fernanda = new Person("Fernanda", "333.333.333-33");
    }

    @Test
    public void whenInsertPersonWithNameAndCpf_mustReturnPerson() {
        Mockito.when(personDAO.insert(fernanda)).thenReturn(true);
        Assert.assertTrue(personManager.insertPerson("Fernanda", "333.333.333-33"));
    }

    @Test
    public void whenFindByIdWithId_mustReturnNull_forEmptyDatabaseOrNonExistingPerson() {
    }

    @Test
    public void whenFindByIdWithId_mustReturnValidPerson_forExistingPerson() {
    }

    @Test
    public void whenFindAll_mustReturnEmptyList_forEmptyDatabase() {
    }

    @Test
    public void whenFindAll_mustReturnListOfPeople_forNonEmptyDatabase() {
    }

    @Test
    public void whenUpdateWithIdNameAndCpf_mustReturnFalse_forEmptyDatabaseOrNonExistingPerson() {
    }

    @Test
    public void whenUpdateWithIdNameAndCpf_mustReturnTrue_forExistingPerson() {
    }

    @Test
    public void whenDeleteByIdWithId_mustReturnFalse_forEmptyDatabaseOrNonExistingPerson() {
    }

    @Test
    public void whenDeleteByIdWithId_mustReturnTrue_forExistingPerson() {
    }

}