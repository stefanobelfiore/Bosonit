package com.example.BS41.PerfilesAplicacion;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpellCheckingInspection")
@Component
@Profile("other")
public class Perfil2 implements Perfiles{

    String perfil = "perfil2";

    public String getPerfil() {
        return perfil;
    }

    @Override
    public String miFuncion() {
        System.out.println(perfil);
        return getPerfil();
    }
}
