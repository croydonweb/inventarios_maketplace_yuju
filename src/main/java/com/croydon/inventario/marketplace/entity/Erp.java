/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Karen Web
 */
@Entity
@Table(name = "erp")
@NamedQueries({
    @NamedQuery(name = "Erp.findAll", query = "SELECT e FROM Erp e"),
    @NamedQuery(name = "Erp.findById", query = "SELECT e FROM Erp e WHERE e.id = :id"),
    @NamedQuery(name = "Erp.findByCodigo", query = "SELECT e FROM Erp e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Erp.findByEstado", query = "SELECT e FROM Erp e WHERE e.estado = :estado"),
    @NamedQuery(name = "Erp.findByNombre", query = "SELECT e FROM Erp e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Erp.findByUrlServicio", query = "SELECT e FROM Erp e WHERE e.urlServicio = :urlServicio")})
public class Erp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 60)
    @Column(name = "url_servicio")
    private String urlServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erpId")
    private List<Bodega> bodegaList;

    public Erp() {
    }

    public Erp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlServicio() {
        return urlServicio;
    }

    public void setUrlServicio(String urlServicio) {
        this.urlServicio = urlServicio;
    }

    public List<Bodega> getBodegaList() {
        return bodegaList;
    }

    public void setBodegaList(List<Bodega> bodegaList) {
        this.bodegaList = bodegaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Erp)) {
            return false;
        }
        Erp other = (Erp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.croydon.inventario.marketplace.entity.Erp[ id=" + id + " ]";
    }
    
}
