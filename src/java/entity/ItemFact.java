/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samsung
 */
@Entity
@Table(name = "ITEM_FACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemFact.findAll", query = "SELECT i FROM ItemFact i"),
    @NamedQuery(name = "ItemFact.findById", query = "SELECT i FROM ItemFact i WHERE i.id = :id"),
    @NamedQuery(name = "ItemFact.findByCantidad", query = "SELECT i FROM ItemFact i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemFact.findByDescuento", query = "SELECT i FROM ItemFact i WHERE i.descuento = :descuento"),
    @NamedQuery(name = "ItemFact.findByIva", query = "SELECT i FROM ItemFact i WHERE i.iva = :iva"),
    @NamedQuery(name = "ItemFact.findByPreciounit", query = "SELECT i FROM ItemFact i WHERE i.preciounit = :preciounit"),
    @NamedQuery(name = "ItemFact.findBySubtotal", query = "SELECT i FROM ItemFact i WHERE i.subtotal = :subtotal"),
    @NamedQuery(name = "ItemFact.findByTotal", query = "SELECT i FROM ItemFact i WHERE i.total = :total"),
    @NamedQuery(name = "ItemFact.findByUnidad", query = "SELECT i FROM ItemFact i WHERE i.unidad = :unidad")})
public class ItemFact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Column(name = "IVA")
    private Double iva;
    @Column(name = "PRECIOUNIT")
    private Double preciounit;
    @Column(name = "SUBTOTAL")
    private Double subtotal;
    @Column(name = "TOTAL")
    private Double total;
    @Size(max = 255)
    @Column(name = "UNIDAD")
    private String unidad;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Producto productoId;
    @JoinColumn(name = "FACTURA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Factura facturaId;

    public ItemFact() {
    }

    public ItemFact(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getPreciounit() {
        return preciounit;
    }

    public void setPreciounit(Double preciounit) {
        this.preciounit = preciounit;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Factura getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Factura facturaId) {
        this.facturaId = facturaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemFact)) {
            return false;
        }
        ItemFact other = (ItemFact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemFact[ id=" + id + " ]";
    }
    
}
