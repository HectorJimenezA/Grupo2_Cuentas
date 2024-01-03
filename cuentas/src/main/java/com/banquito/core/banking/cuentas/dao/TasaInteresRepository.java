package com.banquito.core.banking.cuentas.dao;
import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.cuentas.domain.TasaInteres;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TasaInteresRepository extends CrudRepository<TasaInteresRepository, Long> {

    List<TasaInteres> findByTipo(String tipo);

    @Query("SELECT ti FROM TasaInteres ti WHERE ti.tasaMinima >= :min AND ti.tasaMaxima <= :max")
    List<TasaInteres> findByRango(@Param("min") Long min, @Param("max") Long max);

    List<TasaInteres> findByOrderByNombreAsc();

    List<TasaInteres> findByTipoOrderByNombreDesc(String tipo);

    @Query("SELECT ti FROM TasaInteres ti WHERE LOWER(ti.nombre) LIKE LOWER(CONCAT('%', :texto, '%'))")
    List<TasaInteres> findByNombreContainingIgnoreCase(@Param("texto") String texto);
}