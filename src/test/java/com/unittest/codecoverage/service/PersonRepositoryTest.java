package com.unittest.codecoverage.service;

import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonRepositoryTest{

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryInsertNullException() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.insert(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("person can't be null");
    }

    @Test
    @DisplayName("Should return the same person")
    public void testPersonRepositoryInsert() {
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person();
        assertEquals(person, personRepository.insert(person));
    }

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryUpdate() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.update(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("person can't be null");
    }

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryDelete() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.delete(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name can't be null");
    }

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryGetNullException() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.get(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name can't be null");
    }

    @Test
    @DisplayName("Should return null with any input")
    public void testPersonRepositoryGet() {
        PersonRepository personRepository = new PersonRepository();
        assertNull(personRepository.get("test"));
    }

}
