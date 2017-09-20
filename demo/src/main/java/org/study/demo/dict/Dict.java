package org.study.demo.dict;

import java.io.Serializable;

/**
 * Created by zhiboliu2 on 2017/9/20.
 */
public class Dict implements Serializable{
    private Integer id;
    private String code = "";
    private String name = "";
    private String remark = "";
    private String tableName = "";

    public Dict(){

    }

    public Dict(String code, String name, String remark, String tableName){
        this.code = code;
        this.name = name;
        this.remark = remark;
        this.tableName = tableName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
