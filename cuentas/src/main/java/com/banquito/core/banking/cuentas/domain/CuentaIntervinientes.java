package com.banquito.core.banking.cuentas.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CUENTA_INTERVINIENTES")
public class CuentaIntervinientes {

    @EmbeddedId
    private CuentaIntervinientesPK cuentaIntervinientesPK;

    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Version
    private long version;

    public CuentaIntervinientes(CuentaIntervinientesPK cuentaIntervinientesId) {
        this.cuentaIntervinientesPK = cuentaIntervinientesId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cuentaIntervinientesPK == null) ? 0 : cuentaIntervinientesPK.hashCode());
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
        CuentaIntervinientes other = (CuentaIntervinientes) obj;
        if (cuentaIntervinientesPK == null) {
            if (other.cuentaIntervinientesPK != null)
                return false;
        } else if (!cuentaIntervinientesPK.equals(other.cuentaIntervinientesPK))
            return false;
        return true;
    }

}
