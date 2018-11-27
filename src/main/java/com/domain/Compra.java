package com.domain;

public class Compra extends Movimiento {

    public Compra() {
    }

    public Compra(double monto, Repuesto repuesto, int cantidad) {
        super(monto, repuesto, cantidad);
    }

    @Override
    public void ejecutarTransaccion(double monto, int cantidad) {

        this.monto += monto;
        this.cantidad += cantidad;

    }
}
