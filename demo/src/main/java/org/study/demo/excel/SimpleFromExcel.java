package org.study.demo.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.study.demo.reflect.ReflectUtil;
import org.study.demo.type.TypeUtil;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class SimpleFromExcel {
    private HSSFWorkbook workbook = null;
    private List<FieldConfig> fieldList;
    private List data;

    public SimpleFromExcel(List<FieldConfig> fieldList, List data) {
        workbook = new HSSFWorkbook();
        this.fieldList = fieldList;
        this.data = data;
    }

    public void genFile(String filename) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HSSFWorkbook createWorkSheet() throws Exception {
        HSSFSheet sheet = workbook.createSheet("数据");
        initTitle(sheet);
        fillData(sheet);
        return workbook;
    }

    private void initTitle(HSSFSheet sheet) {
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);//HSSFColor.VIOLET.index //字体颜色
        font.setBold(true);         //字体增粗
        //把字体应用到当前的样式
        cellStyle.setFont(font);

        for (FieldConfig field : fieldList) {
            HSSFCell cell = row.createCell(field.getColumn());
            cell.setCellValue(field.getTitle());
            cell.setCellStyle(cellStyle);
            int width = field.getWidth() != 0 ? field.getWidth() : 20;
            sheet.setColumnWidth(field.getColumn(), width * 256);
        }
    }

    private void fillData(HSSFSheet sheet) throws Exception {
        for (int i = 0, size = data.size(); i < size; i++) {
            HSSFRow row = sheet.createRow(i + 1);
            Object obj = data.get(i);

            for (FieldConfig fieldConfig : fieldList) {
                Field field = ReflectUtil.getField(fieldConfig.getKey(), obj);
                field.setAccessible(true);
                row.createCell(fieldConfig.getColumn()).setCellValue(TypeUtil.getValue(field.get(obj)));
            }
        }
    }

}
