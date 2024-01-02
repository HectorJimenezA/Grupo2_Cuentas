package com.banquito.core.banking.cuentas.controller;
import com.banquito.core.banking.cuentas.domain.TipoCuenta;
import com.banquito.core.banking.cuentas.service.TipoCuentaService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/tipoCuentas")
public class TipoCuentaController {

    private final TipoCuentaService tipoCuentaService;

    public TipoCuentaController(TipoCuentaService tipoCuentaService) {
        this.tipoCuentaService = tipoCuentaService;
    }

    @GetMapping("/nombre/{nombre}")
    public List<TipoCuenta> obtenerTipoCuentaPorNombre(@PathVariable String nombre) {
        return tipoCuentaService.obtenerTipoCuentaPorNombre(nombre);
    }

    @GetMapping("/tipoCapitalizacion/{tipoCapitalizacion}")
    public List<TipoCuenta> obtenerTipoCuentaPorTipoCapitalizacion(@PathVariable String tipoCapitalizacion) {
        return tipoCuentaService.obtenerTipoCuentaPorTipoCapitalizacion(tipoCapitalizacion);
    }

    @GetMapping("/codigoTasaInteres/{codigoTasaInteres}")
    public List<TipoCuenta> obtenerTipoCuentaPorCodigoTasaInteres(@PathVariable String codigoTasaInteres) {
        return tipoCuentaService.obtenerTipoCuentaPorCodigoTasaInteres(codigoTasaInteres);
    }

    @GetMapping("/fechaCreacionDespuesDe/{fecha}")
    public List<TipoCuenta> obtenerTipoCuentaPorFechaCreacionDespuesDe(@PathVariable Timestamp fecha) {
        return tipoCuentaService.obtenerTipoCuentaPorFechaCreacionDespuesDe(fecha);
    }
}
