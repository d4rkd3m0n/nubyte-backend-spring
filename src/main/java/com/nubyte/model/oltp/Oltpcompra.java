/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joako
 */
@Entity
@Table(name = "OLTPCOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oltpcompra.findAll", query = "SELECT o FROM Oltpcompra o")
    , @NamedQuery(name = "Oltpcompra.findByNumerocompra", query = "SELECT o FROM Oltpcompra o WHERE o.oltpcompraPK.numerocompra = :numerocompra")
    , @NamedQuery(name = "Oltpcompra.findByFecha", query = "SELECT o FROM Oltpcompra o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Oltpcompra.findByOltpestableciNit", query = "SELECT o FROM Oltpcompra o WHERE o.oltpcompraPK.oltpestableciNit = :oltpestableciNit")
    , @NamedQuery(name = "Oltpcompra.findByOltpclienteCedula", query = "SELECT o FROM Oltpcompra o WHERE o.oltpcompraPK.oltpclienteCedula = :oltpclienteCedula")
    , @NamedQuery(name = "Oltpcompra.findByPreciototalcompra", query = "SELECT o FROM Oltpcompra o WHERE o.preciototalcompra = :preciototalcompra")
    , @NamedQuery(name = "Oltpcompra.findByEdadcliente", query = "SELECT o FROM Oltpcompra o WHERE o.edadcliente = :edadcliente")})
public class Oltpcompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OltpcompraPK oltpcompraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTALCOMPRA")
    private BigInteger preciototalcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDADCLIENTE")
    private BigInteger edadcliente;
    @JoinColumn(name = "OLTPCLIENTE_CEDULA", referencedColumnName = "CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oltpcliente oltpcliente;
    @JoinColumn(name = "OLTPESTABLECI_NIT", referencedColumnName = "NIT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oltpestableci oltpestableci;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltpcompra")
    private List<Oltpdetallec> oltpdetallecList;

    public Oltpcompra() {
    }

    public Oltpcompra(OltpcompraPK oltpcompraPK) {
        this.oltpcompraPK = oltpcompraPK;
    }

    public Oltpcompra(OltpcompraPK oltpcompraPK, Date fecha, BigInteger preciototalcompra, BigInteger edadcliente) {
        this.oltpcompraPK = oltpcompraPK;
        this.fecha = fecha;
        this.preciototalcompra = preciototalcompra;
        this.edadcliente = edadcliente;
    }

    public Oltpcompra(BigInteger numerocompra, String oltpestableciNit, BigInteger oltpclienteCedula) {
        this.oltpcompraPK = new OltpcompraPK(numerocompra, oltpestableciNit, oltpclienteCedula);
    }

    public OltpcompraPK getOltpcompraPK() {
        return oltpcompraPK;
    }

    public void setOltpcompraPK(OltpcompraPK oltpcompraPK) {
        this.oltpcompraPK = oltpcompraPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getPreciototalcompra() {
        return preciototalcompra;
    }

    public void setPreciototalcompra(BigInteger preciototalcompra) {
        this.preciototalcompra = preciototalcompra;
    }

    public BigInteger getEdadcliente() {
        return edadcliente;
    }

    public void setEdadcliente(BigInteger edadcliente) {
        this.edadcliente = edadcliente;
    }

    public Oltpcliente getOltpcliente() {
        return oltpcliente;
    }

    public void setOltpcliente(Oltpcliente oltpcliente) {
        this.oltpcliente = oltpcliente;
    }

    public Oltpestableci getOltpestableci() {
        return oltpestableci;
    }

    public void setOltpestableci(Oltpestableci oltpestableci) {
        this.oltpestableci = oltpestableci;
    }

    @XmlTransient
    public List<Oltpdetallec> getOltpdetallecList() {
        return oltpdetallecList;
    }

    public void setOltpdetallecList(List<Oltpdetallec> oltpdetallecList) {
        this.oltpdetallecList = oltpdetallecList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oltpcompraPK != null ? oltpcompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpcompra)) {
            return false;
        }
        Oltpcompra other = (Oltpcompra) object;
        if ((this.oltpcompraPK == null && other.oltpcompraPK != null) || (this.oltpcompraPK != null && !this.oltpcompraPK.equals(other.oltpcompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpcompra[ oltpcompraPK=" + oltpcompraPK + " ]";
    }
    
}
