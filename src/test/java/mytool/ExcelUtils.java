package mytool;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * All rights Reserved, Designed By Gavin
 *
 * @version V1.0
 * @Title: ExcelUtils.java
 * @Package: com.java
 * @Description: Excel 的常用读操作
 * @author: Gavin
 * @date: 2018年8月5日 上午12:16:38
 * @Copyright: 2018 All rights reserved.
 * @need: poi-3.17.jar poi-ooxml-3.17.jar
 */
public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String fileName, String sheetName) {
        super();

        {
            InputStream inputStream = null;

            try {
                inputStream = new FileInputStream(fileName);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet(sheetName);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 将 Cell 里的内容以 String 形式返回
     *
     * @param rowNum    行的索引，从 0 开始计数
     * @param columnNum 列的索引，从 0 开始计数
     * @return String
     */
    public String getCellforString(int rowNum, int columnNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(columnNum);
        if (cell != null) {
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
        } else {
            return null;
        }
    }

    /**
     * 将 Cell 里的内容以 String 形式返回
     *
     * @param rowNum 行的索引，从 0 开始计数
     * @param str    Sheet页第一行(表头值)的字符串形式
     * @return String
     */
    public String getCellforString(int rowNum, String str) {

        return getCellforString(rowNum, getColumnIndexOfString(0, str));
    }

    /**
     * 获取 Cell 的内容。字符串以 String 返回，非日期格式的数字以 Double 返回，日期格式的数字以 Date 返回，布尔类型以
     * boolean 返回，空值返回 null。
     *
     * @param rowNum    行的索引，从 0 开始计数
     * @param columnNum 列的索引，从 0 开始计数
     * @return String/Double/Date/boolean/null
     */
    public Object getCellValue(int rowNum, int columnNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(columnNum);
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue();
                    } else {
                        return cell.getNumericCellValue();
                    }
                case BOOLEAN:
                    return cell.getBooleanCellValue();
                case BLANK:
                    return null;
                default:
                    return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 获取 Cell 的内容。字符串以 String 返回，非日期格式的数字以 Double 返回，日期格式的数字以 Date 返回，布尔类型以
     * boolean 返回，空值返回 null。
     *
     * @param rowNum 行的索引，从 0 开始计数
     * @param str    Sheet页第一行(表头值)的字符串形式
     * @return String/Double/Date/boolean/null
     */
    public Object getCellValue(int rowNum, String str) {

        return getCellValue(rowNum, getColumnIndexOfString(0, str));
    }

    /**
     * 将sheet的内容以二维数组的形式返回
     *
     * @return Object[][]
     */
    public Object[][] getSheetValue() {
        Object[][] obj = new Object[getRowsNum()][];

        for (int i = 0; i < getRowsNum(); i++) {
            obj[i] = new Object[getColumnsNum(i)];
            for (int j = 0; j < getColumnsNum(i); j++) {
                obj[i][j] = getCellValue(i, j);
            }
        }

        return obj;
    }

    /**
     * 将符合标记条件的行的内容以二维数据返回
     *
     * @param title 标识列的表头
     * @param value 标记条件
     * @return
     */
    public Object[][] getMarkedSheetValue(String title, String value) {

        int needExecute = getColumnIndexOfString(0, title);// 定义标识列的索引

        int startCaseNum = 1;// 定义用例起始行号

        int caseCount = 0; // 定义需要读取行的数量

        for (int i = startCaseNum; i < getRowsNum(); i++) {
            if (getCellValue(i, needExecute) == null
                    || getCellValue(i, needExecute).equals("")
                    || !(getCellValue(i, needExecute) instanceof String)) {
                continue;
            }
            // 判断指定列的值是否与给定的值相等，如果相等则进行计数
            if (getCellValue(i, needExecute).equals(value)) {
                caseCount++;
            }
        }

        Object[][] obj = new Object[caseCount][];
        int k = 0;
        for (int i = startCaseNum; i < getRowsNum(); i++) {
            if (getCellValue(i, needExecute) == null
                    || getCellValue(i, needExecute).equals("")
                    || !(getCellValue(i, needExecute) instanceof String)) {
                continue;
            }

            if (getCellValue(i, needExecute).equals(value)) {
                obj[k] = new Object[getColumnsNum(i)];
                for (int j = 0; j < getColumnsNum(i); j++) {
                    obj[k][j] = getCellValue(i, j);
                }
                k++;
            }
        }

        return obj;
    }

    /**
     * 将符合标记条件的行的内容以二维数据返回
     *
     * @param title 标识列的表头
     * @param value 标记条件
     * @return
     */
    public Object[][] getMarkedSheetValue(String title, int value) {

        int needExecute = getColumnIndexOfString(0, title);// 定义标识列的索引

        int startCaseNum = 1;// 定义用例起始行号

        int caseCount = 0; // 定义需要读取行的数量

        for (int i = startCaseNum; i < getRowsNum(); i++) {
            if (getCellValue(i, needExecute) == null
                    || getCellValue(i, needExecute).equals("")
                    || !(getCellValue(i, needExecute) instanceof Double)) {
                continue;
            }
            // 判断指定列的值是否与给定的值相等，如果相等则进行计数
            if ((int) (double) getCellValue(i, needExecute) == value) {
                caseCount++;
            }
        }

        Object[][] obj = new Object[caseCount][];
        int k = 0;
        for (int i = startCaseNum; i < getRowsNum(); i++) {
            if (getCellValue(i, needExecute) == null
                    || getCellValue(i, needExecute).equals("")
                    || !(getCellValue(i, needExecute) instanceof Double)) {
                continue;
            }

            if ((int) (double) getCellValue(i, needExecute) == value) {
                obj[k] = new Object[getColumnsNum(i)];
                for (int j = 0; j < getColumnsNum(i); j++) {
                    obj[k][j] = getCellValue(i, j);
                }
                k++;
            }
        }

        return obj;
    }

    /**
     * 将符合标记条件的行的内容以二维数据返回
     *
     * @param title 标识列的表头
     * @param value 标记条件
     * @return Object[][]
     */
    public Object[][] getMarkedSheetValue(String title, boolean value) {

        int needExecute = getColumnIndexOfString(0, title);// 定义标识列的索引

        int startCaseNum = 1;// 定义用例起始行号

        int caseCount = 0; // 定义需要读取行的数量

        for (int i = startCaseNum; i < getRowsNum(); i++) {
            if (getCellValue(i, needExecute) == null
                    || getCellValue(i, needExecute).equals("")
                    || !(getCellValue(i, needExecute) instanceof Boolean)) {
                continue;
            }
            // 判断指定列的值是否与给定的值相等，如果相等则进行计数
            if ((boolean) getCellValue(i, needExecute) == value) {
                caseCount++;
            }
        }

        Object[][] obj = new Object[caseCount][];
        int k = 0;
        for (int i = startCaseNum; i < getRowsNum(); i++) {
            if (getCellValue(i, needExecute) == null
                    || getCellValue(i, needExecute).equals("")
                    || !(getCellValue(i, needExecute) instanceof Boolean)) {
                continue;
            }

            if ((boolean) getCellValue(i, needExecute) == value) {
                obj[k] = new Object[getColumnsNum(i)];
                for (int j = 0; j < getColumnsNum(i); j++) {
                    obj[k][j] = getCellValue(i, j);
                }
                k++;
            }
        }

        return obj;
    }

    /**
     * 返回给定字符串在指定行中所在列的索引。索引从 0 开始计数。没有匹配返回 -1。
     *
     * @param rowNum 行的索引，从 0 开始计数
     * @param str    字符串
     * @return 列的索引，从 0 开始计数
     */
    public int getColumnIndexOfString(int rowNum, String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < getColumnsNum(rowNum); i++) {
            list.add(getCellforString(rowNum, i));
        }

        return list.indexOf(str);
    }

    /**
     * 获取行的数量，包括空值的行
     *
     * @return
     */
    public int getRowsNum() {

        return sheet.getLastRowNum() + 1;
    }

    /**
     * 获取行的数量，不包括空值的行
     *
     * @return
     */
    public int getPhysicalRowsNum() {

        return sheet.getPhysicalNumberOfRows();
    }

    /**
     * 获取列的数量，包括空值的列。
     *
     * @param rowNum 行的索引，从 0 开始计数
     * @return
     */
    public int getColumnsNum(int rowNum) {
        Row row = sheet.getRow(rowNum);

        return row.getLastCellNum();
    }

    /**
     * 获取列的数量，不包括空值的列
     *
     * @param rowNum 行的索引，从 0 开始计数
     * @return
     */
    public int getPhysicalColumnsNum(int rowNum) {
        Row row = sheet.getRow(rowNum);

        return row.getPhysicalNumberOfCells();
    }

    /**
     * 释放读取到的 Excel 资源
     */
    public void close() {
        if (workbook != null) {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}