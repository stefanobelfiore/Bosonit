package com.example.RS1.BIS;
import lombok.Data;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpellCheckingInspection")
@Service
@Data
public class Person implements PersonInterface {
    /**  Optional<String> name= Optional.empty();
    Optional<Integer> age= Optional.empty();
    Optional<String> population= Optional.empty();*/

 String name;
    int age;
    String population;
    int id;
    public Person() {
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPoblation(String population){
        this.population = population;
    }

    @Override
    public void setAge(int age) {
      this.age = age;
    }
}