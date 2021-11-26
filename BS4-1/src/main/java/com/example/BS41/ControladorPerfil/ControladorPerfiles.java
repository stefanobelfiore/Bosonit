package com.example.BS41.ControladorPerfil;

import com.example.BS41.PerfilesAplicacion.Perfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorPerfiles {

    @Autowired
    Perfiles perfiles;


    @GetMapping("perfil")
    public String getPerfil(){
        return "este es el perfil: " + perfiles.miFuncion();
    }

}
