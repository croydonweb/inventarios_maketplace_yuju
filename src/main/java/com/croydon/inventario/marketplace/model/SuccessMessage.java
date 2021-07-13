/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Karen Web
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessMessage {

    private String codigo;
    private String mensaje;
    private String clase;

    public SuccessMessage(String codigo, String clase) {
        this.codigo = codigo;
        this.clase = clase;
    }

    public SuccessMessage getMessage(String codigo, String clase) {
        
        switch (codigo) {
            case "001":
                this.mensaje = clase + " cread@ correctamente";
                break;
            case "002":
                this.mensaje = clase + " actualizad@ correctamente";
                break;
            case "003":
                this.mensaje = clase + " eliminad@ correctamente";
                break;
        }
        return new SuccessMessage(codigo, mensaje,clase );
        
    }
}
