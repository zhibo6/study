package org.study.demo.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiboliu2 on 2017/9/20.
 */
public class DictMan {
    private final static Map<String, List<Dict>> dictMap = new HashMap<>();

    public static Dict getDict(String tableName, String code){
        Map<String, Dict> map = getDictMap(tableName);
        if(map == null){
            return null;
        }
        Dict dict = map.get(code);
        return dict == null ? new Dict() : dict;
    }
    public static String getDictName(String tableName, String code){
        return getDict(tableName, code).getName();
    }
    public static List<Dict> getDictList(String tableName){
        List<Dict> list = dictMap.get(tableName);
        if(list == null){
            list = new ArrayList<Dict>();
            list.add(new Dict("1","男","男","d_sex"));
            list.add(new Dict("2","女","女","d_sex"));
            dictMap.put(tableName, list);

            if(list == null){
                list = new ArrayList<Dict>();
            }
        }
        return list;
    }

    public static Map<String, Dict> getDictMap(String tableName){
        List<Dict> list = getDictList(tableName);
        if (list == null)
            return null;
        Map<String, Dict> map = new HashMap();
        for (int i = 0; i < list.size(); ++i) {
            Dict dict = list.get(i);
            map.put(dict.getCode(), dict);
        }
        return map;
    }


    public static List<Dict> getDictListQuery(String tableName){
        List<Dict> list = new ArrayList<>();
        list.add(new Dict("", "全部", "", ""));
        list.addAll(getDictList(tableName));
        return list;
    }
    public static List<Dict> getDictListSel(String tableName){
        List<Dict> list = new ArrayList<>();
        list.add(new Dict("", "请选择", "", ""));
        list.addAll(getDictList(tableName));
        return list;
    }
}
