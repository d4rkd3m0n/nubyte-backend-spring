/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Joako
 */
@Embeddable
public class OltpfuncioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA")
    private BigInteger cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "OLTPESTABLECI_NIT")
    private String oltpestableciNit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OLTPROL_IDROL")
    private BigInteger oltprolIdrol;

    public OltpfuncioPK() {
    }

    public OltpfuncioPK(BigInteger cedula, String oltpestableciNit, BigInteger oltprolIdrol) {
        this.cedula = cedula;
        this.oltpestableciNit = oltpestableciNit;
        this.oltprolIdrol = oltprolIdrol;
    }

    public BigInteger getCedula() {
        return cedula;
    }

    public void setCedula(BigInteger cedula) {
        this.cedula = cedula;
    }

    public String getOltpestableciNit() {
        return oltpestableciNit;
    }

    public void setOltpestableciNit(String oltpestableciNit) {
        this.oltpestableciNit = oltpestableciNit;
    }

    public BigInteger getOltprolIdrol() {
        return oltprolIdrol;
    }

    public void setOltprolIdrol(BigInteger oltprolIdrol) {
        this.oltprolIdrol = oltprolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        hash += (oltpestableciNit != null ? oltpestableciNit.hashCode() : 0);
        hash += (oltprolIdrol != null ? oltprolIdrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OltpfuncioPK)) {
            return false;
        }
        OltpfuncioPK other = (OltpfuncioPK) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        if ((this.oltpestableciNit == null && other.oltpestableciNit != null) || (this.oltpestableciNit != null && !this.oltpestableciNit.equals(other.oltpestableciNit))) {
            return false;
        }
        if ((this.oltprolIdrol == null && other.oltprolIdrol != null) || (this.oltprolIdrol != null && !this.oltprolIdrol.equals(other.oltprolIdrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.OltpfuncioPK[ cedula=" + cedula + ", oltpestableciNit=" + oltpestableciNit + ", oltprolIdrol=" + oltprolIdrol + " ]";
    }
    
}
