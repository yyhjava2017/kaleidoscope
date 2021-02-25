package com.endsmok.controller;

import com.common.entity.Result;
import com.endsmok.entity.Article;
import com.endsmok.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @zz yyh
 * @time 2020-08
 */
@RestController
@RequestMapping("/article")
public class ArticleController implements IArticleController{
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @Override
    public Result delete(@PathVariable String id) {
        return articleService.delete(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @Override
    public Result update(@RequestBody Article article) {
        return articleService.update(article);
    }

    @Override
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result addArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    @RequestMapping(value = "/excel",method = RequestMethod.GET)
    public void export(HttpServletResponse response){
        articleService.exportExcel(response);
    }
}
