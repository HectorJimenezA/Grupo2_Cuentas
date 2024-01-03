package com.banquito.core.banking.cuentas.domain;

import java.sql.Timestamp;

import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {

    @Id
    @Column(name = "COD_TIPO_CUENTA", nullable = false, length = 10)
    private String codigo;

    @OneToMany(mappedBy = "tipoCuenta")
    private List<Cuenta> cuenta;

    @ManyToOne()
    @JoinColumn(name = "COD_TASA_INTERES")
    private TasaInteres tasaIntereses;

    @Column(name = "COD_TASA_INTERES", nullable = false, length = 8)
    private String codigoTasaInteres;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "TIPO_CAPITALIZACION", nullable = false, length = 3)
    private String tipoCapitalizacion;

    @Column(name = "FORMA_CAPITALIZACION", nullable = false, length = 3)
    private String formaCapitalizacion;

    @Column(name = "MAXIMO_NUMERO_INTERVINIENTES", nullable = false, length = 2)
    private String MaximoNumeroIntervinientes;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;

    @Version
    private Long version;

    public TipoCuenta(String codigo) {
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TipoCuenta other = (TipoCuenta) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "TipoCuenta [codigo=" + codigo + ", cuenta=" + cuenta + ", tasaIntereses=" + tasaIntereses
                + ", codigoTasaInteres=" + codigoTasaInteres + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", tipoCapitalizacion=" + tipoCapitalizacion + ", formaCapitalizacion=" + formaCapitalizacion
                + ", MaximoNumeroIntervinientes=" + MaximoNumeroIntervinientes + ", fechaCreacion=" + fechaCreacion
                + "]";
    }


}
