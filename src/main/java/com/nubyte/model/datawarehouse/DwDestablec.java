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
@Table(name = "DW_DESTABLEC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DwDestablec.findAll", query = "SELECT d FROM DwDestablec d")
    , @NamedQuery(name = "DwDestablec.findByIdest", query = "SELECT d FROM DwDestablec d WHERE d.idest = :idest")
    , @NamedQuery(name = "DwDestablec.findByNit", query = "SELECT d FROM DwDestablec d WHERE d.nit = :nit")
    , @NamedQuery(name = "DwDestablec.findByNombreest", query = "SELECT d FROM DwDestablec d WHERE d.nombreest = :nombreest")
    , @NamedQuery(name = "DwDestablec.findByDireccion", query = "SELECT d FROM DwDestablec d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "DwDestablec.findByLatitud", query = "SELECT d FROM DwDestablec d WHERE d.latitud = :latitud")
    , @NamedQuery(name = "DwDestablec.findByLongitud", query = "SELECT d FROM DwDestablec d WHERE d.longitud = :longitud")
    , @NamedQuery(name = "DwDestablec.findByLocalidad", query = "SELECT d FROM DwDestablec d WHERE d.localidad = :localidad")})
public class DwDestablec implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEST")
    private BigDecimal idest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NIT")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBREEST")
    private String nombreest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUD")
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD")
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dwDestablec")
    private List<DwHcompra> dwHcompraList;

    public DwDestablec() {
    }

    public DwDestablec(BigDecimal idest) {
        this.idest = idest;
    }

    public DwDestablec(BigDecimal idest, String nit, String nombreest, String direccion, double latitud, double longitud, String localidad) {
        this.idest = idest;
        this.nit = nit;
        this.nombreest = nombreest;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.localidad = localidad;
    }

    public BigDecimal getIdest() {
        return idest;
    }

    public void setIdest(BigDecimal idest) {
        this.idest = idest;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreest() {
        return nombreest;
    }

    public void setNombreest(String nombreest) {
        this.nombreest = nombreest;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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
        hash += (idest != null ? idest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwDestablec)) {
            return false;
        }
        DwDestablec other = (DwDestablec) object;
        if ((this.idest == null && other.idest != null) || (this.idest != null && !this.idest.equals(other.idest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.DwDestablec[ idest=" + idest + " ]";
    }
    
}
