package com.example.RS1.BIS;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")

public interface PersonInterface {

public List getPersonLista();
public void addPersonLista(Person person);
public Stream getPersonId(int id);
public Stream getPersonNombre(String nombre);
public void deletePerson(Integer id);
public Stream putPerson(Integer id, Person person);
}


