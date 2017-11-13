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
public class OltpproductoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGOPRODUCTO")
    private String codigoproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OLTPTIPO_IDTIPO")
    private BigInteger oltptipoIdtipo;

    public OltpproductoPK() {
    }

    public OltpproductoPK(String codigoproducto, BigInteger oltptipoIdtipo) {
        this.codigoproducto = codigoproducto;
        this.oltptipoIdtipo = oltptipoIdtipo;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public BigInteger getOltptipoIdtipo() {
        return oltptipoIdtipo;
    }

    public void setOltptipoIdtipo(BigInteger oltptipoIdtipo) {
        this.oltptipoIdtipo = oltptipoIdtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoproducto != null ? codigoproducto.hashCode() : 0);
        hash += (oltptipoIdtipo != null ? oltptipoIdtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OltpproductoPK)) {
            return false;
        }
        OltpproductoPK other = (OltpproductoPK) object;
        if ((this.codigoproducto == null && other.codigoproducto != null) || (this.codigoproducto != null && !this.codigoproducto.equals(other.codigoproducto))) {
            return false;
        }
        if ((this.oltptipoIdtipo == null && other.oltptipoIdtipo != null) || (this.oltptipoIdtipo != null && !this.oltptipoIdtipo.equals(other.oltptipoIdtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.OltpproductoPK[ codigoproducto=" + codigoproducto + ", oltptipoIdtipo=" + oltptipoIdtipo + " ]";
    }
    
}
