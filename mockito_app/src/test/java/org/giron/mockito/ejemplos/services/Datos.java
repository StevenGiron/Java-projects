package org.giron.mockito.ejemplos.services;

import org.giron.mockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static  List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matematicas"),
            new Examen(6L, "Lenguaje"),
            new Examen(7L, "Historias"));

    public final static List<String> PREGUNTAS = Arrays.asList("aritmética","integrales","derivadas", "geometría");

    public final static Examen EXAMEN = new Examen(8l, "física");
}
