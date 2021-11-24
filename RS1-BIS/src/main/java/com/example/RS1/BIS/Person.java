package com.example.RS1.BIS;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@SuppressWarnings("SpellCheckingInspection")
@Service
@Data
public class Person implements PersonInterface {

    String name;
    int age;
    String poblation;
    int id;
    public List<Person> personLista = new ArrayList<>();

    public List<Person> getPersonLista() {
        return personLista;
    }

    @Override
    public void addPersonLista(Person person) {
        personLista.add(person);
    }

    @Override
    public Stream getPersonId(int id) {
        Stream mylist = personLista.stream().filter(idp ->idp.id==id);
        return mylist;
    }

    @Override
    public Stream getPersonNombre(String nombre) {
        Stream mylist = personLista.stream().filter(idp ->idp.name.equals(nombre));
        return mylist;
    }

    @Override
    public void deletePerson(Integer id) {
        personLista.removeIf(person -> person.getId() == id);
    }

    @Override
    public Stream putPerson(Integer id, Person person) {
        Stream mylist = personLista.stream()
                .filter(idp ->idp.getId()==id)
                .map(obj -> {
                    if(person.getName() != null){obj.setName(person.getName());}
                    if(person.getPoblation() != null ){obj.setPoblation(person.getPoblation());}
                    if(person.getAge() != 0){obj.setAge(person.getAge());}
                    return obj
                ;});

        return mylist;
    }
}