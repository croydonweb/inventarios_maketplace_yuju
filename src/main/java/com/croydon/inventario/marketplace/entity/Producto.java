/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Karen Web
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findBySku", query = "SELECT p FROM Producto p WHERE p.sku = :sku"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByCatalogo", query = "SELECT p FROM Producto p WHERE p.catalogo = :catalogo"),
    @NamedQuery(name = "Producto.findByFechaInicial", query = "SELECT p FROM Producto p WHERE p.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Producto.findByFechaFinal", query = "SELECT p FROM Producto p WHERE p.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Producto.findByCreado", query = "SELECT p FROM Producto p WHERE p.creado = :creado"),
    @NamedQuery(name = "Producto.findByActualizado", query = "SELECT p FROM Producto p WHERE p.actualizado = :actualizado")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sku")
    private String sku;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "catalogo")
    private Boolean catalogo;
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name = "creado", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creado;
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date actualizado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoSku")
    private List<MarketplaceProducto> marketplaceProductoList;

    public Producto() {
    }

    public Producto(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Boolean catalogo) {
        this.catalogo = catalogo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public List<MarketplaceProducto> getMarketplaceProductoList() {
        return marketplaceProductoList;
    }

    public void setMarketplaceProductoList(List<MarketplaceProducto> marketplaceProductoList) {
        this.marketplaceProductoList = marketplaceProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sku != null ? sku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.sku == null && other.sku != null) || (this.sku != null && !this.sku.equals(other.sku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.croydon.inventario.marketplace.entity.Producto[ sku=" + sku + " ]";
    }
    
}
