/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
 * @author Joako
 */
@Entity
@Table(name = "OLTPPRODUCTO")
@NamedQueries({
    @NamedQuery(name = "Oltpproducto.findAll", query = "SELECT o FROM Oltpproducto o")
    , @NamedQuery(name = "Oltpproducto.findByCodigoproducto", query = "SELECT o FROM Oltpproducto o WHERE o.oltpproductoPK.codigoproducto = :codigoproducto")
    , @NamedQuery(name = "Oltpproducto.findByNombreprod", query = "SELECT o FROM Oltpproducto o WHERE o.nombreprod = :nombreprod")
    , @NamedQuery(name = "Oltpproducto.findByPrecio", query = "SELECT o FROM Oltpproducto o WHERE o.precio = :precio")
    , @NamedQuery(name = "Oltpproducto.findByVolumen", query = "SELECT o FROM Oltpproducto o WHERE o.volumen = :volumen")
    , @NamedQuery(name = "Oltpproducto.findByOltptipoIdtipo", query = "SELECT o FROM Oltpproducto o WHERE o.oltpproductoPK.oltptipoIdtipo = :oltptipoIdtipo")
    , @NamedQuery(name = "Oltpproducto.findByMarca", query = "SELECT o FROM Oltpproducto o WHERE o.marca = :marca")})
public class Oltpproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OltpproductoPK oltpproductoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREPROD")
    private String nombreprod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "VOLUMEN")
    private String volumen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MARCA")
    private String marca;
    @ManyToMany(mappedBy = "oltpproductoList")
    private List<Oltpestableci> oltpestableciList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltpproducto")
    private List<Oltpdetallec> oltpdetallecList;
    @JoinColumn(name = "OLTPTIPO_IDTIPO", referencedColumnName = "IDTIPO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oltptipo oltptipo;

    public Oltpproducto() {
    }

    public Oltpproducto(OltpproductoPK oltpproductoPK) {
        this.oltpproductoPK = oltpproductoPK;
    }

    public Oltpproducto(OltpproductoPK oltpproductoPK, String nombreprod, double precio, String volumen, String marca) {
        this.oltpproductoPK = oltpproductoPK;
        this.nombreprod = nombreprod;
        this.precio = precio;
        this.volumen = volumen;
        this.marca = marca;
    }

    public Oltpproducto(String codigoproducto, BigInteger oltptipoIdtipo) {
        this.oltpproductoPK = new OltpproductoPK(codigoproducto, oltptipoIdtipo);
    }

    public OltpproductoPK getOltpproductoPK() {
        return oltpproductoPK;
    }

    public void setOltpproductoPK(OltpproductoPK oltpproductoPK) {
        this.oltpproductoPK = oltpproductoPK;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlTransient
    public List<Oltpestableci> getOltpestableciList() {
        return oltpestableciList;
    }

    public void setOltpestableciList(List<Oltpestableci> oltpestableciList) {
        this.oltpestableciList = oltpestableciList;
    }

    @XmlTransient
    public List<Oltpdetallec> getOltpdetallecList() {
        return oltpdetallecList;
    }

    public void setOltpdetallecList(List<Oltpdetallec> oltpdetallecList) {
        this.oltpdetallecList = oltpdetallecList;
    }

    public Oltptipo getOltptipo() {
        return oltptipo;
    }

    public void setOltptipo(Oltptipo oltptipo) {
        this.oltptipo = oltptipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oltpproductoPK != null ? oltpproductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpproducto)) {
            return false;
        }
        Oltpproducto other = (Oltpproducto) object;
        if ((this.oltpproductoPK == null && other.oltpproductoPK != null) || (this.oltpproductoPK != null && !this.oltpproductoPK.equals(other.oltpproductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpproducto[ oltpproductoPK=" + oltpproductoPK + " ]";
    }
    
}
