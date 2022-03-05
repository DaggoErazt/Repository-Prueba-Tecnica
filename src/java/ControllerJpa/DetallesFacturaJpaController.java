/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerJpa;

import ControllerJpa.exceptions.NonexistentEntityException;
import Entity.DetallesFactura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entity.Facturas;
import Entity.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daggo Erazt
 */
public class DetallesFacturaJpaController implements Serializable {

    public DetallesFacturaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Prueba_TecnicaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
        public boolean  Insert (int Id_Factura,int Id_Producto,int Cantidad,float PresioU,int Iva, int Descuento){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("INSERT INTO `detalles_factura`(`Id_Detalle`, `Id_Factura`, `Id_Producto`, `Cantidad`, `PrecioUnitario`, `Iva`, `Descuento`) VALUES (null,"+Id_Factura+","+Id_Producto+","+Cantidad+","+PresioU+","+Iva+","+Descuento+");");
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
    public boolean Delate(int Id_Detalle){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("DELETE FROM `detalles_factura` WHERE `Id_Detalle`= "+Id_Detalle+";");
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
            Query q = em.createNativeQuery("SELECT `Id_Detalle`, `Id_Factura`, `Id_Producto`, `Cantidad`, `PrecioUnitario`, `Iva`, `Descuento` FROM `detalles_factura` WHERE `Id_Factura` = "+Id_Factura+";");
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
