package com.banquito.core.banking.cuentas.service;

import com.banquito.core.banking.cuentas.domain.Transaccion;
import com.banquito.core.banking.cuentas.dao.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private final TransaccionRepository transaccionRepository;

    
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }


    public Transaccion obtenerTransaccionPorCodigo(Long codigo) {
        return transaccionRepository.findById(codigo).orElse(null);
    }

    public List<Transaccion> obtenerTransaccionesPorCuenta(Long codigoCuenta) {
        return transaccionRepository.findByCuenta_Codigo(codigoCuenta);
    }

    public List<Transaccion> obtenerTransaccionesPorTipo(String tipoTransaccion) {
        return transaccionRepository.findByTipoTransaccion(tipoTransaccion);
    }

    public List<Transaccion> obtenerTransaccionesEnRangoDeFechas(Timestamp fechaInicio, Timestamp fechaFin) {
        return transaccionRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
    }

    public List<Transaccion> obtenerTransaccionesConValorHaberMayorQueValorDebe() {
        return transaccionRepository.findByValorHaberGreaterThanValorDebe();
    }
}
