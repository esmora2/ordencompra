package com.espe.ordencompra.services;

import com.espe.ordencompra.models.entities.OrdenCompra;
import com.espe.ordencompra.repositories.OrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenesRepository repository;

    @Override
    public List<OrdenCompra> findAll() {
        return (List<OrdenCompra>) repository.findAll();
    }

    @Override
    public Optional<OrdenCompra> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrdenCompra save(OrdenCompra orden) {
        return repository.save(orden);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
