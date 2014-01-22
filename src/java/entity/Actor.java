/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ACTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findById", query = "SELECT a FROM Actor a WHERE a.id = :id"),
    @NamedQuery(name = "Actor.findByDescu", query = "SELECT a FROM Actor a WHERE a.descu = :descu"),
    @NamedQuery(name = "Actor.findByDir", query = "SELECT a FROM Actor a WHERE a.dir = :dir"),
    @NamedQuery(name = "Actor.findByDv", query = "SELECT a FROM Actor a WHERE a.dv = :dv"),
    @NamedQuery(name = "Actor.findByIdext", query = "SELECT a FROM Actor a WHERE a.idext = :idext"),
    @NamedQuery(name = "Actor.findByNit", query = "SELECT a FROM Actor a WHERE a.nit = :nit"),
    @NamedQuery(name = "Actor.findByNombre", query = "SELECT a FROM Actor a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actor.findByPersNat", query = "SELECT a FROM Actor a WHERE a.persNat = :persNat"),
    @NamedQuery(name = "Actor.findByTel1", query = "SELECT a FROM Actor a WHERE a.tel1 = :tel1"),
    @NamedQuery(name = "Actor.findByTel2", query = "SELECT a FROM Actor a WHERE a.tel2 = :tel2"),
    @NamedQuery(name = "Actor.findByType", query = "SELECT a FROM Actor a WHERE a.type = :type")})
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCU")
    private Integer descu;
    @Size(max = 255)
    @Column(name = "DIR")
    private String dir;
    @Column(name = "DV")
    private Integer dv;
    @Size(max = 255)
    @Column(name = "IDEXT")
    private String idext;
    @Column(name = "NIT")
    private BigInteger nit;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PERS_NAT")
    private Short persNat;
    @Size(max = 255)
    @Column(name = "TEL1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "TEL2")
    private String tel2;
    @Size(max = 255)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "actorId")
    private Collection<Oferta> ofertaCollection;
    @OneToMany(mappedBy = "actorId")
    private Collection<Login> loginCollection;

    public Actor() {
    }

    public Actor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDescu() {
        return descu;
    }

    public void setDescu(Integer descu) {
        this.descu = descu;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Integer getDv() {
        return dv;
    }

    public void setDv(Integer dv) {
        this.dv = dv;
    }

    public String getIdext() {
        return idext;
    }

    public void setIdext(String idext) {
        this.idext = idext;
    }

    public BigInteger getNit() {
        return nit;
    }

    public void setNit(BigInteger nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getPersNat() {
        return persNat;
    }

    public void setPersNat(Short persNat) {
        this.persNat = persNat;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }

    @XmlTransient
    public Collection<Login> getLoginCollection() {
        return loginCollection;
    }

    public void setLoginCollection(Collection<Login> loginCollection) {
        this.loginCollection = loginCollection;
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
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Actor[ id=" + id + " ]";
    }
    
}
