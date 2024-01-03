package com.banquito.core.banking.cuentas.controller;

import com.banquito.core.banking.cuentas.domain.Transaccion;
import com.banquito.core.banking.cuentas.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private final TransaccionService transaccionService;

    
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping("/{codigo}")
    public Transaccion obtenerTransaccionPorCodigo(@PathVariable Long codigo) {
        return transaccionService.obtenerTransaccionPorCodigo(codigo);
    }

    @GetMapping("/porCuenta/{codigoCuenta}")
    public List<Transaccion> obtenerTransaccionesPorCuenta(@PathVariable Long codigoCuenta) {
        return transaccionService.obtenerTransaccionesPorCuenta(codigoCuenta);
    }

    @GetMapping("/porTipo/{tipoTransaccion}")
    public List<Transaccion> obtenerTransaccionesPorTipo(@PathVariable String tipoTransaccion) {
        return transaccionService.obtenerTransaccionesPorTipo(tipoTransaccion);
    }

    @GetMapping("/enRangoDeFechas/{fechaInicio}/{fechaFin}")
    public List<Transaccion> obtenerTransaccionesEnRangoDeFechas(@PathVariable Timestamp fechaInicio, @PathVariable Timestamp fechaFin) {
        return transaccionService.obtenerTransaccionesEnRangoDeFechas(fechaInicio, fechaFin);
    }

    @GetMapping("/conValorHaberMayorQueValorDebe")
    public List<Transaccion> obtenerTransaccionesConValorHaberMayorQueValorDebe() {
        return transaccionService.obtenerTransaccionesConValorHaberMayorQueValorDebe();
    }
    
}

