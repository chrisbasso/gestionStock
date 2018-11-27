package com.services;

import com.dao.RepuestoDAO;
import com.domain.Repuesto;

import java.util.List;

public class RepuestoService {

    private RepuestoDAO repuestoDAO = new RepuestoDAO();

    public List<Repuesto> getRepuestos() {

        return repuestoDAO.getRepuestos();
    }

    public List<Repuesto> getRepuestos(String nombre) {

        return repuestoDAO.getRepuestosByName(nombre);
    }

    public void updateCantidad(long id, int cantidad) {

        repuestoDAO.updateCantidad(id, cantidad);

    }
}