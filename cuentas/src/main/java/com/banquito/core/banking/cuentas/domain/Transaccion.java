package com.banquito.core.banking.cuentas.domain;

import java.sql.Timestamp;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TRANSACCION")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TRANSACCION", nullable = false)
    private Long codigo;

    @ManyToOne()
    @JoinColumn(name = "COD_CUENTA")
    private Cuenta cuenta;
    
    @Column(name = "COD_UNICO", nullable = false, length = 64)
    private String codigoUnico;

    @Column(name = "TIPO_AFECTACION", nullable = false, length = 1)
    private String tipoAfectacion;

    @Column(name = "VALOR_DEBE", nullable = false, precision = 18, scale = 2)
    private Long valorDebe;

    @Column(name = "VALOR_HABER", nullable = false, precision = 18, scale = 2)
    private Long valorHaber;

    @Column(name = "TIPO_TRANSACCION", nullable = false, length = 8)
    private String tipoTransaccion;

    @Column(name = "DETALLE", nullable = false, length = 50)
    private String detalle;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "FECHA_AFECTACION")
    private Timestamp fechaAfectacion;

    @Version
    private Long version;

    public Transaccion(Long codigo) {
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
        Transaccion other = (Transaccion) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transaccion [codigo=" + codigo + ", cuenta=" + cuenta + ", codigoUnico=" + codigoUnico
                + ", tipoAfectacion=" + tipoAfectacion + ", valorDebe=" + valorDebe + ", valorHaber=" + valorHaber
                + ", tipoTransaccion=" + tipoTransaccion + ", detalle=" + detalle + ", fechaCreacion=" + fechaCreacion
                + ", estado=" + estado + ", fechaAfectacion=" + fechaAfectacion + ", version=" + version + "]";
    }

    

}
