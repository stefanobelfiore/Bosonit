package com.example.demo.Ciudad;

import java.util.ArrayList;

@SuppressWarnings("SpellCheckingInspection")

public interface CiudadInterface {
    ArrayList<String> getCiudades();
    void setCiudades(ArrayList<String> ciudades);
    ArrayList<Integer> getNumeroHabitantes();
    void setNumeroHabitantes(ArrayList<Integer> numeroHabitantes);

}
