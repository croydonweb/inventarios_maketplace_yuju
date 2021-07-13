/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.repository;


import com.croydon.inventario.marketplace.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Karen Web
 */
public interface ProductoRepository extends JpaRepository <Producto, String>{
    
}
