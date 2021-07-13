/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.webservice.jde;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import oracle.e1.bssv.jp591021.BusinessServiceException_Exception;
import oracle.e1.bssv.jp591021.DisponibilidadManager;
import oracle.e1.bssv.jp591021.DisponibilidadManagerService;
import oracle.e1.bssv.jp591021.DisponibilidadReponseVO;
import oracle.e1.bssv.jp591021.DisponibilidadVO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karen Web
 */
@Service
public class ConsultarDisponibilidadBodegaJde {

    // public 
    public int disponibilidadManagerService(String sku, String bodega) throws BusinessServiceException_Exception {
        
        int cantidad = 0;
        
        DisponibilidadManagerService dm = new DisponibilidadManagerService();
        DisponibilidadVO disponibilidadVO = new DisponibilidadVO();
        disponibilidadVO.setSzLITMCodArticulo(sku);
        disponibilidadVO.setSzMCUBodega(bodega);
        
        List<DisponibilidadReponseVO> listDisponibilidad = dm.getDisponibilidadManagerPort().obtenerDisponibilidadPorBodega(disponibilidadVO);
        for (DisponibilidadReponseVO disponibilidad : listDisponibilidad) {
             cantidad = disponibilidad.getCantidad().intValueExact();
         
            }
        
        return cantidad;
  
    }

}
