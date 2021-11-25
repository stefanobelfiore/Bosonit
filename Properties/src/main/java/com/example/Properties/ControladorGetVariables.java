package com.example.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorGetVariables {

    @Value("${VAR1}")
    private String var1;

    @Value("${My.VAR2}")
    private String var2;

    @Value("${var3}")
    private String var3;

    @GetMapping("valores")
    public String getVariables(){
        return "valor de var1 es: "+var1+ ", valor de my.var2 es: "+var2; 
    }

    @GetMapping("var3")
    public String getVariable3(){
        return "Valor de Var3: "+ var3;
    }


}
