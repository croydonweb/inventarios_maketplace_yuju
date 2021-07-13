package com.croydon.inventario.marketplace;

import com.croydon.inventario.marketplace.webservice.aurora.ConsultaDisponibilidadService;
import com.croydon.inventario.marketplace.webservice.Facturacion;
import com.croydon.inventario.marketplace.webservice.FacturacionService;
import com.croydon.inventario.marketplace.webservice.InvConsultaDispItemBodResponse;
import com.croydon.inventario.marketplace.webservice.jde.ConsultarDisponibilidadBodegaJde;
import java.lang.reflect.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ConsultaDisponibilidadService consultaDisponibilidadService;
    @Autowired
    ConsultarDisponibilidadBodegaJde consultarDisponibilidadBodega;
    
  

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        
        //System.out.println(consultarDisponibilidadBodega.disponibilidadManagerService("3000010-40", "C001"));
        //System.out.println(consultaDisponibilidadService.getDisponibilidadBodegas("3000010-38")); 
        //System.out.println(consultaDisponibilidadService.getDisponibilidadBodCroydonistas("3000010-38"));
        //System.out.println(consultaDisponibilidadService.getDisponibilidadBodega30("3000010-38"));
    }
    

}
