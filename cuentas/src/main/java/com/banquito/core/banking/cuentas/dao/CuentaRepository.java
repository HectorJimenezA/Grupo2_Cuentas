package com.banquito.core.banking.cuentas.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.banquito.core.banking.cuentas.domain.Cuenta;
import com.banquito.core.banking.cuentas.domain.TipoCuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long>{

    List<Cuenta> findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findByTipoCuenta(TipoCuenta tipoCuenta);

    List<Cuenta> findBySaldoContableGreaterThan(@Param("saldo") long saldo);

}
