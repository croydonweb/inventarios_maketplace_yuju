/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.webservice.aurora;

import com.croydon.inventario.marketplace.webservice.Facturacion;
import com.croydon.inventario.marketplace.webservice.FacturacionService;
import com.croydon.inventario.marketplace.webservice.InvConsultaDispItemBod;
import com.croydon.inventario.marketplace.webservice.InvConsultaDispItemBodResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karen Web
 */
@Service
public class ConsultaDisponibilidadService {

    public static final String UID = "800120681";
    public static final String CIA = "01";
    public static final String ANIO = "2021";
    public static final String APP = "03";
    public static final String CANTIDAD = "10000";

    @Autowired
    InvConsultaDispItemBod invConsultaDispItemBod;
    @Autowired
    InvConsultaDispItemBodResponse invConsultaDispItemBodResponse;

    /**
     *
     * @param sku
     * @return int Este metodo retornara la disponibilidad de todas la bodegas
     *
     */
    //public int getDisponibilidadBodegas(String sku) {

       // FacturacionService facturacionService = new FacturacionService();
       // Facturacion facturacionPort = facturacionService.getFacturacionPort();
       // String disp = facturacionPort.invConsultaDispItemBod(
           //     UID,
           //     CIA,
           //     ANIO,
           //     APP,
           //     sku,
           //     CANTIDAD
       // );

     //   return disponibilidadJSON(disp);
    //}

    /**
     *
     * @param sku
     * @return int 
     * Este metodo retornara la disponibilidad de la bodega 18
     *
     */
    public int  getDisponibilidadBodCroydonistas(String sku) {

        FacturacionService facturacionService = new FacturacionService();
        Facturacion facturacionPort = facturacionService.getFacturacionPort();
        String disp = facturacionPort.invConsultaDispCroydonista(
                UID,
                CIA,
                ANIO,
                APP,
                sku,
                CANTIDAD
        );

        return disponibilidadJSON(disp);

    }

    /**
     *
     * @param sku
     * @return int
     * Este metodo retornara la disponibilidad de la bodega 30
     *
     */
   // public int getDisponibilidadBodega30(String sku) {
        
       // int disponibilidad = getDisponibilidadBodegas(sku)-getDisponibilidadBodCroydonistas(sku);
        
        //return disponibilidad;

    //}

    /**
     *
     * @param disp
     * @return int
     * Este metodo retorna la cantidad del objeto disponibilidad convertido en JSON
     *
     */
    public Integer disponibilidadJSON(String disp) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Disponibilidad disponibilidad = gson.fromJson(disp, Disponibilidad.class);
        int cantidad = Integer.parseInt(disponibilidad.getCantDisponible());

        return cantidad;
    }

}
