/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.api.controller;

import com.croydon.inventario.marketplace.entity.Bodega;
import com.croydon.inventario.marketplace.model.ErrorMessage;
import com.croydon.inventario.marketplace.model.SuccessMessage;
import com.croydon.inventario.marketplace.service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/bodega")
public class BodegaApiController {

    @Autowired
    BodegaService bodegaService;
    @Autowired
    SuccessMessage successMessage;

    /*
    Metodo para listar bodegas
     */
    @GetMapping("/")
    public ResponseEntity<?> listarBodegas() {
        return ResponseEntity.ok(bodegaService.ListBodega());
    }

    /*
    Metodo para buscar por id 
     */
    @GetMapping(value = "{id}")
    public ResponseEntity<Bodega> listById(@PathVariable("id") int id) {
        return ResponseEntity.ok(bodegaService.findById(id).get());
    }

    /*
    Metodo para crear una nueva bodega
     */
    @PostMapping("/")
    private ResponseEntity<?> saveBodega(@RequestBody Bodega bodega) {
        /*Valida si el nombre y el codigo de la bodega existen*/
        if (isPresentNombreOrCodigo(bodega.getNombre(), bodega.getCodigo())) {

            return ResponseEntity.badRequest().body(new ErrorMessage("001", "La bodega ya existe"));
        }

        bodegaService.save(bodega);
        return ResponseEntity.ok().body(successMessage.getMessage("001", "bodega"));

    }

    /*
    Metodo para actualizar una bodega
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBodega(@PathVariable int id, @RequestBody Bodega bodega) {
        bodega.setId(id);
        if (isPresent(id)) {
            bodegaService.save(bodega);
            return ResponseEntity.ok().body(successMessage.getMessage("002", "bodega"));
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("001", "La bodega no existe"));
    }

    /*
    Metodo para elimina bodega
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBodega(@PathVariable int id) {

        if (isPresent(id)) {
            bodegaService.deleteById(id);
            return ResponseEntity.ok().body(successMessage.getMessage("003", "bodega"));
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("001", "La bodega no existe."));

    }

    /*
    Metodo para validar si esta presente el id 
     */
    private boolean isPresent(int id) {
        return bodegaService.findById(id).isPresent();
    }

    /*
    Metodo para validar si el nombre y el codigo estan presentes
     */
    private boolean isPresentNombreOrCodigo(String nombre, String codigo) {

        return bodegaService.findByNombreOrCodigo(nombre, codigo).isPresent();
    }

}
