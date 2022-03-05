/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daggo Erazt
 */
@Entity
@Table(name = "productos", catalog = "prueba tecnica", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProductos", query = "SELECT p FROM Productos p WHERE p.idProductos = :idProductos")
    , @NamedQuery(name = "Productos.findByProducto", query = "SELECT p FROM Productos p WHERE p.producto = :producto")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Productos", nullable = false)
    private Integer idProductos;
    @Basic(optional = false)
    @Column(name = "Producto", nullable = false, length = 32)
    private String producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<DetallesFactura> detallesFacturaCollection;

    public Productos() {
    }

    public Productos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public Productos(Integer idProductos, String producto) {
        this.idProductos = idProductos;
        this.producto = producto;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @XmlTransient
    public Collection<DetallesFactura> getDetallesFacturaCollection() {
        return detallesFacturaCollection;
    }

    public void setDetallesFacturaCollection(Collection<DetallesFactura> detallesFacturaCollection) {
        this.detallesFacturaCollection = detallesFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductos != null ? idProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProductos == null && other.idProductos != null) || (this.idProductos != null && !this.idProductos.equals(other.idProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productos[ idProductos=" + idProductos + " ]";
    }
    
}
