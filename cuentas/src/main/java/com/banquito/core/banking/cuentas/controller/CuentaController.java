package com.banquito.core.banking.cuentas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.core.banking.cuentas.domain.Cuenta;
import com.banquito.core.banking.cuentas.service.CuentaService;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;


    @GetMapping("/{codigo}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable("codigo") Long codigo) {
        Optional<Cuenta> cuenta = cuentaService.getCuentaById(codigo);
        return cuenta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/numero-cuenta/{numeroCuenta}")
    public ResponseEntity<List<Cuenta>> getCuentasByNumeroCuenta(@PathVariable("numeroCuenta") String numeroCuenta) {
        List<Cuenta> cuentas = cuentaService.getCuentasByNumeroCuenta(numeroCuenta);
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }


    @GetMapping("/saldo-contable-greater-than/{saldo}")
    public ResponseEntity<List<Cuenta>> getCuentasWithSaldoContableGreaterThan(@PathVariable("saldo") Long saldo) {
        List<Cuenta> cuentas = cuentaService.getCuentasWithSaldoContableGreaterThan(saldo);
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cuenta> saveCuenta(@RequestBody Cuenta cuenta) {
        Cuenta savedCuenta = cuentaService.saveCuenta(cuenta);
        return new ResponseEntity<>(savedCuenta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable("codigo") Long codigo) {
        cuentaService.deleteCuenta(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
