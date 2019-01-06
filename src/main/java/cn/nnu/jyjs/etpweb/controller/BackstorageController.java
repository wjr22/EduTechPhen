package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.BlogSet;
import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Constant;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static cn.nnu.jyjs.etpweb.utils.Constant.STATUS_AUDIT;

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
     *                   select article by status : 0(draft) : draft
     *                                              1(passed) : already passed the audit
     *                                              2(audit) : waiting for auditing
     *                                              3(notpassed) : audit not pass
     * @param id default required false,
     * @param author default required false,
     * @param category
     * @return
     */
    @RequestMapping(value = "/getArticles.do", method = { RequestMethod.GET }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getArticle(@RequestParam(value = "method") String method,
                             @RequestParam(value = "status", required = false) String status,
                             @RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "author", required = false) String author,
                             @RequestParam(value = "category", required = false) String category) {
        List<BlogSet> blogSets = new LinkedList<>();
        boolean result = true;
        Map<String, Object> json = new LinkedHashMap<>();
        logger.info(method);
        switch (method){
            case "status":
                if (status == null) {
                    result = false;
                } else {
                    blogSets = blogService.selectByStatus(getStatus(status));
                }
                break;
            case "id":
                if (id == null) {
                    result = false;
                } else {
                    blogSets.add(blogService.selectByBlogId(id));
                }
                break;
            case "author":
                if (author == null) {
                    result = false;
                } else {
                    blogSets = blogService.selectByUserId(userService.selectByName(author).getUserId());
                }
                break;
            case "category":
                if (category == null) {
                    result = false;
                } else {
                    blogSets = blogService.selectByCategory(category);
                }
                break;
        }
        json.put("result", result);
        if (result) {
            json.put("data", blogSets);
        }
        //BlogSet blogSet = new BlogSet(blog,user.getUserName(),
                                //categoryService.getCategory(blog.getBlogCategory()));
        String toJson = JSONArray.toJSONString(json);
        return toJson;
    }

    private Integer getStatus(String str_status) {
        int tag = -1;
        switch (str_status) {
            case "draft":
                tag = 0;
                break;
            case "post":
                tag = 1;
                break;
            case "notpost":
                tag = 3;
                break;
            case "audit":
                tag = 2;
                break;
        }
        if (tag != -1) {
            return tag;
        }
        return -1;
    }
}
