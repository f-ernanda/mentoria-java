package dev.fernanda.service;

import dev.fernanda.dao.PersonDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonManagerTest {

    @Mock
    PersonDAO personDAO;

    @Test
    public void whenInsertPersonWithNameAndCpf_mustReturnPerson() {
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