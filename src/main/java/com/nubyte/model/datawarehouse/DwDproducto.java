/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.datawarehouse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Joako
 */
@Entity
@Table(name = "DW_DPRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DwDproducto.findAll", query = "SELECT d FROM DwDproducto d")
    , @NamedQuery(name = "DwDproducto.findByIdprod", query = "SELECT d FROM DwDproducto d WHERE d.idprod = :idprod")
    , @NamedQuery(name = "DwDproducto.findByCodigoproducti", query = "SELECT d FROM DwDproducto d WHERE d.codigoproducti = :codigoproducti")
    , @NamedQuery(name = "DwDproducto.findByNombreprod", query = "SELECT d FROM DwDproducto d WHERE d.nombreprod = :nombreprod")
    , @NamedQuery(name = "DwDproducto.findByPrecio", query = "SELECT d FROM DwDproducto d WHERE d.precio = :precio")
    , @NamedQuery(name = "DwDproducto.findByTipo", query = "SELECT d FROM DwDproducto d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "DwDproducto.findByVolumen", query = "SELECT d FROM DwDproducto d WHERE d.volumen = :volumen")
    , @NamedQuery(name = "DwDproducto.findByMarca", query = "SELECT d FROM DwDproducto d WHERE d.marca = :marca")})
public class DwDproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROD")
    private BigDecimal idprod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGOPRODUCTI")
    private String codigoproducti;
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
    @Size(min = 1, max = 20)
    @Column(name = "TIPO")
    private String tipo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dwDproducto")
    private List<DwHcompra> dwHcompraList;

    public DwDproducto() {
    }

    public DwDproducto(BigDecimal idprod) {
        this.idprod = idprod;
    }

    public DwDproducto(BigDecimal idprod, String codigoproducti, String nombreprod, double precio, String tipo, String volumen, String marca) {
        this.idprod = idprod;
        this.codigoproducti = codigoproducti;
        this.nombreprod = nombreprod;
        this.precio = precio;
        this.tipo = tipo;
        this.volumen = volumen;
        this.marca = marca;
    }

    public BigDecimal getIdprod() {
        return idprod;
    }

    public void setIdprod(BigDecimal idprod) {
        this.idprod = idprod;
    }

    public String getCodigoproducti() {
        return codigoproducti;
    }

    public void setCodigoproducti(String codigoproducti) {
        this.codigoproducti = codigoproducti;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    public List<DwHcompra> getDwHcompraList() {
        return dwHcompraList;
    }

    public void setDwHcompraList(List<DwHcompra> dwHcompraList) {
        this.dwHcompraList = dwHcompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprod != null ? idprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwDproducto)) {
            return false;
        }
        DwDproducto other = (DwDproducto) object;
        if ((this.idprod == null && other.idprod != null) || (this.idprod != null && !this.idprod.equals(other.idprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.DwDproducto[ idprod=" + idprod + " ]";
    }
    
}
