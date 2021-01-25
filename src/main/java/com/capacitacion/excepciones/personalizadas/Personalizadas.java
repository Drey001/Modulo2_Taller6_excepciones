package com.capacitacion.excepciones.personalizadas;

public class Personalizadas extends Exception {
    private String causa, tipoFalla;
    public Personalizadas(String causa, String tipoFalla){
        super("Causa: " + causa + "//// Tipo de Falla: " + tipoFalla);
        this.causa = causa;
        this.tipoFalla = tipoFalla;
    }
}
