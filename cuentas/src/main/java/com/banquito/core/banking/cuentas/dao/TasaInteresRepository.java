package com.banquito.core.banking.cuentas.dao;
import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.cuentas.domain.TasaInteres;

public interface TasaInteresRepository extends CrudRepository<TasaInteresRepository, Long> {
TasaInteres findbyTipoTasaInteres(String tipo);
}
