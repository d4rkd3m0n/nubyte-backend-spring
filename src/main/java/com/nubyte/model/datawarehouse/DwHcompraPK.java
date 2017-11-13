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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Joako
 */
@Embeddable
public class DwHcompraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMCOMPRA")
    private BigInteger numcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DW_DESTABLEC_IDEST")
    private BigInteger dwDestablecIdest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DW_DTIEMPO_IDFEC")
    private BigInteger dwDtiempoIdfec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DW_DCLIENTE_IDCLI")
    private BigInteger dwDclienteIdcli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DW_DPRODUCTO_IDPROD")
    private BigInteger dwDproductoIdprod;

    public DwHcompraPK() {
    }

    public DwHcompraPK(BigInteger numcompra, BigInteger dwDestablecIdest, BigInteger dwDtiempoIdfec, BigInteger dwDclienteIdcli, BigInteger dwDproductoIdprod) {
        this.numcompra = numcompra;
        this.dwDestablecIdest = dwDestablecIdest;
        this.dwDtiempoIdfec = dwDtiempoIdfec;
        this.dwDclienteIdcli = dwDclienteIdcli;
        this.dwDproductoIdprod = dwDproductoIdprod;
    }

    public BigInteger getNumcompra() {
        return numcompra;
    }

    public void setNumcompra(BigInteger numcompra) {
        this.numcompra = numcompra;
    }

    public BigInteger getDwDestablecIdest() {
        return dwDestablecIdest;
    }

    public void setDwDestablecIdest(BigInteger dwDestablecIdest) {
        this.dwDestablecIdest = dwDestablecIdest;
    }

    public BigInteger getDwDtiempoIdfec() {
        return dwDtiempoIdfec;
    }

    public void setDwDtiempoIdfec(BigInteger dwDtiempoIdfec) {
        this.dwDtiempoIdfec = dwDtiempoIdfec;
    }

    public BigInteger getDwDclienteIdcli() {
        return dwDclienteIdcli;
    }

    public void setDwDclienteIdcli(BigInteger dwDclienteIdcli) {
        this.dwDclienteIdcli = dwDclienteIdcli;
    }

    public BigInteger getDwDproductoIdprod() {
        return dwDproductoIdprod;
    }

    public void setDwDproductoIdprod(BigInteger dwDproductoIdprod) {
        this.dwDproductoIdprod = dwDproductoIdprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcompra != null ? numcompra.hashCode() : 0);
        hash += (dwDestablecIdest != null ? dwDestablecIdest.hashCode() : 0);
        hash += (dwDtiempoIdfec != null ? dwDtiempoIdfec.hashCode() : 0);
        hash += (dwDclienteIdcli != null ? dwDclienteIdcli.hashCode() : 0);
        hash += (dwDproductoIdprod != null ? dwDproductoIdprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwHcompraPK)) {
            return false;
        }
        DwHcompraPK other = (DwHcompraPK) object;
        if ((this.numcompra == null && other.numcompra != null) || (this.numcompra != null && !this.numcompra.equals(other.numcompra))) {
            return false;
        }
        if ((this.dwDestablecIdest == null && other.dwDestablecIdest != null) || (this.dwDestablecIdest != null && !this.dwDestablecIdest.equals(other.dwDestablecIdest))) {
            return false;
        }
        if ((this.dwDtiempoIdfec == null && other.dwDtiempoIdfec != null) || (this.dwDtiempoIdfec != null && !this.dwDtiempoIdfec.equals(other.dwDtiempoIdfec))) {
            return false;
        }
        if ((this.dwDclienteIdcli == null && other.dwDclienteIdcli != null) || (this.dwDclienteIdcli != null && !this.dwDclienteIdcli.equals(other.dwDclienteIdcli))) {
            return false;
        }
        if ((this.dwDproductoIdprod == null && other.dwDproductoIdprod != null) || (this.dwDproductoIdprod != null && !this.dwDproductoIdprod.equals(other.dwDproductoIdprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.DwHcompraPK[ numcompra=" + numcompra + ", dwDestablecIdest=" + dwDestablecIdest + ", dwDtiempoIdfec=" + dwDtiempoIdfec + ", dwDclienteIdcli=" + dwDclienteIdcli + ", dwDproductoIdprod=" + dwDproductoIdprod + " ]";
    }
    
}
