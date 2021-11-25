package com.example.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@SuppressWarnings("SpellCheckingInspection")
@PropertySource("C:\\Users\\stefano.belfiore\\Desktop\\BS4-1\\src\\main\\resources\\miconfiguracion.properties")
@Configuration
public class ConfigurationMiconfiguracionProperties {

    @Autowired
    Environment environment;

    @Bean
    public String printMiconfiguracionProperties(){

        String attr = this.environment.getProperty("valor1");
        System.out.printf(attr);
        return null;
    }

}
