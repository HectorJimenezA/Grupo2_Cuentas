package com.banquito.core.banking.cuentas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.cuentas.domain.Cuenta;
import com.banquito.core.banking.cuentas.dao.CuentaRepository;
import com.banquito.core.banking.cuentas.domain.TipoCuenta;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Optional<Cuenta> getCuentaById(Long codigo) {
        return cuentaRepository.findById(codigo);
    }

    public List<Cuenta> getCuentasByNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

    public List<Cuenta> getCuentasByTipoCuenta(TipoCuenta tipoCuenta) {
        return cuentaRepository.findByTipoCuenta(tipoCuenta);
    }

    public List<Cuenta> getCuentasWithSaldoContableGreaterThan(Long saldo) {
        return cuentaRepository.findBySaldoContableGreaterThan(saldo);
    }

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long codigo) {
        cuentaRepository.deleteById(codigo);
    }
}
