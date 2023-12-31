package com.banquito.core.banking.cuentas.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CUENTA")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "COD_TIPO_CUENTA")
    private TipoCuenta tipoCuenta;

    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transacciones;

    @OneToMany(mappedBy = "cuenta")
    private List<CuentaIntervinientes> cuentaIntervinientes;

    @Column(name = "NUMERO_CUENTA", nullable = false, length = 8)
    private String numeroCuenta;

    @Column(name = "SALDO_CONTABLE", nullable = false, length = 18, scale = 2)
    private Long saldoContable;

    @Column(name = "SALDO_DISPONIBLE", nullable = false, length = 18, scale = 2)
    private Long saldoDisponible;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    private Timestamp fechaUltimoCambio;

    @Version
    private Long version;

    public Cuenta(Long codigo) {
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
        if (obj == null || getClass() != obj.getClass())
            return false;
        Cuenta other = (Cuenta) obj;
        return codigo != null && codigo.equals(other.codigo);
    }

    @Override
    public String toString() {
        return "Cuenta [codigo=" + codigo + ", tipoCuenta=" + tipoCuenta + ", transacciones=" + transacciones
                + ", cuentaIntervinientes=" + cuentaIntervinientes + ", numeroCuenta=" + numeroCuenta
                + ", saldoContable=" + saldoContable + ", saldoDisponible=" + saldoDisponible + ", estado=" + estado
                + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoCambio=" + fechaUltimoCambio + ", version="
                + version + "]";
    }
}
