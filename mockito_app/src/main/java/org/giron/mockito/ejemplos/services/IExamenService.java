package org.giron.mockito.ejemplos.services;

import org.giron.mockito.ejemplos.models.Examen;

import java.util.Optional;

public interface IExamenService {
    Optional<Examen> findExamenPorNombre(String nombre);

    Examen findExamenPorNombreConPreguntas(String nombre);

    Examen guardar(Examen examen);

}

