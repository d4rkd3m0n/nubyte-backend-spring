/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.model.oltp;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "OLTPESTABLECI")
@NamedQueries({
    @NamedQuery(name = "Oltpestableci.findAll", query = "SELECT o FROM Oltpestableci o")
    , @NamedQuery(name = "Oltpestableci.findByNit", query = "SELECT o FROM Oltpestableci o WHERE o.nit = :nit")
    , @NamedQuery(name = "Oltpestableci.findByNombre", query = "SELECT o FROM Oltpestableci o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Oltpestableci.findByDireccion", query = "SELECT o FROM Oltpestableci o WHERE o.direccion = :direccion")
    , @NamedQuery(name = "Oltpestableci.findByLatitud", query = "SELECT o FROM Oltpestableci o WHERE o.latitud = :latitud")
    , @NamedQuery(name = "Oltpestableci.findByLongitud", query = "SELECT o FROM Oltpestableci o WHERE o.longitud = :longitud")
    , @NamedQuery(name = "Oltpestableci.findByLocalidad", query = "SELECT o FROM Oltpestableci o WHERE o.localidad = :localidad")})
public class Oltpestableci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NIT")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUD")
    private BigInteger latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD")
    private BigInteger longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @JoinTable(name = "RELATION_9", joinColumns = {
        @JoinColumn(name = "OLTPESTABLECI_NIT", referencedColumnName = "NIT")}, inverseJoinColumns = {
        @JoinColumn(name = "OLTPPRODUCTO_CODIGOPRODUCTO", referencedColumnName = "CODIGOPRODUCTO")
        , @JoinColumn(name = "OLTPPRODUCTO_OLTPTIPO_IDTIPO", referencedColumnName = "OLTPTIPO_IDTIPO")})
    @ManyToMany
    private List<Oltpproducto> oltpproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltpestableci")
    private List<Oltpcompra> oltpcompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oltpestableci")
    private List<Oltpfuncio> oltpfuncioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nit")
    private List<Oltpreserva> oltpreservaList;

    public Oltpestableci() {
    }

    public Oltpestableci(String nit) {
        this.nit = nit;
    }

    public Oltpestableci(String nit, String nombre, String direccion, BigInteger latitud, BigInteger longitud, String localidad) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.localidad = localidad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getLatitud() {
        return latitud;
    }

    public void setLatitud(BigInteger latitud) {
        this.latitud = latitud;
    }

    public BigInteger getLongitud() {
        return longitud;
    }

    public void setLongitud(BigInteger longitud) {
        this.longitud = longitud;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @XmlTransient
    public List<Oltpproducto> getOltpproductoList() {
        return oltpproductoList;
    }

    public void setOltpproductoList(List<Oltpproducto> oltpproductoList) {
        this.oltpproductoList = oltpproductoList;
    }

    @XmlTransient
    public List<Oltpcompra> getOltpcompraList() {
        return oltpcompraList;
    }

    public void setOltpcompraList(List<Oltpcompra> oltpcompraList) {
        this.oltpcompraList = oltpcompraList;
    }

    @XmlTransient
    public List<Oltpfuncio> getOltpfuncioList() {
        return oltpfuncioList;
    }

    public void setOltpfuncioList(List<Oltpfuncio> oltpfuncioList) {
        this.oltpfuncioList = oltpfuncioList;
    }

    @XmlTransient
    public List<Oltpreserva> getOltpreservaList() {
        return oltpreservaList;
    }

    public void setOltpreservaList(List<Oltpreserva> oltpreservaList) {
        this.oltpreservaList = oltpreservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oltpestableci)) {
            return false;
        }
        Oltpestableci other = (Oltpestableci) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJBEntities.Oltpestableci[ nit=" + nit + " ]";
    }
    
}
