/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.service;

import com.croydon.inventario.marketplace.entity.Producto;
import com.croydon.inventario.marketplace.excel.process.ProcessExcel;
import com.croydon.inventario.marketplace.repository.ProductoRepository;
import com.croydon.inventario.marketplace.webservice.aurora.ConsultaDisponibilidadService;
import com.croydon.inventario.marketplace.webservice.jde.ConsultarDisponibilidadBodegaJde;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import oracle.e1.bssv.jp591021.BusinessServiceException_Exception;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Karen Web
 */
@Service
public class ProductoService {

    Logger logger = LoggerFactory.getLogger(ProcessExcel.class);

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    ProcessExcel processExcel;
    @Autowired
    ConsultarDisponibilidadBodegaJde consultarDisponibilidadBodegaJde;
    @Autowired
    BodegaService bodegaService;
    @Autowired
    ConsultaDisponibilidadService consultaDisponibilidadService;

    /*
    Metodo para Leer y retornar una lista de productos     */
    public List<Producto> readFile(String file) throws IOException {
        List<Producto> listProducto = new ArrayList<>();

        XSSFSheet sheet = processExcel.leerExcel(file);
        int rows = sheet.getLastRowNum();
        for (int i = 1; i <= rows; i++) {

            //recorrer filas
            XSSFRow row = sheet.getRow(i);

            XSSFCell skuCroydonCell = row.getCell(0);
            XSSFCell skuMpCell = row.getCell(1);
            XSSFCell mpCell = row.getCell(2);
            XSSFCell fechaIniCell = row.getCell(3);
            XSSFCell fechaFinCell = row.getCell(4);

            Producto producto = new Producto();

            // Asignamos las filas a los atributos
            producto.setSku(skuCroydonCell.getStringCellValue());
            producto.setFechaInicial(fechaIniCell.getDateCellValue());
            producto.setFechaFinal(fechaFinCell.getDateCellValue());

            // Validacion de rango de  fechas
            Date testDate = new Date();
            boolean validar = testDate.after(producto.getFechaInicial()) && testDate.before(producto.getFechaFinal());

            producto.setCatalogo(validar);

            //System.out.println(i + "->" + producto);
            listProducto.add(producto);

        }
        //logger.info(listProducto.toString());
        return listProducto;

    }

    /*
    Metodo para guardar la lista de producto
     */
    public void guardarFile(List<Producto> productos) {

        // if (erp = aurora) 
        // else ( erp = jde )   
       System.out.println("Productoos"+ productos.toString());
        System.out.println("Cantidad:"+consultaDisponibilidadService.getDisponibilidadBodCroydonistas( productos.get(0).getSku()));
        for (Producto producto : productos) {
            // String bodega = bodegaService.findById(1).get().getCodigo();
             producto.setCantidad(consultaDisponibilidadService.getDisponibilidadBodCroydonistas(producto.getSku()));
        }
        
        productoRepository.saveAll(productos);

    }

}
