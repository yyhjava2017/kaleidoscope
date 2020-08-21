package com.endsmok.service;

import com.common.entity.Result;
import com.endsmok.entity.Article;

/**
 * @zz yyh
 * @time 2020-08
 */
public interface ArticleService {
    Result save(Article article);

    Result delete(String id);

    Result update(Article article);
}
