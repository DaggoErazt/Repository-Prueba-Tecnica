/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daggo Erazt
 */
@Entity
@Table(name = "facturas", catalog = "prueba tecnica", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByIdFactura", query = "SELECT f FROM Facturas f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Facturas.findByNumeroFactura", query = "SELECT f FROM Facturas f WHERE f.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Facturas.findByTipoPago", query = "SELECT f FROM Facturas f WHERE f.tipoPago = :tipoPago")
    , @NamedQuery(name = "Facturas.findByDocumentoCliente", query = "SELECT f FROM Facturas f WHERE f.documentoCliente = :documentoCliente")
    , @NamedQuery(name = "Facturas.findByNombreCliente", query = "SELECT f FROM Facturas f WHERE f.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Facturas.findBySubtotal", query = "SELECT f FROM Facturas f WHERE f.subtotal = :subtotal")
    , @NamedQuery(name = "Facturas.findByDescuento", query = "SELECT f FROM Facturas f WHERE f.descuento = :descuento")
    , @NamedQuery(name = "Facturas.findByIva", query = "SELECT f FROM Facturas f WHERE f.iva = :iva")
    , @NamedQuery(name = "Facturas.findByTotalDescuento", query = "SELECT f FROM Facturas f WHERE f.totalDescuento = :totalDescuento")
    , @NamedQuery(name = "Facturas.findByTotalImpuesto", query = "SELECT f FROM Facturas f WHERE f.totalImpuesto = :totalImpuesto")
    , @NamedQuery(name = "Facturas.findByTotal", query = "SELECT f FROM Facturas f WHERE f.total = :total")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Factura", nullable = false)
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "Numero_Factura", nullable = false)
    private int numeroFactura;
    @Basic(optional = false)
    @Column(name = "Fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Tipo_Pago", nullable = false, length = 12)
    private String tipoPago;
    @Basic(optional = false)
    @Column(name = "DocumentoCliente", nullable = false)
    private int documentoCliente;
    @Basic(optional = false)
    @Column(name = "NombreCliente", nullable = false, length = 32)
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "Subtotal", nullable = false)
    private float subtotal;
    @Basic(optional = false)
    @Column(name = "Descuento", nullable = false)
    private int descuento;
    @Basic(optional = false)
    @Column(name = "IVA", nullable = false, length = 12)
    private String iva;
    @Basic(optional = false)
    @Column(name = "TotalDescuento", nullable = false)
    private float totalDescuento;
    @Basic(optional = false)
    @Column(name = "TotalImpuesto", nullable = false)
    private float totalImpuesto;
    @Basic(optional = false)
    @Column(name = "Total", nullable = false)
    private float total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<DetallesFactura> detallesFacturaCollection;

    public Facturas() {
    }

    public Facturas(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Facturas(Integer idFactura, int numeroFactura, Date fecha, String tipoPago, int documentoCliente, String nombreCliente, float subtotal, int descuento, String iva, float totalDescuento, float totalImpuesto, float total) {
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalDescuento = totalDescuento;
        this.totalImpuesto = totalImpuesto;
        this.total = total;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public float getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(float totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Facturas[ idFactura=" + idFactura + " ]";
    }
    
}
