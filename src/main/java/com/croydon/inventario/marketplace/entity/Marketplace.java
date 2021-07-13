/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Karen Web
 */
@Entity
@Table(name = "marketplace")
@NamedQueries({
    @NamedQuery(name = "Marketplace.findAll", query = "SELECT m FROM Marketplace m"),
    @NamedQuery(name = "Marketplace.findById", query = "SELECT m FROM Marketplace m WHERE m.id = :id"),
    @NamedQuery(name = "Marketplace.findByMpPkYuju", query = "SELECT m FROM Marketplace m WHERE m.mpPkYuju = :mpPkYuju"),
    @NamedQuery(name = "Marketplace.findByPrefixMp", query = "SELECT m FROM Marketplace m WHERE m.prefixMp = :prefixMp"),
    @NamedQuery(name = "Marketplace.findByShopPkYuju", query = "SELECT m FROM Marketplace m WHERE m.shopPkYuju = :shopPkYuju"),
    @NamedQuery(name = "Marketplace.findByNombre", query = "SELECT m FROM Marketplace m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Marketplace.findByPrioridad", query = "SELECT m FROM Marketplace m WHERE m.prioridad = :prioridad"),
    @NamedQuery(name = "Marketplace.findByEstado", query = "SELECT m FROM Marketplace m WHERE m.estado = :estado"),
    @NamedQuery(name = "Marketplace.findByMax", query = "SELECT m FROM Marketplace m WHERE m.max = :max"),
    @NamedQuery(name = "Marketplace.findByMin", query = "SELECT m FROM Marketplace m WHERE m.min = :min")})
public class Marketplace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "mp_pk_yuju")
    private String mpPkYuju;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prefix_mp")
    private String prefixMp;
    @Size(max = 45)
    @Column(name = "shop_pk_yuju")
    private String shopPkYuju;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "prioridad")
    private Integer prioridad;
    @Column(name = "estado")
    private Boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max")
    private int max;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min")
    private int min;
    @JoinColumn(name = "plataforma_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("marketplaceList")
    private Plataforma plataformaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marketplaceId")
 
    private List<MarketplaceProducto> marketplaceProductoList;

    public Marketplace() {
    }

    public Marketplace(Integer id) {
        this.id = id;
    }

    public Marketplace(Integer id, String prefixMp, int max, int min) {
        this.id = id;
        this.prefixMp = prefixMp;
        this.max = max;
        this.min = min;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMpPkYuju() {
        return mpPkYuju;
    }

    public void setMpPkYuju(String mpPkYuju) {
        this.mpPkYuju = mpPkYuju;
    }

    public String getPrefixMp() {
        return prefixMp;
    }

    public void setPrefixMp(String prefixMp) {
        this.prefixMp = prefixMp;
    }

    public String getShopPkYuju() {
        return shopPkYuju;
    }

    public void setShopPkYuju(String shopPkYuju) {
        this.shopPkYuju = shopPkYuju;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Plataforma getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(Plataforma plataformaId) {
        this.plataformaId = plataformaId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marketplace)) {
            return false;
        }
        Marketplace other = (Marketplace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.croydon.inventario.marketplace.entity.Marketplace[ id=" + id + " ]";
    }
    
}
