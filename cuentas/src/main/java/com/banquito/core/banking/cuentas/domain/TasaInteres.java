package com.banquito.core.banking.cuentas.domain;

import java.util.List;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TASA_INTERES")
public class TasaInteres {

    @Id
    @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
    private String codigo;

    @OneToMany(mappedBy = "tasaInteres")
    private List<TipoCuenta> tipoCuenta;

    @Column(name = "TIPO_TASA_INTERES", nullable = false, length = 3)
    private String tipo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "TASA_MINIMA", nullable = false, length = 5, scale = 2)
    private Long tasaMinima;

    @Column(name = "TIPO_MAXIMA", nullable = false, length = 5, scale = 2)
    private Long tasaMaxima;

    @Version
    private Long version;
    public TasaInteres(String codigo) {
        this.codigo = codigo;
    }

   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }



    @Override
    public String toString() {
        return "TasaInteres [codigo=" + codigo + ", tipoCuenta=" + tipoCuenta + ", tipo=" + tipo + ", nombre=" + nombre
                + ", tasaMinima=" + tasaMinima + ", tasaMaxima=" + tasaMaxima + ", version=" + version + "]";
    }


}
