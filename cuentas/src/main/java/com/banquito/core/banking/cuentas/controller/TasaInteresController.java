package com.banquito.core.banking.cuentas.controller;

import com.banquito.core.banking.cuentas.domain.TasaInteres;
import com.banquito.core.banking.cuentas.service.TasaInteresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasasInteres")
public class TasaInteresController {

    @Autowired
    private final TasaInteresService tasaInteresService;
    
    public TasaInteresController(TasaInteresService tasaInteresService) {
        this.tasaInteresService = tasaInteresService;
    }

    @GetMapping("/porTipo/{tipo}")
    public List<TasaInteres> obtenerTasasPorTipo(@PathVariable String tipo) {
        return tasaInteresService.obtenerTasasPorTipo(tipo);
    }

    @GetMapping("/enRango/{min}/{max}")
    public List<TasaInteres> obtenerTasasEnRango(@PathVariable Long min, @PathVariable Long max) {
        return tasaInteresService.obtenerTasasEnRango(min, max);
    }

    @GetMapping("/ordenadasPorNombreAsc")
    public List<TasaInteres> obtenerTasasOrdenadasPorNombreAsc() {
        return tasaInteresService.obtenerTasasOrdenadasPorNombreAsc();
    }

    @GetMapping("/porTipoOrdenadasPorNombreDesc/{tipo}")
    public List<TasaInteres> obtenerTasasPorTipoOrdenadasPorNombreDesc(@PathVariable String tipo) {
        return tasaInteresService.obtenerTasasPorTipoOrdenadasPorNombreDesc(tipo);
    }

    @GetMapping("/buscarPorNombre/{texto}")
    public List<TasaInteres> buscarTasasPorNombre(@PathVariable String texto) {
        return tasaInteresService.buscarTasasPorNombre(texto);
    }
}
