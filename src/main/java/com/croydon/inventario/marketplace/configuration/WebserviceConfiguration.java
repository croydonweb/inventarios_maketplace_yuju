/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.configuration;

import com.croydon.inventario.marketplace.webservice.Facturacion;
import com.croydon.inventario.marketplace.webservice.FacturacionService;
import com.croydon.inventario.marketplace.webservice.InvConsultaDispCroydonistaResponse;
import com.croydon.inventario.marketplace.webservice.InvConsultaDispItemBod;
import com.croydon.inventario.marketplace.webservice.InvConsultaDispItemBodResponse;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Karen Web
 */
@SpringBootConfiguration
public class WebserviceConfiguration {

    @Bean
    public InvConsultaDispItemBod invConsultaDispItemBod() {

        return new InvConsultaDispItemBod();
    }

    @Bean
    public InvConsultaDispItemBodResponse invConsultaDispItemBodResponse() {

        return new InvConsultaDispItemBodResponse();

    }



}
