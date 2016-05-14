package com.selenium.testcases;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmalyalavenkatad on 5/13/16.
 */
public class ExcelOps {
    HSSFWorkbook workbook;
    HSSFSheet sheet;
    Row row;
    Cell cell;

    /**
     * Creates an excel with provided data and sheet and file names
     *
     * @param fileName
     * @param sheetName
     * @param data
     */
    public void createExcel(String fileName, String sheetName, String... data) throws IOException {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
        if (data != null & data.length > 0)
            for (int i = 0; i < data.length; i++) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(data[i]);
            }
        FileOutputStream out = new FileOutputStream(new File(fileName + ".xls"));
        workbook.write(out);
        out.close();
        System.out.println("Excel written successfully..");


    }


    public Object[][] readExcel(String fileName) throws IOException {
        //  workbook=new HSSFWorkbook();
        FileInputStream file = new FileInputStream(new File("TestXls.xls"));
        workbook = new HSSFWorkbook(file);
        sheet = workbook.getSheetAt(0);
        int totalRows = sheet.getLastRowNum();
        Object[][] data = new Object[totalRows + 1][1];
        for (int i = 0; i < totalRows + 1; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            data[i][0] = cell.getStringCellValue();
        }
        return data;
    }


    public void display(Object[][] obj) {
        for (int i = 0; i < obj.length; i++) {
            Object[] o = obj[i];
            for (int j = 0; j < o.length; j++)
                System.out.println(o[j]);
        }
    }

    public static void main(String[] args) {
        ExcelOps xlOps = new ExcelOps();
        try {
            xlOps.createExcel("TestXls", "test sheet", "iphone", "invalid data");
            xlOps.display(xlOps.readExcel("TestXls"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
