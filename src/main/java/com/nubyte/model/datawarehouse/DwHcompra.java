/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.datawarehouse;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Joako
 */
@Entity
@Table(name = "DW_HCOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DwHcompra.findAll", query = "SELECT d FROM DwHcompra d")
    , @NamedQuery(name = "DwHcompra.findByNumcompra", query = "SELECT d FROM DwHcompra d WHERE d.dwHcompraPK.numcompra = :numcompra")
    , @NamedQuery(name = "DwHcompra.findByPreciototalcompra", query = "SELECT d FROM DwHcompra d WHERE d.preciototalcompra = :preciototalcompra")
    , @NamedQuery(name = "DwHcompra.findByDwDestablecIdest", query = "SELECT d FROM DwHcompra d WHERE d.dwHcompraPK.dwDestablecIdest = :dwDestablecIdest")
    , @NamedQuery(name = "DwHcompra.findByDwDtiempoIdfec", query = "SELECT d FROM DwHcompra d WHERE d.dwHcompraPK.dwDtiempoIdfec = :dwDtiempoIdfec")
    , @NamedQuery(name = "DwHcompra.findByDwDclienteIdcli", query = "SELECT d FROM DwHcompra d WHERE d.dwHcompraPK.dwDclienteIdcli = :dwDclienteIdcli")
    , @NamedQuery(name = "DwHcompra.findByDwDproductoIdprod", query = "SELECT d FROM DwHcompra d WHERE d.dwHcompraPK.dwDproductoIdprod = :dwDproductoIdprod")
    , @NamedQuery(name = "DwHcompra.findByNumproductos", query = "SELECT d FROM DwHcompra d WHERE d.numproductos = :numproductos")
    , @NamedQuery(name = "DwHcompra.findByCantidadunidades", query = "SELECT d FROM DwHcompra d WHERE d.cantidadunidades = :cantidadunidades")
    , @NamedQuery(name = "DwHcompra.findByPreciounitario", query = "SELECT d FROM DwHcompra d WHERE d.preciounitario = :preciounitario")
    , @NamedQuery(name = "DwHcompra.findByPreciototalproducto", query = "SELECT d FROM DwHcompra d WHERE d.preciototalproducto = :preciototalproducto")
    , @NamedQuery(name = "DwHcompra.findByImpuestofactura", query = "SELECT d FROM DwHcompra d WHERE d.impuestofactura = :impuestofactura")
    , @NamedQuery(name = "DwHcompra.findByImpuestoproducto", query = "SELECT d FROM DwHcompra d WHERE d.impuestoproducto = :impuestoproducto")
    , @NamedQuery(name = "DwHcompra.findByEdadcliente", query = "SELECT d FROM DwHcompra d WHERE d.edadcliente = :edadcliente")
    , @NamedQuery(name = "DwHcompra.findByNumerofactura", query = "SELECT d FROM DwHcompra d WHERE d.numerofactura = :numerofactura")})
