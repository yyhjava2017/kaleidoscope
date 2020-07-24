package com.user.dao;

import com.base.dao.BaseDao;
import com.common.constant.TableName;
import com.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @zz yyh
 * @time 2020-07
 */
@Repository
public interface UserMapper extends BaseDao {

    @Select("<script>" +
            "select * from "+ TableName.YINY_USER +""+
            " where 1=1 " +
            "<if test='name!=null and pageSize !=\"\"' >" +
            "and name like '${name}'" +
            "</if>"+
            "</script>")
    List<UserEntity> queryUsers(@Param("name")String name);

    void deleteById(String id);
}
