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
public class OltpdetallecPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "OLTPCOMPRA_NUMEROCOMPRA")
    private BigInteger oltpcompraNumerocompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "OLTPPRODUCTO_CODIGOPRODUCTO")
    private String oltpproductoCodigoproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "OLTPCOMPRA_OLTPESTABLECI_NIT")
    private String oltpcompraOltpestableciNit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OLTPCOMPRA_OLTPCLIENTE_CEDULA")
    private BigInteger oltpcompraOltpclienteCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OLTPPRODUCTO_IDTIPO")
    private BigInteger oltpproductoIdtipo;

    public OltpdetallecPK() {
    }

    public OltpdetallecPK(BigInteger oltpcompraNumerocompra, String oltpproductoCodigoproducto, String oltpcompraOltpestableciNit, BigInteger oltpcompraOltpclienteCedula, BigInteger oltpproductoIdtipo) {
        this.oltpcompraNumerocompra = oltpcompraNumerocompra;
        this.oltpproductoCodigoproducto = oltpproductoCodigoproducto;
        this.oltpcompraOltpestableciNit = oltpcompraOltpestableciNit;
        this.oltpcompraOltpclienteCedula = oltpcompraOltpclienteCedula;
        this.oltpproductoIdtipo = oltpproductoIdtipo;
    }

    public BigInteger getOltpcompraNumerocompra() {
        return oltpcompraNumerocompra;
    }

    public void setOltpcompraNumerocompra(BigInteger oltpcompraNumerocompra) {
        this.oltpcompraNumerocompra = oltpcompraNumerocompra;
    }

    public String getOltpproductoCodigoproducto() {
        return oltpproductoCodigoproducto;
    }

    public void setOltpproductoCodigoproducto(String oltpproductoCodigoproducto) {
        this.oltpproductoCodigoproducto = oltpproductoCodigoproducto;
    }

    public String getOltpcompraOltpestableciNit() {
        return oltpcompraOltpestableciNit;
    }

    public void setOltpcompraOltpestableciNit(String oltpcompraOltpestableciNit) {
        this.oltpcompraOltpestableciNit = oltpcompraOltpestableciNit;
    }

    public BigInteger getOltpcompraOltpclienteCedula() {
        return oltpcompraOltpclienteCedula;
    }

    public void setOltpcompraOltpclienteCedula(BigInteger oltpcompraOltpclienteCedula) {
        this.oltpcompraOltpclienteCedula = oltpcompraOltpclienteCedula;
    }

    public BigInteger getOltpproductoIdtipo() {
        return oltpproductoIdtipo;
    }

    public void setOltpproductoIdtipo(BigInteger oltpproductoIdtipo) {
        this.oltpproductoIdtipo = oltpproductoIdtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oltpcompraNumerocompra != null ? oltpcompraNumerocompra.hashCode() : 0);
        hash += (oltpproductoCodigoproducto != null ? oltpproductoCodigoproducto.hashCode() : 0);
        hash += (oltpcompraOltpestableciNit != null ? oltpcompraOltpestableciNit.hashCode() : 0);
        hash += (oltpcompraOltpclienteCedula != null ? oltpcompraOltpclienteCedula.hashCode() : 0);
        hash += (oltpproductoIdtipo != null ? oltpproductoIdtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OltpdetallecPK)) {
            return false;
        }
        OltpdetallecPK other = (OltpdetallecPK) object;
        if ((this.oltpcompraNumerocompra == null && other.oltpcompraNumerocompra != null) || (this.oltpcompraNumerocompra != null && !this.oltpcompraNumerocompra.equals(other.oltpcompraNumerocompra))) {
            return false;
        }
        if ((this.oltpproductoCodigoproducto == null && other.oltpproductoCodigoproducto != null) || (this.oltpproductoCodigoproducto != null && !this.oltpproductoCodigoproducto.equals(other.oltpproductoCodigoproducto))) {
            return false;
        }
        if ((this.oltpcompraOltpestableciNit == null && other.oltpcompraOltpestableciNit != null) || (this.oltpcompraOltpestableciNit != null && !this.oltpcompraOltpestableciNit.equals(other.oltpcompraOltpestableciNit))) {
            return false;
        }
        if ((this.oltpcompraOltpclienteCedula == null && other.oltpcompraOltpclienteCedula != null) || (this.oltpcompraOltpclienteCedula != null && !this.oltpcompraOltpclienteCedula.equals(other.oltpcompraOltpclienteCedula))) {
            return false;
        }
        if ((this.oltpproductoIdtipo == null && other.oltpproductoIdtipo != null) || (this.oltpproductoIdtipo != null && !this.oltpproductoIdtipo.equals(other.oltpproductoIdtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.OltpdetallecPK[ oltpcompraNumerocompra=" + oltpcompraNumerocompra + ", oltpproductoCodigoproducto=" + oltpproductoCodigoproducto + ", oltpcompraOltpestableciNit=" + oltpcompraOltpestableciNit + ", oltpcompraOltpclienteCedula=" + oltpcompraOltpclienteCedula + ", oltpproductoIdtipo=" + oltpproductoIdtipo + " ]";
    }
    
}
