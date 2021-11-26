package com.example.BS41.MiConfiguracionProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@SuppressWarnings("SpellCheckingInspection")
@PropertySource("miconfiguracion.properties")
@Configuration
public class ConfigurationMiconfiguracionProperties implements MiConfiguracionPropertiesInterface {

    @Autowired
    public Environment environment;

    @Bean
    public String printMiconfiguracionProperties(){

        String attr1 = this.environment.getProperty("valor1");
        String attr2 = this.environment.getProperty("valor2");
        System.out.printf("          "+attr1+"       "+attr2+"         ");

        return attr1+attr2;
    }


    @Override
    public String getPropiedad(String propiedad) {
        return environment.getProperty(propiedad);
    }
}
