package org.study.demo.dict;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.study.demo.excel.FieldConfig;
import org.study.demo.excel.SimpleToExcel;
import org.study.demo.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class DictManTest {
    @Test
    public void getDict(){
        try {
            List<Dict> list = DictMan.getDictList("d_sex");
            System.out.println(JSON.toJSON(list));
            list = DictMan.getDictListQuery("d_sex");
            System.out.println(JSON.toJSON(list));
            list = DictMan.getDictListSel("d_sex");
            System.out.println(JSON.toJSON(list));
            String sex = DictMan.getDict("d_sex", "3").getName();
            System.out.println(sex);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
