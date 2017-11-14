/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "OLTPRESERVA")
@NamedQueries({
    @NamedQuery(name = "Oltpreserva.findAll", query = "SELECT o FROM Oltpreserva o")
    , @NamedQuery(name = "Oltpreserva.findByIdreserva", query = "SELECT o FROM Oltpreserva o WHERE o.idreserva = :idreserva")
    , @NamedQuery(name = "Oltpreserva.findByCedula", query = "SELECT o FROM Oltpreserva o WHERE o.cedula = :cedula")
    , @NamedQuery(name = "Oltpreserva.findByNombrecliente", query = "SELECT o FROM Oltpreserva o WHERE o.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "Oltpreserva.findByFecha", query = "SELECT o FROM Oltpreserva o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Oltpreserva.findByCantidadpersonas", query = "SELECT o FROM Oltpreserva o WHERE o.cantidadpersonas = :cantidadpersonas")})
public class Oltpreserva implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESERVA")
    private BigDecimal idreserva;
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
    @Size(min = 1, max = 50)
    @Column(name = "FECHA")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDADPERSONAS")
    private BigInteger cantidadpersonas;
    @JoinColumn(name = "NIT", referencedColumnName = "NIT")
    @ManyToOne(optional = false)
    private Oltpestableci nit;

    public Oltpreserva() {
    }

    public Oltpreserva(BigDecimal idreserva) {
        this.idreserva = idreserva;
    }

    public Oltpreserva(BigDecimal idreserva, BigInteger cedula, String nombrecliente, String fecha, BigInteger cantidadpersonas) {
        this.idreserva = idreserva;
        this.cedula = cedula;
        this.nombrecliente = nombrecliente;
        this.fecha = fecha;
        this.cantidadpersonas = cantidadpersonas;
    }

    public BigDecimal getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(BigDecimal idreserva) {
        this.idreserva = idreserva;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigInteger getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(BigInteger cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public Oltpestableci getNit() {
        return nit;
    }

    public void setNit(Oltpestableci nit) {
        this.nit = nit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpreserva)) {
            return false;
        }
        Oltpreserva other = (Oltpreserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpreserva[ idreserva=" + idreserva + " ]";
    }
    
}
