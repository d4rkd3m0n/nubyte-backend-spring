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
@Table(name = "DW_DCLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DwDcliente.findAll", query = "SELECT d FROM DwDcliente d")
    , @NamedQuery(name = "DwDcliente.findByIdcli", query = "SELECT d FROM DwDcliente d WHERE d.idcli = :idcli")
    , @NamedQuery(name = "DwDcliente.findByCedula", query = "SELECT d FROM DwDcliente d WHERE d.cedula = :cedula")
    , @NamedQuery(name = "DwDcliente.findByNombrecliente", query = "SELECT d FROM DwDcliente d WHERE d.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "DwDcliente.findByFechanacimiento", query = "SELECT d FROM DwDcliente d WHERE d.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "DwDcliente.findByCorreo", query = "SELECT d FROM DwDcliente d WHERE d.correo = :correo")
    , @NamedQuery(name = "DwDcliente.findByGenero", query = "SELECT d FROM DwDcliente d WHERE d.genero = :genero")
    , @NamedQuery(name = "DwDcliente.findByGeneracion", query = "SELECT d FROM DwDcliente d WHERE d.generacion = :generacion")})
public class DwDcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLI")
    private BigDecimal idcli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRECLIENTE")
    private String nombrecliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GENERO")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GENERACION")
    private String generacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dwDcliente")
    private List<DwHcompra> dwHcompraList;

    public DwDcliente() {
    }

    public DwDcliente(BigDecimal idcli) {
        this.idcli = idcli;
    }

    public DwDcliente(BigDecimal idcli, BigInteger cedula, String nombrecliente, Date fechanacimiento, String correo, String genero, String generacion) {
        this.idcli = idcli;
        this.cedula = cedula;
        this.nombrecliente = nombrecliente;
        this.fechanacimiento = fechanacimiento;
        this.correo = correo;
        this.genero = genero;
        this.generacion = generacion;
    }

    public BigDecimal getIdcli() {
        return idcli;
    }

    public void setIdcli(BigDecimal idcli) {
        this.idcli = idcli;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
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
        hash += (idcli != null ? idcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwDcliente)) {
            return false;
        }
        DwDcliente other = (DwDcliente) object;
        if ((this.idcli == null && other.idcli != null) || (this.idcli != null && !this.idcli.equals(other.idcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.DwDcliente[ idcli=" + idcli + " ]";
    }
    
}
