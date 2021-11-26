package com.example.BS41.ControladorApplicationProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorGetApplicationProperties {

    @Value("${url}")
    String url;

    @Value(("${password}"))
    String password;

    @GetMapping("parametros")
    public String getVariablesProperties(){
        return"Url: "+url+" Password: "+ password;
    }

}
