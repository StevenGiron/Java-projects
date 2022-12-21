package org.giron.optional.ejemplo.repositorio;

import org.giron.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar (String nombre);
}
