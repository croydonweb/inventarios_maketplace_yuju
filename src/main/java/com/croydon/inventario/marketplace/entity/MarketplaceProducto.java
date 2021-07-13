/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Karen Web
 */
@Entity
@Table(name = "marketplace_producto")
@NamedQueries({
    @NamedQuery(name = "MarketplaceProducto.findAll", query = "SELECT m FROM MarketplaceProducto m"),
    @NamedQuery(name = "MarketplaceProducto.findById", query = "SELECT m FROM MarketplaceProducto m WHERE m.id = :id"),
    @NamedQuery(name = "MarketplaceProducto.findByCantidad", query = "SELECT m FROM MarketplaceProducto m WHERE m.cantidad = :cantidad")})
public class MarketplaceProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "marketplace_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Marketplace marketplaceId;
    @JoinColumn(name = "producto_sku", referencedColumnName = "sku")
    @ManyToOne(optional = false)
    private Producto productoSku;

    public MarketplaceProducto() {
    }

    public MarketplaceProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Marketplace getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(Marketplace marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public Producto getProductoSku() {
        return productoSku;
    }

    public void setProductoSku(Producto productoSku) {
        this.productoSku = productoSku;
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
        if (!(object instanceof MarketplaceProducto)) {
            return false;
        }
        MarketplaceProducto other = (MarketplaceProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.croydon.inventario.marketplace.entity.MarketplaceProducto[ id=" + id + " ]";
    }
    
}
