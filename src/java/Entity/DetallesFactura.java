/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daggo Erazt
 */
@Entity
@Table(name = "detalles_factura", catalog = "prueba tecnica", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallesFactura.findAll", query = "SELECT d FROM DetallesFactura d")
    , @NamedQuery(name = "DetallesFactura.findByIdDetalle", query = "SELECT d FROM DetallesFactura d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetallesFactura.findByCantidad", query = "SELECT d FROM DetallesFactura d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetallesFactura.findByPrecioUnitario", query = "SELECT d FROM DetallesFactura d WHERE d.precioUnitario = :precioUnitario")})
public class DetallesFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Detalle", nullable = false)
    private Integer idDetalle;
    @Basic(optional = false)
    @Column(name = "Cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "PrecioUnitario", nullable = false)
    private float precioUnitario;
    @JoinColumn(name = "Id_Factura", referencedColumnName = "Id_Factura", nullable = false)
    @ManyToOne(optional = false)
    private Facturas idFactura;
    @JoinColumn(name = "Id_Producto", referencedColumnName = "Id_Productos", nullable = false)
    @ManyToOne(optional = false)
    private Productos idProducto;

    public DetallesFactura() {
    }

    public DetallesFactura(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallesFactura(Integer idDetalle, int cantidad, float precioUnitario) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesFactura)) {
            return false;
        }
        DetallesFactura other = (DetallesFactura) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DetallesFactura[ idDetalle=" + idDetalle + " ]";
    }
    
}
