/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author Karen Web
 */
@Component
public class ErrorMessage {
    
    
    private String codigo;
    private String mensaje;

    public ErrorMessage() {
    }

    public ErrorMessage(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

  
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" + "codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }
    
    
    
}
