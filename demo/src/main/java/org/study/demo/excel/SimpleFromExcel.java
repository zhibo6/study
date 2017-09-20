package org.study.demo.excel;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.study.demo.reflect.ReflectUtil;
import org.study.demo.type.TypeUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class SimpleFromExcel {
    private HSSFWorkbook workbook = null;
    private List<FieldConfig> fieldList;
    private List data;
    private String filename = "";

    public SimpleFromExcel(String filename, List<FieldConfig> fieldList) {
        this.filename = filename;
        this.fieldList = fieldList;
    }

    public void initWorkbook() {
        FileInputStream fis = null;
        POIFSFileSystem pfs = null;
        try {
            fis = new FileInputStream(new File(filename));
            pfs = new POIFSFileSystem(fis);
            workbook = new HSSFWorkbook(pfs);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fis);
        }
    }

    public <T> List<T> readData(Class<T> c) {
        List<T> data = new ArrayList<>();
        try {
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();

            HSSFRow row = sheet.getRow(0);
            int colNum = row.getPhysicalNumberOfCells();

            // 正文内容应该从第二行开始,第一行为表头的标题
            for (int i = 1; i < rowNum; i++) {
                row = sheet.getRow(i);
                T obj = c.newInstance();

                for (FieldConfig fieldConfig : fieldList) {
                    Field field = ReflectUtil.getField(fieldConfig.getKey(), obj);
                    field.setAccessible(true);
                    Class cls = field.getType();
                    String val = getStringCellValue(row.getCell((short) fieldConfig.getColumn())).trim();
                    if(cls == Integer.class){
                        field.set(obj, Integer.valueOf(val));
                    } else if(cls == String.class){
                        field.set(obj, String.valueOf(val));
                    } else if(cls == Double.class){
                        field.set(obj, Double.valueOf(val));
                    } else if(cls == Float.class){
                        field.set(obj, Float.valueOf(val));
                    } else if(cls == Long.class){
                        field.set(obj, Long.valueOf(val));
                    } else if(cls == Boolean.class){
                        field.set(obj, Boolean.valueOf(val));
                    } else if(cls == Date.class){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        field.set(obj, sdf.parse(val));
                    } else {
                        field.set(obj, val);
                    }
                }

                data.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 读取Excel表格表头的内容
     */
    public String[] readTitle() {
        String[] titleArr = null;
        try {
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row = sheet.getRow(0);
            // 标题总列数
            int colNum = row.getPhysicalNumberOfCells();
            System.out.println("colNum:" + colNum);
            titleArr = new String[colNum];
            for (int i = 0; i < colNum; i++) {
                titleArr[i] = getStringCellValue(row.getCell((short) i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return titleArr;
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

}
