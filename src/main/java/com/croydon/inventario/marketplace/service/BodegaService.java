/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.service;

import com.croydon.inventario.marketplace.entity.Bodega;
import com.croydon.inventario.marketplace.repository.BodegaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karen Web
 */
@Service
public class BodegaService {
    
    @Autowired
    private BodegaRepository bodegaRepository;
    
    public List<Bodega> ListBodega(){
    return bodegaRepository.findAll();
    }
    
    public Optional<Bodega> findById (int id){
    return bodegaRepository.findById(id);
    }
    
    public Bodega save (Bodega bodega){
    return bodegaRepository.save(bodega);
    }
    
    public  void deleteById(int id){
        bodegaRepository.deleteById(id);
    }
    
    public Optional<Bodega> findByNombreOrCodigo (String nombre, String codigo){
        return bodegaRepository.findByNombreOrCodigo(nombre, codigo);
    }

    
    
}
