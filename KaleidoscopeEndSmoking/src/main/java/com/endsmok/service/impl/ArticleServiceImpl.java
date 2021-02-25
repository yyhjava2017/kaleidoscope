package com.endsmok.service.impl;

import com.common.constant.TableName;
import com.common.entity.Result;
import com.common.entity.StatusCode;
import com.common.util.ExcelUtils;
import com.endsmok.dao.ArticleMapper;
import com.endsmok.entity.Article;
import com.endsmok.entity.TestVO;
import com.endsmok.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Override
    public void exportExcel(HttpServletResponse response) {
        List list = articleMapper.getTestList();
        ExcelUtils.writeExcelWithName(response,list, TestVO.class,"hello");
    }
}
