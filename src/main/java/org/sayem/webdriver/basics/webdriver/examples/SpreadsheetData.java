package org.sayem.webdriver.basics.webdriver.examples;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SpreadsheetData {

    private transient Collection<Object[]> data = null;

    public SpreadsheetData(final InputStream excelInputStream) throws IOException, InvalidFormatException {
        this.data = loadFromSpreadsheet(excelInputStream);
    }

    public Collection<Object[]> getData() {
        return data;
    }

    private Collection<Object[]> loadFromSpreadsheet(final InputStream excelFile)
            throws IOException, InvalidFormatException {

        Workbook workbook = WorkbookFactory.create(excelFile);

        data = new ArrayList<Object[]>();
        Sheet sheet = workbook.getSheetAt(0);

        int numberOfColumns = countNonEmptyColumns(sheet);
        List<Object[]> rows = new ArrayList<Object[]>();
        List<Object> rowData = new ArrayList<Object>();

        for (Row row : sheet) {
            if (isEmpty(row)) {
                break;
            } else {
                if (row.getRowNum() != 0) //Row 0 will be Header Row
                {
                    rowData.clear();
                    for (int column = 0; column < numberOfColumns; column++) {
                        Cell cell = row.getCell(column);
                        rowData.add(objectFrom(workbook, cell));
                    }
                    rows.add(rowData.toArray());
                }
            }
        }
        return rows;
    }

    private boolean isEmpty(final Row row) {
        Cell firstCell = row.getCell(0);
        boolean rowIsEmpty = (firstCell == null)
                || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
        return rowIsEmpty;
    }

    /**
     * Count the number of columns, using the number of non-empty cells in the
     * first row.
     */
    private int countNonEmptyColumns(final Sheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstEmptyCellPosition(firstRow);
    }

    private int firstEmptyCellPosition(final Row cells) {
        int columnCount = 0;
        for (Cell cell : cells) {
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                break;
            }
            columnCount++;
        }
        return columnCount;
    }

    private Object objectFrom(final Workbook workbook, final Cell cell) {
        Object cellValue = null;

        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getRichStringCellValue().getString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cellValue = getNumericCellValue(cell);
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = cell.getBooleanCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            cellValue = evaluateCellFormula(workbook, cell);
        }

        return cellValue;

    }

    private Object getNumericCellValue(final Cell cell) {
        Object cellValue;
        if (DateUtil.isCellDateFormatted(cell)) {
            cellValue = new Date(cell.getDateCellValue().getTime());
        } else {
            cellValue = cell.getNumericCellValue();
        }
        return cellValue;
    }

    private Object evaluateCellFormula(final Workbook workbook, final Cell cell) {
        FormulaEvaluator evaluator = workbook.getCreationHelper()
                .createFormulaEvaluator();
        CellValue cellValue = evaluator.evaluate(cell);
        Object result = null;

        if (cellValue.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            result = cellValue.getBooleanValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            result = cellValue.getNumberValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
            result = cellValue.getStringValue();
        }

        return result;
    }
}