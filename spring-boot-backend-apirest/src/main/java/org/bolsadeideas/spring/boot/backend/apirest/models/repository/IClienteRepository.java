package org.bolsadeideas.spring.boot.backend.apirest.models.repository;

import org.bolsadeideas.spring.boot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Long> { //primer tipo es la clase entity asociada, segundo el tipo del atributo Id

}
