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
@Table(name = "OLTPFUNCIO")
@NamedQueries({
    @NamedQuery(name = "Oltpfuncio.findAll", query = "SELECT o FROM Oltpfuncio o")
    , @NamedQuery(name = "Oltpfuncio.findByCedula", query = "SELECT o FROM Oltpfuncio o WHERE o.oltpfuncioPK.cedula = :cedula")
    , @NamedQuery(name = "Oltpfuncio.findByNombrefunc", query = "SELECT o FROM Oltpfuncio o WHERE o.nombrefunc = :nombrefunc")
    , @NamedQuery(name = "Oltpfuncio.findByContrasena", query = "SELECT o FROM Oltpfuncio o WHERE o.contrasena = :contrasena")
    , @NamedQuery(name = "Oltpfuncio.findByCorreo", query = "SELECT o FROM Oltpfuncio o WHERE o.correo = :correo")
    , @NamedQuery(name = "Oltpfuncio.findByOltpestableciNit", query = "SELECT o FROM Oltpfuncio o WHERE o.oltpfuncioPK.oltpestableciNit = :oltpestableciNit")
    , @NamedQuery(name = "Oltpfuncio.findByOltprolIdrol", query = "SELECT o FROM Oltpfuncio o WHERE o.oltpfuncioPK.oltprolIdrol = :oltprolIdrol")})
public class Oltpfuncio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OltpfuncioPK oltpfuncioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREFUNC")
    private String nombrefunc;
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
    @JoinColumn(name = "OLTPESTABLECI_NIT", referencedColumnName = "NIT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oltpestableci oltpestableci;
    @JoinColumn(name = "OLTPROL_IDROL", referencedColumnName = "IDROL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oltprol oltprol;

    public Oltpfuncio() {
    }

    public Oltpfuncio(OltpfuncioPK oltpfuncioPK) {
        this.oltpfuncioPK = oltpfuncioPK;
    }

    public Oltpfuncio(OltpfuncioPK oltpfuncioPK, String nombrefunc, String contrasena, String correo) {
        this.oltpfuncioPK = oltpfuncioPK;
        this.nombrefunc = nombrefunc;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public Oltpfuncio(BigInteger cedula, String oltpestableciNit, BigInteger oltprolIdrol) {
        this.oltpfuncioPK = new OltpfuncioPK(cedula, oltpestableciNit, oltprolIdrol);
    }

    public OltpfuncioPK getOltpfuncioPK() {
        return oltpfuncioPK;
    }

    public void setOltpfuncioPK(OltpfuncioPK oltpfuncioPK) {
        this.oltpfuncioPK = oltpfuncioPK;
    }

    public String getNombrefunc() {
        return nombrefunc;
    }

    public void setNombrefunc(String nombrefunc) {
        this.nombrefunc = nombrefunc;
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

    public Oltpestableci getOltpestableci() {
        return oltpestableci;
    }

    public void setOltpestableci(Oltpestableci oltpestableci) {
        this.oltpestableci = oltpestableci;
    }

    public Oltprol getOltprol() {
        return oltprol;
    }

    public void setOltprol(Oltprol oltprol) {
        this.oltprol = oltprol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oltpfuncioPK != null ? oltpfuncioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpfuncio)) {
            return false;
        }
        Oltpfuncio other = (Oltpfuncio) object;
        if ((this.oltpfuncioPK == null && other.oltpfuncioPK != null) || (this.oltpfuncioPK != null && !this.oltpfuncioPK.equals(other.oltpfuncioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpfuncio[ oltpfuncioPK=" + oltpfuncioPK + " ]";
    }
    
}
