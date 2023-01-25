package org.giron.mockito.ejemplos.services;

import org.giron.mockito.ejemplos.models.Examen;
import org.giron.mockito.ejemplos.repositories.IExamenRepository;
import org.giron.mockito.ejemplos.repositories.IPreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenService implements IExamenService {
    private IExamenRepository examenRepository;
    private IPreguntaRepository preguntaRepository;

    public ExamenService(IExamenRepository examenRepository, IPreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll()
                .stream()
                .filter(examen -> examen.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> optionalExamen = findExamenPorNombre(nombre);
        Examen examen = null;
        if (optionalExamen.isPresent()){
            examen = optionalExamen.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {
        if (!examen.getPreguntas().isEmpty()){
            preguntaRepository.guardarPreguntas(examen.getPreguntas());
        }
        return examenRepository.guardar(examen);
    }
}
