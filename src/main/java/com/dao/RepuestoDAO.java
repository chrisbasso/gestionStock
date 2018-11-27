package com.dao;

import com.domain.Repuesto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RepuestoDAO {

    private EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("org.hibernate.tutorial.jpa");

    public RepuestoDAO() {
    }

    public List<Repuesto> getRepuestos(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }

    public List<Repuesto> getRepuestosByName(String nombre){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Repuesto> result = entityManager.createQuery( "from Repuesto where nombre like '%" + nombre + "%'", Repuesto.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }

    public void updateCantidad(long id, int cantidad){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery( "update Repuesto set cantidad = cantidad+" + cantidad + " where id = " + id).executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();

    }




}




