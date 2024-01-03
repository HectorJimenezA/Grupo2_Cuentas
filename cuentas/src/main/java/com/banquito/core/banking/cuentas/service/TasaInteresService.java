package com.banquito.core.banking.cuentas.service;

import com.banquito.core.banking.cuentas.domain.TasaInteres;
import com.banquito.core.banking.cuentas.dao.TasaInteresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasaInteresService {

    @Autowired
    private final TasaInteresRepository tasaInteresRepository;

    
    public TasaInteresService(TasaInteresRepository tasaInteresRepository) {
        this.tasaInteresRepository = tasaInteresRepository;
    }

    public List<TasaInteres> obtenerTasasPorTipo(String tipo) {
        return tasaInteresRepository.findByTipo(tipo);
    }

    public List<TasaInteres> obtenerTasasEnRango(Long min, Long max) {
        return tasaInteresRepository.findByRango(min, max);
    }

    public List<TasaInteres> obtenerTasasOrdenadasPorNombreAsc() {
        return tasaInteresRepository.findByOrderByNombreAsc();
    }

    public List<TasaInteres> obtenerTasasPorTipoOrdenadasPorNombreDesc(String tipo) {
        return tasaInteresRepository.findByTipoOrderByNombreDesc(tipo);
    }

    public List<TasaInteres> buscarTasasPorNombre(String texto) {
        return tasaInteresRepository.findByNombreContainingIgnoreCase(texto);
    }
}