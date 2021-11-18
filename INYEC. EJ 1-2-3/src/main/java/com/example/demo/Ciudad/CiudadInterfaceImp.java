package com.example.demo.Ciudad;

import java.util.ArrayList;

@SuppressWarnings("SpellCheckingInspection")
//@Service
public class CiudadInterfaceImp implements CiudadInterface {

    ArrayList<String> ciudades = new ArrayList<String>();
    ArrayList<Integer> numeroHabitantes = new ArrayList<Integer> (){};


    public ArrayList<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<String> ciudades) {
        this.ciudades = ciudades;
    }


    public ArrayList<Integer> getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(ArrayList<Integer> numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }}



