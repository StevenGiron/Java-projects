package com.bolsadeideas.springboot.data.jpa.app.models.service;

import com.bolsadeideas.springboot.data.jpa.app.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();

    public Cliente findOne(Long id);

    public void save(Cliente cliente);

    public void delete(Long id);
}

