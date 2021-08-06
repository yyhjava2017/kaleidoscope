package com.user.dao;

import com.base.constant.TableName;
import com.base.dao.BaseDao;
import login.entity.LoginBO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import user.entity.UserEntity;

import java.util.List;

/**
 * @zz yyh
 * @time 2020-07
 */
public interface UserMapper extends BaseDao {

    @Select("<script>" +
            "select * from "+ TableName.YINY_USER +""+
            " where 1=1 " +
            "<if test='name!=null and pageSize !=\"\"' >" +
            "and name like '${name}'" +
            "</if>"+
            "</script>")
    List<UserEntity> queryUsers(@Param("name")String name);

    @Delete("delete from "+ TableName.YINY_USER +" where id = #{id}")
    void deleteById(String id);

    @Update("<script>" +
            "update yiny_user set name=#{name},age=#{age},o_id=#{oid},login_name=#{loginName}," +
            "password=#{password},mobile=#{mobile},email=#{email},gen_Time=#{genTime}," +
            "last_Login_Time=#{lastLoginTime},count=#{count}" +
            "</script>" )
    void update(UserEntity userEntity);


    @Select("<script>" +
            "select * from "+ TableName.YINY_USER +""+
            " where 1=1 " +
            "<if test='loginName!=null and loginName !=\"\"' >" +
            "and loginName = #{loginName}" +
            "</if>"+
            "<if test='password!=null and password !=\"\"' >" +
            "and password = #{password}" +
            "</if>"+
            "</script>")
    UserEntity login(LoginBO bo);
}
