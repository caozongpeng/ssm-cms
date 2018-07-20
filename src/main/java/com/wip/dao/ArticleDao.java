/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/19 10:31
 **/
package com.wip.dao;

import com.wip.model.Article;
import com.wip.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    /**
     * 获取10条文章
     * @return
     */
    List<Article> getFirst10Article();

    /**
     * 通过文章ID查找文章
     * @param id
     * @return
     */
    Article getArticleById(@Param("id") Long id);

    /**
     * 通过分类ID查找文章
     * @param id
     * @return
     */
    Category getCategoryById(Long id);

    /**
     * 通过分类ID查找文章名
     * @param name
     * @return
     */
    Long getCategoryIdByName(String name);

    /**
     * 通过文章分类ID查找分类名称
     * @param categoryId
     * @return
     */
    List<Article> getArticlesByCategoryName(Long categoryId);

    /**
     * 获取所有的分类
     * @return
     */
    List<Category> getCategories();

    /**
     * 写入文章
     * @param article
     */
    void writeBlog(Article article);

    /**
     * 更新文章
     * @param article
     */
    void updateArticleById(Article article);

    /**
     * 删除文章
     * @param id
     */
    void deleteArticleById(Long id);

    /**
     * 通过标题搜索文章
     * @param keyword
     * @return
     */
    List<Article> findArticleByTitle(String keyword);
}
