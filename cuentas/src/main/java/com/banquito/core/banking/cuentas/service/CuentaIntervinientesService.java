package com.banquito.core.banking.cuentas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.cuentas.dao.CuentaIntervinientesRepository;
import com.banquito.core.banking.cuentas.domain.CuentaIntervinientes;
import com.banquito.core.banking.cuentas.domain.CuentaIntervinientesPK;

import java.util.List;

@Service
public class CuentaIntervinientesService {

    @Autowired
    private CuentaIntervinientesRepository cuentaIntervinientesRepository;

    public CuentaIntervinientes getCuentaIntervinientesById(CuentaIntervinientesPK id) {
        return cuentaIntervinientesRepository.findById(id).orElse(null);
    }

    public List<CuentaIntervinientes> getCuentaIntervinientesByClienteId(Long clienteId) {
        return cuentaIntervinientesRepository.findByClienteId(clienteId);
    }

    public List<CuentaIntervinientes> getCuentaIntervinientesByEstado(String estado) {
        return cuentaIntervinientesRepository.findByEstado(estado);
    }

    public CuentaIntervinientes saveCuentaIntervinientes(CuentaIntervinientes cuentaIntervinientes) {
        return cuentaIntervinientesRepository.save(cuentaIntervinientes);
    }

    public void deleteCuentaIntervinientes(CuentaIntervinientesPK id) {
        cuentaIntervinientesRepository.deleteById(id);
    }
}
