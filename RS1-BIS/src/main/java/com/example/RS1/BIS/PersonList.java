package com.example.RS1.BIS;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonList{

    List<PersonInterface> person = new ArrayList<>();

    public void setPerson(List<PersonInterface> person) {
        this.person = person;
    }

    public List<PersonInterface> getPerson() {
        return person;
    }
}
