package org.giron.mockito.ejemplos.repositories;

import org.giron.mockito.ejemplos.models.Examen;

import java.util.List;

public interface IExamenRepository {
    List<Examen> findAll();
    Examen guardar(Examen examen);
}
