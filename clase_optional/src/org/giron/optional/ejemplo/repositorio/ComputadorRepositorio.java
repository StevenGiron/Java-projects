package org.giron.optional.ejemplo.repositorio;

import org.giron.optional.ejemplo.models.Computador;
import org.giron.optional.ejemplo.models.Fabricante;
import org.giron.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador> {
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador procesador = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(procesador);
        dataSource.add(asus);
        dataSource.add(new Computador("MacBook Pro", "MVVK2CI"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {

        return dataSource.stream()
                .filter(computador -> computador.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        /*for (Computador computador : dataSource) {
            if (computador.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(computador);
            }
        }
        return Optional.empty();*/
    }
}
