/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/19 9:40
 **/
package com.wip.controller;

import com.wip.model.Article;
import com.wip.model.Category;
import com.wip.model.User;
import com.wip.service.ArticleService;
import com.wip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

@Controller
public class ArticleController {

    @Resource
    ArticleService articleService;

    @Resource
    UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model){
        List<Article> articleList =  articleService.getFirst10Article();
        for (Article article : articleList){
            System.out.println(article);
        }
        model.addAttribute("articles", articleList);
        return "views/index";
    }

    @RequestMapping(value = "/detail/{id}/{category}")
    public String detail(@PathVariable("id") Long id, Model model){
        Article article = articleService.getArticleById(id);
        System.out.println(article.getContent());
        Markdown markdown = new Markdown();
        try {
            StringWriter out = new StringWriter();
            markdown.transform(new StringReader(article.getContent()),out);
            out.flush();
            article.setContent(out.toString());
            System.out.println("------------------");
            System.out.println(article.getContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("article",article);
        return "views/detail";
    }

    @RequestMapping(value = "/column/{displayName}/{category}")
    public String column(@PathVariable("category") String category, Model model,@PathVariable("displayName") String displayName){
        model.addAttribute("articles", articleService.getArticleByCategoryName(category));
        model.addAttribute("displayName",displayName);
        return "views/columnPage";
    }

    @RequestMapping(value = "/admin")
    public String admin(Model model) {
        model.addAttribute("articles",articleService.getFirst10Article());
        return "admin/index";
    }

    @RequestMapping(value = "/admin/login")
    public String login() {
        return "admin/login";
    }


    @RequestMapping(value = "/admin/dologin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, User user, Model model) {
        System.out.println("user.getUsername():" + user.getUsername() + ";user.getPassword()" + user.getPassword());
        if (userService.login(user.getUsername(),user.getPassword())) {
            request.getSession().setAttribute("user",user);
            model.addAttribute("user",user);
            return "redirect:/admin";
        } else {
            model.addAttribute("error","用户名或密码错误");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/admin/write")
    public String write(Model model) {
        List<Category> categories = articleService.getCategories();
        categories.remove(0);
        model.addAttribute("categories",categories);
        return "admin/article";
    }

    @RequestMapping(value = "/admin/write",method = RequestMethod.POST)
    public String write(Article article) {
        if (article.getId() == 0) {
            if ("".equals(article.getCategory())) {
                article.setCategory("webPage");
            }
            System.out.println(article);
            articleService.writeBlog(article);
        } else {
            articleService.updateBlog(article);
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article",article);

        List<Category> categories = articleService.getCategories();
        categories.remove(0);
        model.addAttribute("categories",categories);
        return "admin/article";
    }

    @RequestMapping(value = "/admin/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Article> articles = articleService.findArticleByTitle(keyword);
        model.addAttribute("articles", articles);
        return "views/index";
    }

    

}
