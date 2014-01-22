/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author samsung
 */
@Entity
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
    @NamedQuery(name = "Factura.findByFe", query = "SELECT f FROM Factura f WHERE f.fe = :fe"),
    @NamedQuery(name = "Factura.findByFormaPago", query = "SELECT f FROM Factura f WHERE f.formaPago = :formaPago"),
    @NamedQuery(name = "Factura.findByFp", query = "SELECT f FROM Factura f WHERE f.fp = :fp"),
    @NamedQuery(name = "Factura.findByFr", query = "SELECT f FROM Factura f WHERE f.fr = :fr"),
    @NamedQuery(name = "Factura.findByFv", query = "SELECT f FROM Factura f WHERE f.fv = :fv"),
    @NamedQuery(name = "Factura.findByNit", query = "SELECT f FROM Factura f WHERE f.nit = :nit"),
    @NamedQuery(name = "Factura.findByObservacion", query = "SELECT f FROM Factura f WHERE f.observacion = :observacion"),
    @NamedQuery(name = "Factura.findByTerm", query = "SELECT f FROM Factura f WHERE f.term = :term"),
    @NamedQuery(name = "Factura.findByTitulo", query = "SELECT f FROM Factura f WHERE f.titulo = :titulo")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "FE")
    @Temporal(TemporalType.DATE)
    private Date fe;
    @Size(max = 255)
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @Column(name = "FP")
    @Temporal(TemporalType.DATE)
    private Date fp;
    @Column(name = "FR")
    @Temporal(TemporalType.DATE)
    private Date fr;
    @Column(name = "FV")
    @Temporal(TemporalType.DATE)
    private Date fv;
    @Column(name = "NIT")
    private BigInteger nit;
    @Size(max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "TERM")
    private Integer term;
    @Size(max = 255)
    @Column(name = "TITULO")
    private String titulo;
    @OneToMany(mappedBy = "facturaId")
    private Collection<ItemFact> itemFactCollection;
    @JoinColumn(name = "OFERTA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Oferta ofertaId;

    public Factura() {
    }

    public Factura(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFe() {
        return fe;
    }

    public void setFe(Date fe) {
        this.fe = fe;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFp() {
        return fp;
    }

    public void setFp(Date fp) {
        this.fp = fp;
    }

    public Date getFr() {
        return fr;
    }

    public void setFr(Date fr) {
        this.fr = fr;
    }

    public Date getFv() {
        return fv;
    }

    public void setFv(Date fv) {
        this.fv = fv;
    }

    public BigInteger getNit() {
        return nit;
    }

    public void setNit(BigInteger nit) {
        this.nit = nit;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Collection<ItemFact> getItemFactCollection() {
        return itemFactCollection;
    }

    public void setItemFactCollection(Collection<ItemFact> itemFactCollection) {
        this.itemFactCollection = itemFactCollection;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Factura[ id=" + id + " ]";
    }
    
}
