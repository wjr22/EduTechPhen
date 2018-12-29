package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.*;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import cn.nnu.jyjs.etpweb.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Project :   etpweb
 * @Time :   9/23/2018 22:54
 * @Auther :   wangj
 * @Description:
 */
@Controller
public class BlogController {

    private Logger logger = Logger.getLogger("BlogController");

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    /**
     *
     * @param p_title post title
     * @param p_abstract post abstract
     * @param p_category post category
     * @param p_content post content
     * @param method "draft" or "publish" default publish
     * @return
     *      postSuccess html page
     */
    @RequestMapping(value = "/posts")
    public String getPosts(@RequestParam(value = "title") String p_title,
                           @RequestParam(value = "abstract") String p_abstract,
                           @RequestParam(value = "category") String p_category,
                           @RequestParam(value = "content") String p_content,
                           @RequestParam(value = "method", required = false) String method,
                           HttpServletRequest request){
        logger.info(p_content);
        logger.info(request.getSession().getAttribute("userId").toString());
        Blog blog = new Blog(p_title,p_content,p_abstract);
        if(method.equals("draft")) {
            blog.setBlogStatus(1);
        }else{
            blog.setBlogStatus(2);
        }
        blogService.insertBlog(blog, (int)request.getSession().getAttribute("userId"),
                categoryService.getId(p_category));
        return "Success.html";
    }

    @RequestMapping(value = "/audit")
    public String getAudit(@RequestParam(required = true,defaultValue = "1") Integer page,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "15") Integer pageSize,
                           Model model) {
        List<BlogSet> blogSets = blogService.selectByStatus(2);
        int startItem = (page - 1)*15;
        int itemSize = blogSets.size();
        Page pageInfo = new Page(pageSize,itemSize);
        pageInfo.setCurrentPage(page);
        //System.out.println(pageInfo.getCurrentPage());
        //System.out.println(pageInfo.getItemsCount());
        //System.out.println(pageInfo.getPageCount());
        if(pageInfo.isLastPage()) {
            blogSets = blogSets.subList(startItem, itemSize );
        }else {
            blogSets = blogSets.subList(startItem, startItem + 15);
        }
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("blogSet",blogSets);
        return "center/auditTable.html";

    }

    @RequestMapping(value = "/blog")
    public String getPage(@RequestParam(value = "blogId",required = true) Integer blogId,
                          Model model){
        Blog blog = blogService.selectById(blogId);
        User user = userService.selectById(blog.getAuthorId());
        String category = categoryService.getCategory(blog.getBlogCategory());
        model.addAttribute("author",user.getUserName());
        model.addAttribute("authorId",user.getUserId());
        model.addAttribute("category",category);
        model.addAttribute("blog",blog);
        return "page.html";
    }

    /**
     * NOT USE
     * @param page
     * @param category
     * @param request
     * @param model
     * @return

    @RequestMapping(value = "/articles")
    public String getPosts(@RequestParam(required = true,defaultValue = "1") Integer page,
                           @RequestParam(required = false,value = "category") String category,
                           @RequestParam(required = false,value = "mod") String mod,
                           HttpServletRequest request,
                           Model model){
        List<Blog> blogs = null;
        if(category != null) {
            int id = categoryService.getId(category);
            PageHelper.startPage(page,15);
            blogs = blogService.selectByCategory(id);
            logger.info("category id is "+id+" and blogs num is "+blogs.size());
        }else{
            PageHelper.startPage(page,15);
            blogs = blogService.selectAll();
            logger.info("blogs num is "+blogs.size());
        }
        PageInfo<Blog> pageInfo = pageInfo = new PageInfo<Blog>(blogs);;
        if(blogs != null && pageInfo != null) {
            model.addAttribute("page", pageInfo);
            model.addAttribute("blogs", blogs);
        }else{
            model.addAttribute("msg","NET_ERROR");
        }
        return "list.html";
    }
     */
}

