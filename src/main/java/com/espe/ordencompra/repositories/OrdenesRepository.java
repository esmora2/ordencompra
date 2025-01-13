package com.espe.ordencompra.repositories;

import com.espe.ordencompra.models.entities.OrdenCompra;
import org.springframework.data.repository.CrudRepository;

public interface OrdenesRepository extends CrudRepository<OrdenCompra, Long> {
}
