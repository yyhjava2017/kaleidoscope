package com.base.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

/**
 * @zz yyh
 * @time 2020-07
 */
public interface BaseDao {
    @InsertProvider(type = BaseProvider.class, method = "save")
    void save(@Param("obj") Object obj, @Param("table") String table);
}
