/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joako
 */
@Entity
@Table(name = "OLTPROL")
@NamedQueries({
    @NamedQuery(name = "Oltprol.findAll", query = "SELECT o FROM Oltprol o")
    , @NamedQuery(name = "Oltprol.findByIdrol", query = "SELECT o FROM Oltprol o WHERE o.idrol = :idrol")
    , @NamedQuery(name = "Oltprol.findByTipo", query = "SELECT o FROM Oltprol o WHERE o.tipo = :tipo")})
public class Oltprol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDROL")
    private BigDecimal idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltprol")
    private List<Oltpfuncio> oltpfuncioList;

    public Oltprol() {
    }

    public Oltprol(BigDecimal idrol) {
        this.idrol = idrol;
    }

    public Oltprol(BigDecimal idrol, String tipo) {
        this.idrol = idrol;
        this.tipo = tipo;
    }

    public BigDecimal getIdrol() {
        return idrol;
    }

    public void setIdrol(BigDecimal idrol) {
        this.idrol = idrol;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Oltpfuncio> getOltpfuncioList() {
        return oltpfuncioList;
    }

    public void setOltpfuncioList(List<Oltpfuncio> oltpfuncioList) {
        this.oltpfuncioList = oltpfuncioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltprol)) {
            return false;
        }
        Oltprol other = (Oltprol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltprol[ idrol=" + idrol + " ]";
    }
    
}
