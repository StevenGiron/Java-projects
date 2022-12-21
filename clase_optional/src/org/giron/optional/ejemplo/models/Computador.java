package org.giron.optional.ejemplo.models;

public class Computador {
    private String nombre;
    private  String modelo;
    private Procesador procesador;

    public Computador(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return nombre + ", " + modelo;
    }
}
