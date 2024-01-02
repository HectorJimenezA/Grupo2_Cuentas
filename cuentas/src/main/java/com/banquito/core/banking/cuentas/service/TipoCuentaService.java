package com.banquito.core.banking.cuentas.service;

import com.banquito.core.banking.cuentas.domain.TipoCuenta;
import com.banquito.core.banking.cuentas.dao.TipoCuentaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TipoCuentaService {

    private final TipoCuentaRepository tipoCuentaRepository;

    public TipoCuentaService(TipoCuentaRepository tipoCuentaRepository) {
        this.tipoCuentaRepository = tipoCuentaRepository;
    }

    public List<TipoCuenta> obtenerTipoCuentaPorNombre(String nombre) {
        return tipoCuentaRepository.findByNombre(nombre);
    }

    public List<TipoCuenta> obtenerTipoCuentaPorTipoCapitalizacion(String tipoCapitalizacion) {
        return tipoCuentaRepository.findByTipoCapitalizacion(tipoCapitalizacion);
    }

    public List<TipoCuenta> obtenerTipoCuentaPorCodigoTasaInteres(String codigoTasaInteres) {
        return tipoCuentaRepository.findByCodigoTasaInteres(codigoTasaInteres);
    }

    public List<TipoCuenta> obtenerTipoCuentaPorFechaCreacionDespuesDe(Timestamp fecha) {
        return tipoCuentaRepository.findByFechaCreacionAfter(fecha);
    }
}
