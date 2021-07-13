/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.api.controller;

import com.croydon.inventario.marketplace.entity.Marketplace;
import com.croydon.inventario.marketplace.model.ErrorMessage;
import com.croydon.inventario.marketplace.model.SuccessMessage;
import com.croydon.inventario.marketplace.service.MarketplaceService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Karen Web
 */
@RestController
@RequestMapping("/api/marketplace")

public class MarketplaceApiController {

    @Autowired
    MarketplaceService marketplaceService;
    @Autowired
    SuccessMessage successMessage;

    /*
    Metodo para listar todos los marketplaces
     */
    @GetMapping("/")
    public ResponseEntity<?> listMarketplaces() {
        return ResponseEntity.ok(marketplaceService.listMarketplace());
    }

    /*
    Metodo para buscar por id 
     */

    @GetMapping(value = "{id}")
    public ResponseEntity<Marketplace> listById(@PathVariable("id") int id) {
        return ResponseEntity.ok(marketplaceService.finById(id).get());
    }

    /*
    Metodo para crear un nuevo marketplace
     */
    @PostMapping("/")
    private ResponseEntity<?> saveFile(@RequestBody Marketplace marketplace) {
        /*Valida si el nombre y el prefijo existen*/
        if (isPresentPrefixMpOrNombre(marketplace.getPrefixMp(), marketplace.getNombre())) {

            return ResponseEntity.badRequest().body(new ErrorMessage("002", "El marketplace ya existe."));

        }
        marketplaceService.save(marketplace);
        return ResponseEntity.ok().body(successMessage.getMessage("001", "marketplace"));
    }

    /*
    Metodo para eliminar marketplace por id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarketplace(@PathVariable int id) {
        /*Valida si existe el id*/
        if (isPresent(id)) {
            marketplaceService.deleteById(id);
            return ResponseEntity.ok().body(successMessage.getMessage("003", "marketplace"));
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("001", "El marketplace no existe."));

    }

    /*
    Metodo para actualizar marketplace
    */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMarketplace(@PathVariable int id, @RequestBody Marketplace marketplace) {
        marketplace.setId(id);
        if (isPresent(id)) {
            marketplaceService.save(marketplace);
            return ResponseEntity.ok().body(new SuccessMessage("002", "marketplace."));
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("001", "El marketplace no existe."));

    }

    /*
    Metodo para validar si el id esta presente
    */
    private boolean isPresent(int id) {

        return marketplaceService.finById(id).isPresent();

    }
    /*
    Metodo para validar si el prefijo o el nombre estan presentes
    */
    private boolean isPresentPrefixMpOrNombre(String prefixMp, String nombre) {

        return marketplaceService.findByPrefixMpOrNombre(prefixMp, nombre).isPresent();

    }

}
