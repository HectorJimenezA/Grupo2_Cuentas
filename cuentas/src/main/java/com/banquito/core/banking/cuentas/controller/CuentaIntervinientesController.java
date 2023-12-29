package com.banquito.core.banking.cuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.banquito.core.banking.cuentas.domain.CuentaIntervinientes;
import com.banquito.core.banking.cuentas.domain.CuentaIntervinientesPK;
import com.banquito.core.banking.cuentas.service.CuentaIntervinientesService;

import java.util.List;

@RestController
@RequestMapping("/cuentaIntervinientes")
public class CuentaIntervinientesController {

    @Autowired
    private CuentaIntervinientesService cuentaIntervinientesService;

    @GetMapping("/{id}")
    public CuentaIntervinientes getCuentaIntervinientesById(@PathVariable CuentaIntervinientesPK id) {
        return cuentaIntervinientesService.getCuentaIntervinientesById(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<CuentaIntervinientes> getCuentaIntervinientesByClienteId(@PathVariable Long clienteId) {
        return cuentaIntervinientesService.getCuentaIntervinientesByClienteId(clienteId);
    }

    @GetMapping("/estado/{estado}")
    public List<CuentaIntervinientes> getCuentaIntervinientesByEstado(@PathVariable String estado) {
        return cuentaIntervinientesService.getCuentaIntervinientesByEstado(estado);
    }

    @PostMapping
    public CuentaIntervinientes saveCuentaIntervinientes(@RequestBody CuentaIntervinientes cuentaIntervinientes) {
        return cuentaIntervinientesService.saveCuentaIntervinientes(cuentaIntervinientes);
    }

    @DeleteMapping("/{id}")
    public void deleteCuentaIntervinientes(@PathVariable CuentaIntervinientesPK id) {
        cuentaIntervinientesService.deleteCuentaIntervinientes(id);
    }
}
