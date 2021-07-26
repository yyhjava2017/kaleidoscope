package com.base.utils;



import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelToSql {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("d://test.xlsx"));
            fileOutputStream = new FileOutputStream(new File("d://test.sql"));
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFRow row = sheet.getRow(1);//获取第二行
            int numMergedRegions = sheet.getNumMergedRegions();
            for (int i = 0; i < numMergedRegions; i = i + 5) {
                CellRangeAddress ca = sheet.getMergedRegion(i);//获取第一列合并单元
                int firstRow = ca.getFirstRow();
                int lastRow = ca.getLastRow();
                String sql = getItem(sheet, firstRow, lastRow);
                fileOutputStream.write(sql.getBytes());
                fileOutputStream.write(";\r\n".getBytes());
                fileOutputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }

    private static String getItem(XSSFSheet sheet, int firstRow, int lastRow) {
        XSSFRow row = sheet.getRow(firstRow);
        XSSFCell cell = row.getCell(2);//获取表名
        StringBuilder sb = new StringBuilder();
        String tableName = cell.getStringCellValue();
        sb.append("create table " + tableName + " (");
        for (int i = firstRow; i <= lastRow; i++){
            XSSFRow tRow = sheet.getRow(i);
            String column = tRow.getCell(5).getStringCellValue();
            sb.append(" "+column+" String");
            String comment = tRow.getCell(6).getStringCellValue();
            if(comment!=null&&!"".equals(comment)&&!"".equals(comment.trim())){
                sb.append(" comment '"+comment+"' ");
            }
            if(i!=lastRow){
                sb.append(",");
            }
        }
            sb.append(")");
        return sb.toString();
    }

}
