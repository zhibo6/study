package org.study.demo.excel;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.study.demo.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class SimpleFromExcelTest {
    @Test
    public void getData(){
        try {
            String filename = "c:\\a.xls";
            List<FieldConfig> fieldList = new ArrayList<>();


            fieldList.add(new FieldConfig("姓名", "name", 0, 20));
            fieldList.add(new FieldConfig("性别", "sex", 1, 20));
            fieldList.add(new FieldConfig("年龄", "age", 2, 20));
            fieldList.add(new FieldConfig("生日", "birthday", 3, 20));

            List<User> data = new ArrayList();
//            Date birthday = new Date();
//            data.add(new User("张三", "男", 30, birthday));
//            data.add(new User("李四", "男", 30, birthday));
//            data.add(new User("王五", "男", 30, birthday));
            SimpleFromExcel sfe = new SimpleFromExcel(filename, fieldList);
            sfe.initWorkbook();
            data = sfe.readData(User.class);
            for(User user : data){
                System.out.println(JSON.toJSON(user));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
