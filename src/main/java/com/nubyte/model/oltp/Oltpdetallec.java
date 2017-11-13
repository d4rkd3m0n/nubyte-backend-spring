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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joako
 */
@Entity
@Table(name = "OLTPDETALLEC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oltpdetallec.findAll", query = "SELECT o FROM Oltpdetallec o")
    , @NamedQuery(name = "Oltpdetallec.findByOltpcompraNumerocompra", query = "SELECT o FROM Oltpdetallec o WHERE o.oltpdetallecPK.oltpcompraNumerocompra = :oltpcompraNumerocompra")
    , @NamedQuery(name = "Oltpdetallec.findByOltpproductoCodigoproducto", query = "SELECT o FROM Oltpdetallec o WHERE o.oltpdetallecPK.oltpproductoCodigoproducto = :oltpproductoCodigoproducto")
    , @NamedQuery(name = "Oltpdetallec.findByOltpcompraOltpestableciNit", query = "SELECT o FROM Oltpdetallec o WHERE o.oltpdetallecPK.oltpcompraOltpestableciNit = :oltpcompraOltpestableciNit")
    , @NamedQuery(name = "Oltpdetallec.findByOltpcompraOltpclienteCedula", query = "SELECT o FROM Oltpdetallec o WHERE o.oltpdetallecPK.oltpcompraOltpclienteCedula = :oltpcompraOltpclienteCedula")
    , @NamedQuery(name = "Oltpdetallec.findByOltpproductoIdtipo", query = "SELECT o FROM Oltpdetallec o WHERE o.oltpdetallecPK.oltpproductoIdtipo = :oltpproductoIdtipo")
    , @NamedQuery(name = "Oltpdetallec.findByCantidad", query = "SELECT o FROM Oltpdetallec o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Oltpdetallec.findByPreciounitarioproducto", query = "SELECT o FROM Oltpdetallec o WHERE o.preciounitarioproducto = :preciounitarioproducto")
    , @NamedQuery(name = "Oltpdetallec.findByPrecioimpuesto", query = "SELECT o FROM Oltpdetallec o WHERE o.precioimpuesto = :precioimpuesto")})
public class Oltpdetallec implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OltpdetallecPK oltpdetallecPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOUNITARIOPRODUCTO")
    private BigInteger preciounitarioproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOIMPUESTO")
    private BigInteger precioimpuesto;
    @JoinColumns({
        @JoinColumn(name = "OLTPCOMPRA_NUMEROCOMPRA", referencedColumnName = "NUMEROCOMPRA", insertable = false, updatable = false)
        , @JoinColumn(name = "OLTPCOMPRA_OLTPESTABLECI_NIT", referencedColumnName = "OLTPESTABLECI_NIT", insertable = false, updatable = false)
        , @JoinColumn(name = "OLTPCOMPRA_OLTPCLIENTE_CEDULA", referencedColumnName = "OLTPCLIENTE_CEDULA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Oltpcompra oltpcompra;
    @JoinColumns({
        @JoinColumn(name = "OLTPPRODUCTO_CODIGOPRODUCTO", referencedColumnName = "CODIGOPRODUCTO", insertable = false, updatable = false)
        , @JoinColumn(name = "OLTPPRODUCTO_IDTIPO", referencedColumnName = "OLTPTIPO_IDTIPO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Oltpproducto oltpproducto;

    public Oltpdetallec() {
    }

    public Oltpdetallec(OltpdetallecPK oltpdetallecPK) {
        this.oltpdetallecPK = oltpdetallecPK;
    }

    public Oltpdetallec(OltpdetallecPK oltpdetallecPK, BigInteger cantidad, BigInteger preciounitarioproducto, BigInteger precioimpuesto) {
        this.oltpdetallecPK = oltpdetallecPK;
        this.cantidad = cantidad;
        this.preciounitarioproducto = preciounitarioproducto;
        this.precioimpuesto = precioimpuesto;
    }

    public Oltpdetallec(BigInteger oltpcompraNumerocompra, String oltpproductoCodigoproducto, String oltpcompraOltpestableciNit, BigInteger oltpcompraOltpclienteCedula, BigInteger oltpproductoIdtipo) {
        this.oltpdetallecPK = new OltpdetallecPK(oltpcompraNumerocompra, oltpproductoCodigoproducto, oltpcompraOltpestableciNit, oltpcompraOltpclienteCedula, oltpproductoIdtipo);
    }

    public OltpdetallecPK getOltpdetallecPK() {
        return oltpdetallecPK;
    }

    public void setOltpdetallecPK(OltpdetallecPK oltpdetallecPK) {
        this.oltpdetallecPK = oltpdetallecPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPreciounitarioproducto() {
        return preciounitarioproducto;
    }

    public void setPreciounitarioproducto(BigInteger preciounitarioproducto) {
        this.preciounitarioproducto = preciounitarioproducto;
    }

    public BigInteger getPrecioimpuesto() {
        return precioimpuesto;
    }

    public void setPrecioimpuesto(BigInteger precioimpuesto) {
        this.precioimpuesto = precioimpuesto;
    }

    public Oltpcompra getOltpcompra() {
        return oltpcompra;
    }

    public void setOltpcompra(Oltpcompra oltpcompra) {
        this.oltpcompra = oltpcompra;
    }

    public Oltpproducto getOltpproducto() {
        return oltpproducto;
    }

    public void setOltpproducto(Oltpproducto oltpproducto) {
        this.oltpproducto = oltpproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oltpdetallecPK != null ? oltpdetallecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpdetallec)) {
            return false;
        }
        Oltpdetallec other = (Oltpdetallec) object;
        if ((this.oltpdetallecPK == null && other.oltpdetallecPK != null) || (this.oltpdetallecPK != null && !this.oltpdetallecPK.equals(other.oltpdetallecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpdetallec[ oltpdetallecPK=" + oltpdetallecPK + " ]";
    }
    
}
