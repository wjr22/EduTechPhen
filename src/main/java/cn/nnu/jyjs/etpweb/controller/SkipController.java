package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.BlogSet;
import cn.nnu.jyjs.etpweb.bean.Message;
import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.MessageService;
import cn.nnu.jyjs.etpweb.service.UserService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Project :   etpweb
 * @Time :   9/9/2018 14:04
 * @Auther :   wangj
 * @Description:
 */
@Controller
public class SkipController {

    private Logger logger = Logger.getLogger("SkipController");

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/home")
    public String skipIndex(){
        return "index.html";
    }

    @RequestMapping(value = "/index")
    public String skipIndex2(){
        return "index.html";
    }

    @RequestMapping(value = "/signin")
    public String skipSignIn(){
        return "login.html";
    }

    @RequestMapping(value = "/editor")
    public String skipEditor(){
        return "editor.html";
    }

    @RequestMapping(value = "/admin")
    public String skipAdmin(Model ui, HttpServletRequest request){
        User user = userService.selectById((Integer) request.getSession().getAttribute("userId"));
        List<Message> messages = messageService.selectByToId((Integer) request.getSession().getAttribute("userId"));
        ui.addAttribute("user",user);
        ui.addAttribute("msg", messages);
        if(user == null){
            return "login.html";
        }
        if(user.getUserAuthority().equals("administrator")){
            return "adminCenter.html";
        }else{
            return "userCenter.html";
        }
    }
    @RequestMapping(value = "/admin/{path}")
    public String skipAdmin2(Model ui, HttpServletRequest request,
                            @PathVariable("path") String path){
        User user = userService.selectById((Integer) request.getSession().getAttribute("userId"));
        List<Message> messages = messageService.selectByToId((Integer) request.getSession().getAttribute("userId"));
        ui.addAttribute("user",user);
        ui.addAttribute("msg", messages);
        List<BlogSet> blogSet;
        if(user == null){
            return "login.html";
        }else {
            if (user.getUserAuthority().equals("administrator")) {
                switch (path) {
                    case "allArticle":
                        blogSet = blogService.selectAll();
                        ui.addAttribute("blogSet", blogSet);
                        return "center/article/allArticle.html";
                    case "audit":
                        blogSet = blogService.selectByStatus(2);
                        ui.addAttribute("blogSet",blogSet);
                        return "center/article/audit";
                    case "userControl":
                        return "center/user/user.html";
                }
                return "adminCenter.html";
            } else {
                logger.info(path);
                logger.info("not admin");
                if(path.equals("allArticle")) {
                    blogSet = blogService.selectByUserId(user.getUserId());
                    ui.addAttribute("blogSet", blogSet);
                    return "center/user/allArticle.html";
                }else if(path == ""){
                    return "home.html";
                }else{
                    return "userCenter.html";
                }
            }
        }

    }

    @RequestMapping(value = "/test")
    public String test(){
        return "test.html";
    }

    @RequestMapping(value = "/documents")
    public String skipDocuments(){
        return "home/documents.html";
    }

    @RequestMapping(value = "/home/blog")
    public String skipBlogs(){
        return "/home/blog.html";
    }

    @RequestMapping(value = "/home/doc")
    public String skipDocs(){
        return "/home/documents.html";
    }

    /* ? NOT USE */
    @RequestMapping(value = "/posteditor")
    public String skipPostEditor(){
        return "postEditor.html";
    }
    /* ? NOT USE */
    @RequestMapping(value = "/posteditordoc")
    public String skipPostEditorDoc(){
        return "postEditorDoc.html";
    }

    @RequestMapping(value = "/center/user/generality")
    public String skipCenterUserGenerality(){
        return "center/user/user.html";
    }

    /**
     * NOT USE
     *
     * @return
     */
    @RequestMapping(value = "/center/article/generality")
    public String skipCenterArticleGenerality(){
        return "center/article/allArticle.html";
    }

    /**
     * NOT USE
     *
     * @return
     */
    @RequestMapping(value = "/center/article/audit")
    public String skipCenterArticleAudit(){
        return "center/article/audit.html";
    }

    /**
     * NOT USE
     * @return
     */
    @RequestMapping(value = "/center/article/editor")
    public String skipCenterEditor(){
        return "center/article/editor.html";
    }
}
