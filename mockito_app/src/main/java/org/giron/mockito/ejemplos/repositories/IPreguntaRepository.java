package org.giron.mockito.ejemplos.repositories;

import java.util.List;

public interface IPreguntaRepository {
    List<String> findPreguntasPorExamenId(Long id);

    void guardarPreguntas(List<String> preguntas);
}
