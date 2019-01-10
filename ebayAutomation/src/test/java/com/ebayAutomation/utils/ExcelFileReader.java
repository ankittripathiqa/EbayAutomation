package com.ebayAutomation.utils;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class ExcelFileReader {

    private static final Map<String, Workbook> workbookMap = new HashMap<String, Workbook>();

    public static String getCellValue(String fileName, String sheetName, int rowNum, String columnName) {
        Workbook workbook = workbookMap.get("fileName");
        try {
            if (workbook == null) {
                workbook = WorkbookFactory.create(new FileInputStream(System.getProperty("user.dir")+ "/Data/"+fileName));
                workbookMap.put(fileName, workbook);
            }
            Sheet sheet = workbook.getSheet(sheetName);
            Cell cell = sheet.getRow(rowNum - 1).getCell(CellReference.convertColStringToIndex(columnName));
            if(cell != null)
                return readCellByType(cell, cell.getCellTypeEnum());
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    private static String readCellByType(Cell cell, CellType type) {
        String txt = "";
        if (cell != null) {
            switch (type) {
                case NUMERIC:
                    txt = dateOrNumberProcessing(cell);
                    break;
                case STRING:
                    txt = String.valueOf(cell.getRichStringCellValue());
                    break;
                case FORMULA:
                    txt = readCellByType(cell, cell.getCachedFormulaResultTypeEnum());
                    break;
                case BLANK:
                    break;
                default:
                    break;
            }
        }
        return txt;
    }

    private static String dateOrNumberProcessing(Cell cell) {
        String txt;
        if (DateUtil.isCellDateFormatted(cell)) {
            final DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            txt = String.valueOf(formatter.format(cell.getDateCellValue()));
        } else {
            txt = String.valueOf(cell.getNumericCellValue());
        }
        return txt;
    }

    public static void main(String[] args) {
        System.out.println(ExcelFileReader.getCellValue("Login.xlsx","LoginUser",2, "A"));
    }
}
