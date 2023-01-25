package org.giron.mockito.ejemplos.services;

import org.giron.mockito.ejemplos.models.Examen;
import org.giron.mockito.ejemplos.repositories.IExamenRepository;
import org.giron.mockito.ejemplos.repositories.IPreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //Mockear usando la dependencia mockito-junit
class ExamenServiceTest {
    @Mock
    IExamenRepository examenRepository;
    @Mock
    IPreguntaRepository preguntaRepository;
    @InjectMocks
    ExamenService service;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this); // Una forma de mockear los repositorios y crear la instancia del servicio

//        Forma normal de mockear
//        this.examenRepository = mock(IExamenRepository.class);
//        this.preguntaRepository = mock(IPreguntaRepository.class);
//
//        this.service = new ExamenService(examenRepository, preguntaRepository);
    }

    @Test
    void findExamenPorNombre() {

        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.orElseThrow().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {

        List<Examen> datos = Collections.emptyList();

        when(examenRepository.findAll()).thenReturn(datos);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntaExamen() {
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");

        assertEquals(4, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("geometría"));

    }

    @Test
    void testPreguntaExamenVerify() {
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");

        assertEquals(4, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("geometría"));
        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());

    }

    @Test
    void testNoExisteExamenVerify() {
        when(examenRepository.findAll()).thenReturn(Collections.emptyList());
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("MAtematicas");

        assertNull(examen);
        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());

    }

    @Test
    void testGuardarExamen() {
        Examen examenNuevo = Datos.EXAMEN;
        examenNuevo.setPreguntas(Datos.PREGUNTAS);

        when(examenRepository.guardar(any(Examen.class))).thenReturn(Datos.EXAMEN);
        Examen examen = service.guardar(examenNuevo);

        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("física", examenNuevo.getNombre());

        verify(examenRepository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarPreguntas(anyList());
    }

    @Test
    void testGuardarExamenConAnswer() {
        // Given
        Examen examenNuevo = Datos.EXAMEN;
        examenNuevo.setPreguntas(Datos.PREGUNTAS);

        when(examenRepository.guardar(any(Examen.class))).then(new Answer<Examen>() {

            Long secuencia = 9L;

            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });

        // When
        Examen examen = service.guardar(examenNuevo);

        // Then
        assertNotNull(examen.getId());
        assertEquals(9L, examen.getId());
        assertEquals("física", examenNuevo.getNombre());

        verify(examenRepository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarPreguntas(anyList());
    }
}