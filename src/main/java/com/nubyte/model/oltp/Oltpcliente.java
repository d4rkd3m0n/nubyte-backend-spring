/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

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
@Table(name = "OLTPCLIENTE")
@NamedQueries({
    @NamedQuery(name = "Oltpcliente.findAll", query = "SELECT o FROM Oltpcliente o")
    , @NamedQuery(name = "Oltpcliente.findByCedula", query = "SELECT o FROM Oltpcliente o WHERE o.cedula = :cedula")
    , @NamedQuery(name = "Oltpcliente.findByNombrecliente", query = "SELECT o FROM Oltpcliente o WHERE o.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "Oltpcliente.findByFechanacimiento", query = "SELECT o FROM Oltpcliente o WHERE o.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Oltpcliente.findByContrasena", query = "SELECT o FROM Oltpcliente o WHERE o.contrasena = :contrasena")
    , @NamedQuery(name = "Oltpcliente.findByCorreo", query = "SELECT o FROM Oltpcliente o WHERE o.correo = :correo")
    , @NamedQuery(name = "Oltpcliente.findByGenero", query = "SELECT o FROM Oltpcliente o WHERE o.genero = :genero")
    , @NamedQuery(name = "Oltpcliente.findByGeneracion", query = "SELECT o FROM Oltpcliente o WHERE o.generacion = :generacion")
    , @NamedQuery(name = "Oltpcliente.findByPuntos", query = "SELECT o FROM Oltpcliente o WHERE o.puntos = :puntos")})
public class Oltpcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA")
    private BigDecimal cedula;
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
    @Size(min = 1, max = 20)
    @Column(name = "CONTRASENA")
    private String contrasena;
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
    @Column(name = "PUNTOS")
    private BigInteger puntos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltpcliente")
    private List<Oltpcompra> oltpcompraList;

    public Oltpcliente() {
    }

    public Oltpcliente(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public Oltpcliente(BigDecimal cedula, String nombrecliente, Date fechanacimiento, String contrasena, String correo, String genero, String generacion) {
        this.cedula = cedula;
        this.nombrecliente = nombrecliente;
        this.fechanacimiento = fechanacimiento;
        this.contrasena = contrasena;
        this.correo = correo;
        this.genero = genero;
        this.generacion = generacion;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public BigInteger getPuntos() {
        return puntos;
    }

    public void setPuntos(BigInteger puntos) {
        this.puntos = puntos;
    }

    @XmlTransient
    public List<Oltpcompra> getOltpcompraList() {
        return oltpcompraList;
    }

    public void setOltpcompraList(List<Oltpcompra> oltpcompraList) {
        this.oltpcompraList = oltpcompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpcliente)) {
            return false;
        }
        Oltpcliente other = (Oltpcliente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpcliente[ cedula=" + cedula + " ]";
    }
    
}