public class DwHcompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DwHcompraPK dwHcompraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTALCOMPRA")
    private BigInteger preciototalcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMPRODUCTOS")
    private BigInteger numproductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDADUNIDADES")
    private BigInteger cantidadunidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOUNITARIO")
    private BigInteger preciounitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTALPRODUCTO")
    private BigInteger preciototalproducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IMPUESTOFACTURA")
    private Double impuestofactura;
    @Column(name = "IMPUESTOPRODUCTO")
    private Double impuestoproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDADCLIENTE")
    private BigInteger edadcliente;
    @Size(max = 25)
    @Column(name = "NUMEROFACTURA")
    private String numerofactura;
    @JoinColumn(name = "DW_DCLIENTE_IDCLI", referencedColumnName = "IDCLI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DwDcliente dwDcliente;
    @JoinColumn(name = "DW_DESTABLEC_IDEST", referencedColumnName = "IDEST", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DwDestablec dwDestablec;
    @JoinColumn(name = "DW_DPRODUCTO_IDPROD", referencedColumnName = "IDPROD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DwDproducto dwDproducto;
    @JoinColumn(name = "DW_DTIEMPO_IDFEC", referencedColumnName = "IDFEC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DwDtiempo dwDtiempo;

    public DwHcompra() {
    }

    public DwHcompra(DwHcompraPK dwHcompraPK) {
        this.dwHcompraPK = dwHcompraPK;
    }

    public DwHcompra(DwHcompraPK dwHcompraPK, BigInteger preciototalcompra, BigInteger numproductos, BigInteger cantidadunidades, BigInteger preciounitario, BigInteger preciototalproducto, BigInteger edadcliente) {
        this.dwHcompraPK = dwHcompraPK;
        this.preciototalcompra = preciototalcompra;
        this.numproductos = numproductos;
        this.cantidadunidades = cantidadunidades;
        this.preciounitario = preciounitario;
        this.preciototalproducto = preciototalproducto;
        this.edadcliente = edadcliente;
    }

    public DwHcompra(BigInteger numcompra, BigInteger dwDestablecIdest, BigInteger dwDtiempoIdfec, BigInteger dwDclienteIdcli, BigInteger dwDproductoIdprod) {
        this.dwHcompraPK = new DwHcompraPK(numcompra, dwDestablecIdest, dwDtiempoIdfec, dwDclienteIdcli, dwDproductoIdprod);
    }

    public DwHcompraPK getDwHcompraPK() {
        return dwHcompraPK;
    }

    public void setDwHcompraPK(DwHcompraPK dwHcompraPK) {
        this.dwHcompraPK = dwHcompraPK;
    }

    public BigInteger getPreciototalcompra() {
        return preciototalcompra;
    }

    public void setPreciototalcompra(BigInteger preciototalcompra) {
        this.preciototalcompra = preciototalcompra;
    }

    public BigInteger getNumproductos() {
        return numproductos;
    }

    public void setNumproductos(BigInteger numproductos) {
        this.numproductos = numproductos;
    }

    public BigInteger getCantidadunidades() {
        return cantidadunidades;
    }

    public void setCantidadunidades(BigInteger cantidadunidades) {
        this.cantidadunidades = cantidadunidades;
    }

    public BigInteger getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigInteger preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigInteger getPreciototalproducto() {
        return preciototalproducto;
    }

    public void setPreciototalproducto(BigInteger preciototalproducto) {
        this.preciototalproducto = preciototalproducto;
    }

    public Double getImpuestofactura() {
        return impuestofactura;
    }

    public void setImpuestofactura(Double impuestofactura) {
        this.impuestofactura = impuestofactura;
    }

    public Double getImpuestoproducto() {
        return impuestoproducto;
    }

    public void setImpuestoproducto(Double impuestoproducto) {
        this.impuestoproducto = impuestoproducto;
    }

    public BigInteger getEdadcliente() {
        return edadcliente;
    }

    public void setEdadcliente(BigInteger edadcliente) {
        this.edadcliente = edadcliente;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public DwDcliente getDwDcliente() {
        return dwDcliente;
    }

    public void setDwDcliente(DwDcliente dwDcliente) {
        this.dwDcliente = dwDcliente;
    }

    public DwDestablec getDwDestablec() {
        return dwDestablec;
    }

    public void setDwDestablec(DwDestablec dwDestablec) {
        this.dwDestablec = dwDestablec;
    }

    public DwDproducto getDwDproducto() {
        return dwDproducto;
    }

    public void setDwDproducto(DwDproducto dwDproducto) {
        this.dwDproducto = dwDproducto;
    }

    public DwDtiempo getDwDtiempo() {
        return dwDtiempo;
    }

    public void setDwDtiempo(DwDtiempo dwDtiempo) {
        this.dwDtiempo = dwDtiempo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dwHcompraPK != null ? dwHcompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwHcompra)) {
            return false;
        }
        DwHcompra other = (DwHcompra) object;
        if ((this.dwHcompraPK == null && other.dwHcompraPK != null) || (this.dwHcompraPK != null && !this.dwHcompraPK.equals(other.dwHcompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.DwHcompra[ dwHcompraPK=" + dwHcompraPK + " ]";
    }
    
}
