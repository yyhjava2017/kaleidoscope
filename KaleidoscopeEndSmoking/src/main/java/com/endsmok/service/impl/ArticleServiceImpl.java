package com.endsmok.service.impl;


import com.base.constant.TableName;
import com.base.entity.Result;
import com.base.entity.StatusCode;
import com.endsmok.dao.ArticleMapper;
import com.endsmok.entity.Article;
import com.endsmok.entity.TestVO;
import com.endsmok.service.ArticleService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * @zz yyh
 * @time 2020-08
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result delete(String id) {
        articleMapper.delete(id);
        return new Result(StatusCode.SUCCESS,"success","删除成功",null);

    }

    @Override
    public Result update(Article article) {
        articleMapper.update(article);
        return new Result(StatusCode.SUCCESS,"success","更新成功",null);

    }

    @Override
    public Result save(Article article){
        articleMapper.save(article, TableName.YINY_ARTICLE);
        return new Result(StatusCode.SUCCESS,"success","保存成功",null);
    }

    @Transactional
    @Override
    public void exportExcel(HttpServletResponse response) {
        Cursor<TestVO> cursor = articleMapper.getTestList();
        Iterator<TestVO> iterator = cursor.iterator();
        while(iterator.hasNext()){
            TestVO vo = iterator.next();
            System.out.println(vo.getV1());
        }
    }
}
