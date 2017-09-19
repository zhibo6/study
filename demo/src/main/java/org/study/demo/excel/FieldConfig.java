package org.study.demo.excel;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class FieldConfig {
    /**
     * 标题
     */
    private String title;
    /**
     * 数据对象的属性名
     */
    private String key;

    /**
     * 该field所在列，从0开始
     */
    private int column;

    /**
     *
     * 每列宽度
     */
    private int width;

    public FieldConfig(String title, String key, int column, int width){
        this.title = title;
        this.key = key;
        this.width = width;
        this.column = column;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
