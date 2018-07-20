/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/19 10:34
 **/
package com.wip.service;

import com.wip.dao.ArticleDao;
import com.wip.model.Article;
import com.wip.model.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    private ArticleDao articleDao;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm");


    public List<Article> getFirst10Article() {
        return articleDao.getFirst10Article();
    }

    public Article getArticleById(Long id) {
        Article article = articleDao.getArticleById(id);
        article.setCategory(articleDao.getCategoryById(article.getCategoryId()).getDisplayName());
        return article;
    }


    public List<Article> getArticleByCategoryName(String name) {
        Long categoryId = articleDao.getCategoryIdByName(name);
        List<Article> articles = articleDao.getArticlesByCategoryName(categoryId);
        return articles;
    }

    public List<Category> getCategories() {
        return articleDao.getCategories();
    }

    public void writeBlog(Article article) {
        Long categoryId = articleDao.getCategoryIdByName(article.getCategory());
        article.setCategoryId(categoryId);
        article.setDate(sdf.format(new Date()));
        if (article.getSummary() == null || "".equals(article.getSummary())) {
            if (article.getContent().length() > 20) {
                article.setSummary(article.getContent().substring(0,20));
            } else {
                article.setSummary(article.getContent().substring(0,article.getContent().length()));
            }
        }
        articleDao.writeBlog(article);
    }

    public void updateBlog(Article article) {
        article.setDate(sdf.format(new Date()));
        if (article.getSummary() == null || "".equals(article.getSummary())) {
            if (article.getContent().length() > 20) {
                article.setSummary(article.getContent().substring(0,20));
            } else {
                article.setSummary(article.getContent().substring(0,article.getContent().length()));
            }
        }
        articleDao.updateArticleById(article);
    }

    public void deleteArticleById(Long id) {
        articleDao.deleteArticleById(id);
    }

    public List<Article> findArticleByTitle(String keyword) {
        return articleDao.findArticleByTitle(keyword);
    }
}
