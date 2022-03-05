/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerJpa;

import ControllerJpa.exceptions.IllegalOrphanException;
import ControllerJpa.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entity.DetallesFactura;
import Entity.Productos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daggo Erazt
 */
public class ProductosJpaController implements Serializable {

    public ProductosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Prueba_TecnicaPU");;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean  Insert (String Producto){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("INSERT INTO `productos`(`Id_Productos`, `Producto`, `Estado`) VALUES (null,'"+Producto+"',1)");
            int Result = q.executeUpdate();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public List Productos() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT * FROM `productos`;");
            List Result = q.getResultList();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result.isEmpty()) {
                return null;
            }else{
                return Result;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean Update(int Id_Producto, String Producto){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("UPDATE `productos` SET `Producto`= '"+Producto+"' WHERE `Id_Productos`= "+Id_Producto+";");
            int Result = q.executeUpdate();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean Estado(int Id_Producto, int Estado){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("UPDATE `productos` SET `Estado`= "+Estado+" WHERE `Id_Productos`= "+Id_Producto+";");
            int Result = q.executeUpdate();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean Delate(int Id_Producto){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("DELETE FROM `productos` WHERE `productos`.`Id_Productos` = "+Id_Producto+" ");
            int Result = q.executeUpdate();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public List Id_Producto(int Id_Producto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT * FROM `productos` WHERE `Id_Productos` = "+Id_Producto+";");
            List Result = q.getResultList();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result.isEmpty()) {
                return null;
            }else{
                return Result;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List Filter(String Filtro) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("");
            List Result = q.getResultList();
            em.getTransaction().commit();
            em.clear();
            em.close();
            if (Result.isEmpty()) {
                return null;
            }else{
                return Result;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
