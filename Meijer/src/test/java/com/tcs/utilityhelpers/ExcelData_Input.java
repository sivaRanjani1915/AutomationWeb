package com.tcs.utilityhelpers;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class ExcelData_Input {

    public static XSSFWorkbook excelworkbook;
    public static XSSFSheet excelsheet;
    public static XSSFRow excelrow;
    public static XSSFCell excelcell;
    public static FileInputStream filehw;
    public static POIFSFileSystem myFileSystem1;
    public static Vector cellVectorhw = new Vector();
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fis;
    public static POIFSFileSystem myFileSystem;
    public static Vector cellVectorHolder = new Vector();
    //static String fileName = "C:\\Users\\106623\\Documents\\Excel_DATA\\myExcelData.xlsx";
    static String excelfileName = "./datasource/Nutridev.xlsx";
    static String fileName = "C:\\Users\\106623\\Documents\\Excel_DATA\\myExcelData.xlsx";
    //static String fileName = "./datasource/NutricertQA.xlsx";
    
    public static Vector read_1Column_XLSXFile() throws IOException {
        fis = new FileInputStream(fileName);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("myData");
        Iterator rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            row = (XSSFRow) rowIter.next();
            Vector cellStoreVector = new Vector();
            cell = row.getCell(1);
            cellStoreVector.addElement(cell);
            cellVectorHolder.addElement(cellStoreVector);
        }
        return cellVectorHolder;
    }

    public static Vector read_XLSXFile() throws IOException {
        fis = new FileInputStream(fileName);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("myData");
        Iterator rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            row = (XSSFRow) rowIter.next();
            Iterator cellIter = row.cellIterator();
            Vector cellStoreVector = new Vector();
            while (cellIter.hasNext()) {
                cell = (XSSFCell) cellIter.next();
                cellStoreVector.addElement(cell);
                cellVectorHolder.addElement(cellStoreVector);
            }
        }
        return cellVectorHolder;
    }

    public static Vector read_2Column_XLSXFile() throws IOException {
        fis = new FileInputStream(fileName);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("StoreList");
        Iterator rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            row = (XSSFRow) rowIter.next();
            Vector cellStoreVector = new Vector();
            cell = row.getCell(0);
            cellStoreVector.addElement(cell);
            cellVectorHolder.addElement(cellStoreVector);
            cell = row.getCell(1);
            cellStoreVector.addElement(cell);
            cellVectorHolder.addElement(cellStoreVector);
        }
        return cellVectorHolder;
    }

    public static Vector read_Column_HWFile() throws IOException {
        filehw = new FileInputStream(excelfileName);
        excelworkbook = new XSSFWorkbook(filehw);
        excelsheet = excelworkbook.getSheet("sheet1");
        Iterator rowIter = excelsheet.rowIterator();
        while (rowIter.hasNext()) {
            excelrow = (XSSFRow) rowIter.next();
            Vector cellStoreVector = new Vector();
            excelcell = excelrow.getCell(0);
            cellStoreVector.addElement(excelcell);
            cellVectorhw.addElement(cellStoreVector);
            excelcell = excelrow.getCell(1);
            cellStoreVector.addElement(excelcell);
            cellVectorhw.addElement(cellStoreVector);
            excelcell = excelrow.getCell(2);
            cellStoreVector.addElement(excelcell);
            cellVectorhw.addElement(cellStoreVector);
        }
        return cellVectorhw;
    }
    


}
