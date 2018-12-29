package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.BlogSet;
import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import cn.nnu.jyjs.etpweb.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Project :   etpweb
 * @Time :   9/8/2018 16:08
 * @Auther :   wangj
 * @Description:
 */
@RestController
public class BackstorageController {

    private Logger logger = Logger.getLogger("BlogController");

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    /**
     * get blogs、articles and pages.
     * @param method default required true, include 1.status (select by blogStatus)
     *                                              2.id
     *                                              3.category (String)
     *                                              4.author
     *               if this parameter is blogStatus, blogStatus is needed
     * @param status default required false,
     *                   select article by status : 0 :
     *                                              1 : draft
     *                                              2 : already passed the audit
     *                                              3 : waiting for auditing
     * @param id default required false,
     * @param author default required false,
     * @param category
     * @return
     */
    @RequestMapping(value = "/getArticles.do", method = { RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public List<BlogSet> getArticle(@RequestParam(value = "method") String method,
                                    @RequestParam(value = "status",required = false) Integer status,
                                    @RequestParam(value = "id",required = false) Integer id,
                                    @RequestParam(value = "author",required = false) String author,
                                    @RequestParam(value = "category",required = false) String category){
        List<BlogSet> blogSets = new LinkedList<>();
        List<Blog> blogs;
        Blog blog = blogService.selectById(id);
        User user = userService.selectByName(author);
        logger.info(method);
        switch (method){
            case "status":
                blogSets = blogService.selectGroup();
                break;
            case "id":

                break;
            case "author":
                break;
            case "category":
                break;
        }
        //BlogSet blogSet = new BlogSet(blog,user.getUserName(),
                                //categoryService.getCategory(blog.getBlogCategory()));

        return blogSets;
    }
}
