package com.example.BS41.PerfilesAplicacion;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpellCheckingInspection")
@Component
@Profile("default")
public class Perfil1 implements Perfiles{

    public String perfil = "perfil1";

    public String getPerfil() {
        return perfil;
    }

    @Override
    public String miFuncion() {
        System.out.println(perfil);
        return getPerfil();
    }
}
