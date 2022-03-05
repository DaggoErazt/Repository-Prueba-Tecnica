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
import Entity.Facturas;
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
public class FacturasJpaController implements Serializable {

    public FacturasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Prueba_TecnicaPU");;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean  Insert (int Factura, long Documento ,String Fecha,  String Nombre,  String Pago,Float Total){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("INSERT INTO `facturas`(`Id_Factura`, `Numero_Factura`, `Fecha`, `Tipo_Pago`, `DocumentoCliente`, `NombreCliente`, `Total`) VALUES (null,"+Factura+",'"+Fecha+"','"+Pago+"',"+Documento+",'"+Nombre+"',"+Total+");");
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
    
    public List Factura(int Factura) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT * FROM `facturas` WHERE `Numero_Factura` = "+Factura+";");
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
    public List Facturas() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT * FROM `facturas`;");
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

    public boolean Delate(int Id_Producto){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("DELETE FROM `facturas` WHERE `Id_Factura` = "+Id_Producto+";");
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
    
    public List Id_Factura(int Id_Factura) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT * FROM `facturas` WHERE `Id_Factura` = "+Id_Factura+";");
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
