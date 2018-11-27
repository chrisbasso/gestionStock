package com.domain;

public class Venta extends Movimiento {

    public Venta() {
    }

    public Venta(double monto, Repuesto repuesto, int cantidad) {
        super(monto, repuesto, cantidad);
    }

    @Override
    public void ejecutarTransaccion(double monto, int cantidad) {

    }
}
