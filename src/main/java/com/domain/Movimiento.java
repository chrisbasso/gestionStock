package com.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public abstract class Movimiento {

    @Id
    protected long id;

    protected double monto;
    protected int cantidad;

    @OneToOne(cascade = CascadeType.ALL)
    protected Repuesto repuesto;

    public Movimiento(){}

    public Movimiento(double monto, Repuesto repuesto, int cantidad) {
        this.monto = monto;
        this.repuesto = repuesto;
        this.cantidad = cantidad;
    }

    public abstract void ejecutarTransaccion(double monto, int cantidad);

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }
}
