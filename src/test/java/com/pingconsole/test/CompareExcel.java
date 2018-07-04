package com.pingconsole.test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;

import static org.apache.poi.ss.usermodel.CellType.BLANK;

public class CompareExcel {

    public static void main(String[] args) {
        try {
            // get input excel files
            FileInputStream excellFile1 = new FileInputStream(new File(
                    "/Users/saurabhverma/Desktop/test1.xls"));
            FileInputStream excellFile2 = new FileInputStream(new File(
                    "/Users/saurabhverma/Desktop/test2.xls"));

            // Create Workbook instance holding reference to .xlsx file
            HSSFWorkbook workbook1 = new HSSFWorkbook(excellFile1);
            HSSFWorkbook workbook2 = new HSSFWorkbook(excellFile2);

            // Get first/desired sheet from the workbook
            HSSFSheet sheet1 = workbook1.getSheetAt(0);
            HSSFSheet sheet2 = workbook2.getSheetAt(0);

            // Compare sheets
            if (compareTwoSheets(sheet1, sheet2)) {
                System.out.println("\n\nThe two excel sheets are Equal");
            } else {
                System.out.println("\n\nThe two excel sheets are Not Equal");
            }

            //close files
            excellFile1.close();
            excellFile2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // Compare Two Sheets
    private static boolean compareTwoSheets(HSSFSheet sheet1, HSSFSheet sheet2) {
        int firstRow1 = sheet1.getFirstRowNum();
        int lastRow1 = sheet1.getLastRowNum();
        boolean equalSheets = true;
        for (int i = firstRow1; i <= lastRow1; i++) {

            System.out.println("\n\nComparing Row " + i);

            HSSFRow row1 = sheet1.getRow(i);
            HSSFRow row2 = sheet2.getRow(i);
            if (!compareTwoRows(row1, row2)) {
                equalSheets = false;
                System.out.println("Row " + i + " - Not Equal");
                break;
            } else {
                System.out.println("Row " + i + " - Equal");
            }
        }
        return equalSheets;
    }

    // Compare Two Rows
    private static boolean compareTwoRows(HSSFRow row1, HSSFRow row2) {
        if ((row1 == null) && (row2 == null)) {
            return true;
        } else if ((row1 == null) || (row2 == null)) {
            return false;
        }

        int firstCell1 = row1.getFirstCellNum();
        int lastCell1 = row1.getLastCellNum();
        boolean equalRows = true;

        // Compare all cells in a row
        for (int i = firstCell1; i <= lastCell1; i++) {
            HSSFCell cell1 = row1.getCell(i);
            HSSFCell cell2 = row2.getCell(i);
            if (!compareTwoCells(cell1, cell2)) {
                equalRows = false;
                System.err.println("       Cell " + i + " - NOt Equal");
                break;
            } else {
                System.out.println("       Cell " + i + " - Equal");
            }
        }
        return equalRows;
    }

    // Compare Two Cells
    private static boolean compareTwoCells(HSSFCell cell1, HSSFCell cell2) {
        if ((cell1 == null) && (cell2 == null)) {
            return true;
        } else if ((cell1 == null) || (cell2 == null)) {
            return false;
        }

        boolean equalCells = false;
        CellType type1 = cell1.getCellTypeEnum();
        CellType type2 = cell2.getCellTypeEnum();
        if (type1 == type2) {
            if (cell1.getCellStyle().equals(cell2.getCellStyle())) {
                // Compare cells based on its type
                switch (cell1.getCellTypeEnum()) {
                    case FORMULA:
                        if (cell1.getCellFormula().equals(cell2.getCellFormula())) {
                            equalCells = true;
                        }
                        break;
                    case NUMERIC:
                        if (cell1.getNumericCellValue() == cell2
                                .getNumericCellValue()) {
                            equalCells = true;
                        }
                        break;
                    case STRING:
                        if (cell1.getStringCellValue().equals(cell2
                                .getStringCellValue())) {
                            equalCells = true;
                        }
                        break;
                    case BLANK:
                        if (cell2.getCellTypeEnum() == BLANK) {
                            equalCells = true;
                        }
                        break;
                    case BOOLEAN:
                        if (cell1.getBooleanCellValue() == cell2
                                .getBooleanCellValue()) {
                            equalCells = true;
                        }
                        break;
                    case ERROR:
                        if (cell1.getErrorCellValue() == cell2.getErrorCellValue()) {
                            equalCells = true;
                        }
                        break;
                    default:
                        if (cell1.getStringCellValue().equals(
                                cell2.getStringCellValue())) {
                            equalCells = true;
                        }
                        break;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return equalCells;
    }
}
