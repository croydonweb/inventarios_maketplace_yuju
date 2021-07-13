/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croydon.inventario.marketplace.excel.process;

import com.croydon.inventario.marketplace.entity.Producto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Karen Web
 */
@Service
public class ProcessExcel {

    Logger logger = LoggerFactory.getLogger(ProcessExcel.class);

    /*
    Metodo para leer el excel de entrada
     */
    public XSSFSheet leerExcel(String file) throws FileNotFoundException, IOException {

        // obtengo el excel de tipo FileInpuntStream 
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        //Obtener datos de la primera hoja
        XSSFSheet sheet = wb.getSheetAt(0);

        return sheet;

    }

}
