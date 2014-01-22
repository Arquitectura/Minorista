/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author samsung
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByCodFab", query = "SELECT p FROM Producto p WHERE p.codFab = :codFab"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Producto.findByIva", query = "SELECT p FROM Producto p WHERE p.iva = :iva"),
    @NamedQuery(name = "Producto.findByModelo", query = "SELECT p FROM Producto p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByReferencia", query = "SELECT p FROM Producto p WHERE p.referencia = :referencia")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "COD_FAB")
    private String codFab;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "IMAGEN")
    private String imagen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IVA")
    private Double iva;
    @Size(max = 255)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "REFERENCIA")
    private String referencia;
    @JoinColumn(name = "UNIDAD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Unidad unidadId;
    @JoinColumn(name = "TIPO_PROD_ID", referencedColumnName = "ID")
    @ManyToOne
    private TipoProd tipoProdId;
    @JoinColumn(name = "MARCA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Marca marcaId;
    @OneToMany(mappedBy = "productoId")
    private Collection<ItemFact> itemFactCollection;
    @OneToMany(mappedBy = "productoId")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(mappedBy = "productoId")
    private Collection<ItemOf> itemOfCollection;

    public Producto() {
    }

    public Producto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodFab() {
        return codFab;
    }

    public void setCodFab(String codFab) {
        this.codFab = codFab;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Unidad getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Unidad unidadId) {
        this.unidadId = unidadId;
    }

    public TipoProd getTipoProdId() {
        return tipoProdId;
    }

    public void setTipoProdId(TipoProd tipoProdId) {
        this.tipoProdId = tipoProdId;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    @XmlTransient
    public Collection<ItemFact> getItemFactCollection() {
        return itemFactCollection;
    }

    public void setItemFactCollection(Collection<ItemFact> itemFactCollection) {
        this.itemFactCollection = itemFactCollection;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @XmlTransient
    public Collection<ItemOf> getItemOfCollection() {
        return itemOfCollection;
    }

    public void setItemOfCollection(Collection<ItemOf> itemOfCollection) {
        this.itemOfCollection = itemOfCollection;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Producto[ id=" + id + " ]";
    }
    
}
