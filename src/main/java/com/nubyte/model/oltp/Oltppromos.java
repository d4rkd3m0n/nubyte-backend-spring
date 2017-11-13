/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "OLTPPROMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oltppromos.findAll", query = "SELECT o FROM Oltppromos o")
    , @NamedQuery(name = "Oltppromos.findByIdpromo", query = "SELECT o FROM Oltppromos o WHERE o.idpromo = :idpromo")
    , @NamedQuery(name = "Oltppromos.findByNombrepromo", query = "SELECT o FROM Oltppromos o WHERE o.nombrepromo = :nombrepromo")
    , @NamedQuery(name = "Oltppromos.findByPreciopromo", query = "SELECT o FROM Oltppromos o WHERE o.preciopromo = :preciopromo")
    , @NamedQuery(name = "Oltppromos.findByFechainicio", query = "SELECT o FROM Oltppromos o WHERE o.fechainicio = :fechainicio")
    , @NamedQuery(name = "Oltppromos.findByFechafin", query = "SELECT o FROM Oltppromos o WHERE o.fechafin = :fechafin")
    , @NamedQuery(name = "Oltppromos.findByNitest", query = "SELECT o FROM Oltppromos o WHERE o.nitest = :nitest")})
public class Oltppromos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROMO")
    private BigDecimal idpromo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREPROMO")
    private String nombrepromo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOPROMO")
    private double preciopromo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FECHAINICIO")
    private String fechainicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FECHAFIN")
    private String fechafin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NITEST")
    private String nitest;

    public Oltppromos() {
    }

    public Oltppromos(BigDecimal idpromo) {
        this.idpromo = idpromo;
    }

    public Oltppromos(BigDecimal idpromo, String nombrepromo, double preciopromo, String fechainicio, String fechafin, String nitest) {
        this.idpromo = idpromo;
        this.nombrepromo = nombrepromo;
        this.preciopromo = preciopromo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.nitest = nitest;
    }

    public BigDecimal getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(BigDecimal idpromo) {
        this.idpromo = idpromo;
    }

    public String getNombrepromo() {
        return nombrepromo;
    }

    public void setNombrepromo(String nombrepromo) {
        this.nombrepromo = nombrepromo;
    }

    public double getPreciopromo() {
        return preciopromo;
    }

    public void setPreciopromo(double preciopromo) {
        this.preciopromo = preciopromo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getNitest() {
        return nitest;
    }

    public void setNitest(String nitest) {
        this.nitest = nitest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromo != null ? idpromo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltppromos)) {
            return false;
        }
        Oltppromos other = (Oltppromos) object;
        if ((this.idpromo == null && other.idpromo != null) || (this.idpromo != null && !this.idpromo.equals(other.idpromo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltppromos[ idpromo=" + idpromo + " ]";
    }
    
}
