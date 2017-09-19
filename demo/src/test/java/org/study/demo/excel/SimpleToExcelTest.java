package org.study.demo.excel;

import org.junit.Test;
import org.study.demo.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class SimpleToExcelTest {
    @Test
    public void genFile(){
        try {
            String filename = "c:\\a.xls";
            List<FieldConfig> fieldList = new ArrayList<>();
            List data = new ArrayList();

            fieldList.add(new FieldConfig("姓名", "name", 0, 20));
            fieldList.add(new FieldConfig("性别", "sex", 1, 20));
            fieldList.add(new FieldConfig("年龄", "age", 2, 20));
            fieldList.add(new FieldConfig("生日", "birthday", 3, 20));

            Date birthday = new Date();
            data.add(new User("张三", "男", 30, birthday));
            data.add(new User("李四", "男", 30, birthday));
            data.add(new User("王五", "男", 30, birthday));
            SimpleToExcel ste = new SimpleToExcel(fieldList, data);
            ste.createWorkSheet();
            ste.genFile(filename);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
