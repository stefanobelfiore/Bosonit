package com.example.demo.Ciudad;

import com.example.demo.Ciudad.CiudadInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorCiudad {

    //@Autowired
    CiudadInterface ciudadInterface;

    public ControladorCiudad(CiudadInterface ciudadInterface){
        this.ciudadInterface = ciudadInterface;
    }

    @GetMapping("/getCiudad")
    public CiudadInterface printCities(){

        return  ciudadInterface;
    }

    @PostMapping("/addCiudad")
    public CiudadInterface postCity(){

        ciudadInterface.getCiudades().add("San Giovanni Rotondo");
        ciudadInterface.getNumeroHabitantes().add(200);
        return ciudadInterface;
    }
    //esta es una pruba  para añadir un json, preguntar explicación de lo que está bie o está mal
    @PostMapping("/addCiudadBody")
    public CiudadInterface postCity(@RequestBody String newCity, Integer newCityHab){

        ciudadInterface.getCiudades().add(newCity);
        ciudadInterface.getNumeroHabitantes().add(newCityHab);

        return ciudadInterface;
    }

}
