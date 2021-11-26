package com.example.BS41.ControladorMiconfiguracionProperties;

import com.example.BS41.MiConfiguracionProperties.MiConfiguracionPropertiesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorGetMiconfiguracionProperties {

    @Autowired
    public MiConfiguracionPropertiesInterface miConfiguracionPropertiesInterface;

    @GetMapping("miconfiguracion")
    public String printMiConfiguracion(){
        return miConfiguracionPropertiesInterface.getPropiedad("valor1") +
                "                    "+
                miConfiguracionPropertiesInterface.getPropiedad("valor2");
    }
}
