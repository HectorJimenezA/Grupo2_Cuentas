package com.banquito.core.banking.cuentas.dao;

import com.banquito.core.banking.cuentas.domain.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {

    List<Transaccion> findByCuenta_Codigo(Long codigoCuenta);

    List<Transaccion> findByTipoTransaccion(String tipoTransaccion);

    List<Transaccion> findByFechaCreacionBetween(@Param("fechaInicio") Timestamp fechaInicio, @Param("fechaFin") Timestamp fechaFin);

    List<Transaccion> findByValorHaberGreaterThanValorDebe();
}
