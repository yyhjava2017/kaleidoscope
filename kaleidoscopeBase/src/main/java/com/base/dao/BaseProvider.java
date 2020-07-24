package com.base.dao;

import com.base.utils.ReflectionUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @zz yyh
 * @time 2020-07
 */
public class BaseProvider {

    public String  save(Map<String,Object> map){
        Object obj = map.get("obj");
        String table = (String) map.get("table");
        SQL sql = null;
        try {
            Map<String, Object> map1 = ReflectionUtils.getFiledsStr(obj);
            final String names = (String)map1.get("fname");
            final String values = (String)map1.get("fvalue");
            sql = new SQL(){
                {
                    INSERT_INTO(table);
                    VALUES(names,values);
                }
            };
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(sql.toString());
        return sql.toString();
    }
}
