package com.espe.ordencompra.services;

import com.espe.ordencompra.models.entities.OrdenCompra;

import java.util.List;
import java.util.Optional;

public interface OrdenService {

    List<OrdenCompra> findAll();
    Optional<OrdenCompra> findById(Long id);
    OrdenCompra save(OrdenCompra orden);
    void deleteById(Long id);
}
