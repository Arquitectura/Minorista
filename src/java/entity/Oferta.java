/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findById", query = "SELECT o FROM Oferta o WHERE o.id = :id"),
    @NamedQuery(name = "Oferta.findByAcept", query = "SELECT o FROM Oferta o WHERE o.acept = :acept"),
    @NamedQuery(name = "Oferta.findByEntreg", query = "SELECT o FROM Oferta o WHERE o.entreg = :entreg"),
    @NamedQuery(name = "Oferta.findByFdentr", query = "SELECT o FROM Oferta o WHERE o.fdentr = :fdentr"),
    @NamedQuery(name = "Oferta.findByFecha", query = "SELECT o FROM Oferta o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Oferta.findByFormaPago", query = "SELECT o FROM Oferta o WHERE o.formaPago = :formaPago"),
    @NamedQuery(name = "Oferta.findByObserv", query = "SELECT o FROM Oferta o WHERE o.observ = :observ"),
    @NamedQuery(name = "Oferta.findByTitulo", query = "SELECT o FROM Oferta o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Oferta.findByValidez", query = "SELECT o FROM Oferta o WHERE o.validez = :validez")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACEPT")
    private Short acept;
    @Column(name = "ENTREG")
    private Short entreg;
    @Column(name = "FDENTR")
    @Temporal(TemporalType.DATE)
    private Date fdentr;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @Size(max = 255)
    @Column(name = "OBSERV")
    private String observ;
    @Size(max = 255)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 255)
    @Column(name = "VALIDEZ")
    private String validez;
    @OneToMany(mappedBy = "ofertaId")
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Solicitud solicitudId;
    @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Actor actorId;
    @OneToMany(mappedBy = "ofertaId")
    private Collection<ItemOf> itemOfCollection;

    public Oferta() {
    }

    public Oferta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAcept() {
        return acept;
    }

    public void setAcept(Short acept) {
        this.acept = acept;
    }

    public Short getEntreg() {
        return entreg;
    }

    public void setEntreg(Short entreg) {
        this.entreg = entreg;
    }

    public Date getFdentr() {
        return fdentr;
    }

    public void setFdentr(Date fdentr) {
        this.fdentr = fdentr;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValidez() {
        return validez;
    }

    public void setValidez(String validez) {
        this.validez = validez;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Solicitud getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitud solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Actor getActorId() {
        return actorId;
    }

    public void setActorId(Actor actorId) {
        this.actorId = actorId;
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
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Oferta[ id=" + id + " ]";
    }
    
}
