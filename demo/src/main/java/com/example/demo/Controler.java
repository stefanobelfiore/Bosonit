package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controler {

    @GetMapping("/hola")
    public String getHolaMundo(){
        return "Hola Mundo";
    }

    @GetMapping("user/{nombre}")
    public String getEmployeesById(@PathVariable String nombre) {
        return "Hola: " + nombre;
    }

    @PostMapping("/useradd")
    public User printUser(@RequestBody User user){
        User answer = new User();
        answer.setName(user.getName());
        answer.setEdad(user.getEdad()+1);
        answer.setCiudad(user.getCiudad());
        return answer;
    }

}
