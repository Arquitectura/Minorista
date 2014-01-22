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
@Table(name = "ITEM_OF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemOf.findAll", query = "SELECT i FROM ItemOf i"),
    @NamedQuery(name = "ItemOf.findById", query = "SELECT i FROM ItemOf i WHERE i.id = :id"),
    @NamedQuery(name = "ItemOf.findByCantidad", query = "SELECT i FROM ItemOf i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemOf.findByDescripcion", query = "SELECT i FROM ItemOf i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "ItemOf.findByIva", query = "SELECT i FROM ItemOf i WHERE i.iva = :iva"),
    @NamedQuery(name = "ItemOf.findByPreciounit", query = "SELECT i FROM ItemOf i WHERE i.preciounit = :preciounit"),
    @NamedQuery(name = "ItemOf.findBySubtotal", query = "SELECT i FROM ItemOf i WHERE i.subtotal = :subtotal"),
    @NamedQuery(name = "ItemOf.findByTotal", query = "SELECT i FROM ItemOf i WHERE i.total = :total"),
    @NamedQuery(name = "ItemOf.findByUnidad", query = "SELECT i FROM ItemOf i WHERE i.unidad = :unidad")})
public class ItemOf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCRIPCION")
    private Double descripcion;
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
    @JoinColumn(name = "OFERTA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Oferta ofertaId;

    public ItemOf() {
    }

    public ItemOf(Long id) {
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

    public Double getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Double descripcion) {
        this.descripcion = descripcion;
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

    public Oferta getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(Oferta ofertaId) {
        this.ofertaId = ofertaId;
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
        if (!(object instanceof ItemOf)) {
            return false;
        }
        ItemOf other = (ItemOf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemOf[ id=" + id + " ]";
    }
    
}
