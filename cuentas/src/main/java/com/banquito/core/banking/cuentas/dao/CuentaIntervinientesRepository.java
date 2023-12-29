package com.banquito.core.banking.cuentas.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.banquito.core.banking.cuentas.domain.CuentaIntervinientes;
import com.banquito.core.banking.cuentas.domain.CuentaIntervinientesPK;

public interface CuentaIntervinientesRepository extends CrudRepository<CuentaIntervinientes, CuentaIntervinientesPK> {


   
    List<CuentaIntervinientes> findByClienteId(@Param("clienteId") Long clienteId);

    List<CuentaIntervinientes> findByEstado(@Param("estado") String estado);

}
