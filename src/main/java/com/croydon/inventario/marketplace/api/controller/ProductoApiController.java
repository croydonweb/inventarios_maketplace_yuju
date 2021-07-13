/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.api.controller;

import com.croydon.inventario.marketplace.entity.Producto;
import com.croydon.inventario.marketplace.excel.process.ProcessExcel;
import com.croydon.inventario.marketplace.model.SuccessMessage;
import com.croydon.inventario.marketplace.service.ProductoService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Karen Web
 */

@RestController
@RequestMapping("/api/productos")

public class ProductoApiController {
    
    @Autowired
    ProcessExcel processExcel;
    @Autowired
    ProductoService productoService;
    
    /*
    Metodo para cargar archivo
    */
    @PostMapping("/")
    public ResponseEntity<?> updloadFile (MultipartFile file) throws IOException {
    
        System.out.println("file"+file.getOriginalFilename());
        List<Producto> productos = productoService.readFile("C:\\Users\\Karen Web\\Downloads\\"+file.getOriginalFilename());
        //System.out.println("producto"+ productos.toString());
        productoService.guardarFile(productos);
        return ResponseEntity.ok(new SuccessMessage("001", "producto"));
       
    }
    
    
}
