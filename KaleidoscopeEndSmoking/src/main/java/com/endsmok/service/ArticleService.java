package com.endsmok.service;

import com.common.entity.Result;
import com.endsmok.entity.Article;

import javax.servlet.http.HttpServletResponse;

/**
 * @zz yyh
 * @time 2020-08
 */
public interface ArticleService {
    Result save(Article article);

    Result delete(String id);

    Result update(Article article);

    void exportExcel(HttpServletResponse response);
}
