/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.repository;

import com.croydon.inventario.marketplace.entity.Bodega;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Karen Web
 */
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
    
    public Optional<Bodega> findByNombreOrCodigo (String nombre , String codigo);
}
