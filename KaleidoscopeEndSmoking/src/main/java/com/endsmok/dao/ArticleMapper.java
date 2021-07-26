package com.endsmok.dao;

import com.base.constant.TableName;
import com.base.dao.BaseDao;

import com.endsmok.entity.Article;
import com.endsmok.entity.TestVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

/**
 * @zz yyh
 * @time 2020-08
 */
@Repository
public interface ArticleMapper extends BaseDao {
    @Delete("delete from "+ TableName.YINY_ARTICLE +" where id = #{id}")
    void delete(String id);

    @Update("update "+TableName.YINY_ARTICLE+" set title = #{title},author = #{author}," +
            "intro = #{intro},create_time=#{createTime},update_Time=#{updateTime}," +
            "read_Num = #{readNum},comment_Num=#{commentNum},star_Num=#{starNum},content=#{content}" +
            " where id = #{id}")
    void update(Article article);

    @Select("select * from t_test_v")
    @Options(fetchSize = Integer.MIN_VALUE)
    Cursor<TestVO> getTestList();
}
