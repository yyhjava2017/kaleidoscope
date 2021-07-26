package com.endsmok.controller;

import com.base.entity.Result;
import com.endsmok.entity.Article;

/**
 * @zz yyh
 * @time 2020-08
 */
public interface IArticleController {

    Result addArticle(Article article);
    Result delete(String id);
    Result update(Article article);
}
