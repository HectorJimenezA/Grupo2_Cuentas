package com.banquito.core.banking.cuentas.dao;

import com.banquito.core.banking.cuentas.domain.TipoCuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TipoCuentaRepository extends CrudRepository<TipoCuenta, String> {

    List<TipoCuenta> findByNombre(String nombre);

    List<TipoCuenta> findByTipoCapitalizacion(String tipoCapitalizacion);

    List<TipoCuenta> findByCodigoTasaInteres(String codigoTasaInteres);

    List<TipoCuenta> findByFechaCreacionAfter(Timestamp fecha);
}
