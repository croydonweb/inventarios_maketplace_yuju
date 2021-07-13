/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.service;

import com.croydon.inventario.marketplace.entity.Marketplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.croydon.inventario.marketplace.repository.MarketplaceRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Karen Web
 */
@Service
public class MarketplaceService {

    @Autowired
    private MarketplaceRepository marketplaceRepository;

    public List<Marketplace> listMarketplace() {
        return marketplaceRepository.findAll();
    }

    public Optional<Marketplace> finById(int id) {
        return marketplaceRepository.findById(id);
    }

    public Marketplace save(Marketplace marketplace) {
        return marketplaceRepository.save(marketplace);
    }

    public void deleteById(int id) {
        marketplaceRepository.deleteById(id);
    }

    public Optional<Marketplace> findByPrefixMpOrNombre(String prefixMp, String nombre) {
        return marketplaceRepository.findByPrefixMpOrNombre(prefixMp, nombre);
    }

}
