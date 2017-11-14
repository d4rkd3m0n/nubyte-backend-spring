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
@Table(name = "OLTPTIPO")
@NamedQueries({
    @NamedQuery(name = "Oltptipo.findAll", query = "SELECT o FROM Oltptipo o")
    , @NamedQuery(name = "Oltptipo.findByIdtipo", query = "SELECT o FROM Oltptipo o WHERE o.idtipo = :idtipo")
    , @NamedQuery(name = "Oltptipo.findByTipo", query = "SELECT o FROM Oltptipo o WHERE o.tipo = :tipo")})
public class Oltptipo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPO")
    private BigDecimal idtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltptipo")
    private List<Oltpproducto> oltpproductoList;

    public Oltptipo() {
    }

    public Oltptipo(BigDecimal idtipo) {
        this.idtipo = idtipo;
    }

    public Oltptipo(BigDecimal idtipo, String tipo) {
        this.idtipo = idtipo;
        this.tipo = tipo;
    }

    public BigDecimal getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(BigDecimal idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Oltpproducto> getOltpproductoList() {
        return oltpproductoList;
    }

    public void setOltpproductoList(List<Oltpproducto> oltpproductoList) {
        this.oltpproductoList = oltpproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltptipo)) {
            return false;
        }
        Oltptipo other = (Oltptipo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltptipo[ idtipo=" + idtipo + " ]";
    }
    
}
