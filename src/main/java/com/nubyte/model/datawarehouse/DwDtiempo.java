/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.datawarehouse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joako
 */
@Entity
@Table(name = "DW_DTIEMPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DwDtiempo.findAll", query = "SELECT d FROM DwDtiempo d")
    , @NamedQuery(name = "DwDtiempo.findByIdfec", query = "SELECT d FROM DwDtiempo d WHERE d.idfec = :idfec")
    , @NamedQuery(name = "DwDtiempo.findByFecha", query = "SELECT d FROM DwDtiempo d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "DwDtiempo.findByAnio", query = "SELECT d FROM DwDtiempo d WHERE d.anio = :anio")
    , @NamedQuery(name = "DwDtiempo.findByMes", query = "SELECT d FROM DwDtiempo d WHERE d.mes = :mes")
    , @NamedQuery(name = "DwDtiempo.findByNumeromes", query = "SELECT d FROM DwDtiempo d WHERE d.numeromes = :numeromes")
    , @NamedQuery(name = "DwDtiempo.findByDia", query = "SELECT d FROM DwDtiempo d WHERE d.dia = :dia")
    , @NamedQuery(name = "DwDtiempo.findByNumerodia", query = "SELECT d FROM DwDtiempo d WHERE d.numerodia = :numerodia")})
public class DwDtiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFEC")
    private BigDecimal idfec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private BigInteger anio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MES")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROMES")
    private BigInteger numeromes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DIA")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERODIA")
    private BigInteger numerodia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dwDtiempo")
    private List<DwHcompra> dwHcompraList;

    public DwDtiempo() {
    }

    public DwDtiempo(BigDecimal idfec) {
        this.idfec = idfec;
    }

    public DwDtiempo(BigDecimal idfec, Date fecha, BigInteger anio, String mes, BigInteger numeromes, String dia, BigInteger numerodia) {
        this.idfec = idfec;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.numeromes = numeromes;
        this.dia = dia;
        this.numerodia = numerodia;
    }

    public BigDecimal getIdfec() {
        return idfec;
    }

    public void setIdfec(BigDecimal idfec) {
        this.idfec = idfec;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public BigInteger getNumeromes() {
        return numeromes;
    }

    public void setNumeromes(BigInteger numeromes) {
        this.numeromes = numeromes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public BigInteger getNumerodia() {
        return numerodia;
    }

    public void setNumerodia(BigInteger numerodia) {
        this.numerodia = numerodia;
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
        hash += (idfec != null ? idfec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwDtiempo)) {
            return false;
        }
        DwDtiempo other = (DwDtiempo) object;
        if ((this.idfec == null && other.idfec != null) || (this.idfec != null && !this.idfec.equals(other.idfec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.DwDtiempo[ idfec=" + idfec + " ]";
    }
    
}
