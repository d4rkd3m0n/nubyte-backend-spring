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
public class OltpcompraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROCOMPRA")
    private BigInteger numerocompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "OLTPESTABLECI_NIT")
    private String oltpestableciNit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OLTPCLIENTE_CEDULA")
    private BigInteger oltpclienteCedula;

    public OltpcompraPK() {
    }

    public OltpcompraPK(BigInteger numerocompra, String oltpestableciNit, BigInteger oltpclienteCedula) {
        this.numerocompra = numerocompra;
        this.oltpestableciNit = oltpestableciNit;
        this.oltpclienteCedula = oltpclienteCedula;
    }

    public BigInteger getNumerocompra() {
        return numerocompra;
    }

    public void setNumerocompra(BigInteger numerocompra) {
        this.numerocompra = numerocompra;
    }

    public String getOltpestableciNit() {
        return oltpestableciNit;
    }

    public void setOltpestableciNit(String oltpestableciNit) {
        this.oltpestableciNit = oltpestableciNit;
    }

    public BigInteger getOltpclienteCedula() {
        return oltpclienteCedula;
    }

    public void setOltpclienteCedula(BigInteger oltpclienteCedula) {
        this.oltpclienteCedula = oltpclienteCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocompra != null ? numerocompra.hashCode() : 0);
        hash += (oltpestableciNit != null ? oltpestableciNit.hashCode() : 0);
        hash += (oltpclienteCedula != null ? oltpclienteCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OltpcompraPK)) {
            return false;
        }
        OltpcompraPK other = (OltpcompraPK) object;
        if ((this.numerocompra == null && other.numerocompra != null) || (this.numerocompra != null && !this.numerocompra.equals(other.numerocompra))) {
            return false;
        }
        if ((this.oltpestableciNit == null && other.oltpestableciNit != null) || (this.oltpestableciNit != null && !this.oltpestableciNit.equals(other.oltpestableciNit))) {
            return false;
        }
        if ((this.oltpclienteCedula == null && other.oltpclienteCedula != null) || (this.oltpclienteCedula != null && !this.oltpclienteCedula.equals(other.oltpclienteCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.OltpcompraPK[ numerocompra=" + numerocompra + ", oltpestableciNit=" + oltpestableciNit + ", oltpclienteCedula=" + oltpclienteCedula + " ]";
    }
    
}
