package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    private UserService userService;

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
        ui.addAttribute("user",user);
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
        ui.addAttribute("user",user);
        if(user == null){
            return "login.html";
        }else {
            if (user.getUserAuthority().equals("administrator")) {
                switch (path) {
                    case "allArticle":
                        return "center/article/allArticle.html";
                    case "audit":
                        return "center/article/audit";
                    case "userControl":
                        return "center/user/user.html";
                }
                return "adminCenter.html";
            } else {
                return "userCenter.html";
            }
        }

    }

    @RequestMapping(value = "/documents")
    public String skipDocuments(){
        return "documents.html";
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

    @RequestMapping(value = "/center/article/generality")
    public String skipCenterArticleGenerality(){
        return "center/article/allArticle.html";
    }

    @RequestMapping(value = "/center/article/audit")
    public String skipCenterArticleAudit(){
        return "center/article/audit.html";
    }

    @RequestMapping(value = "/center/article/editor")
    public String skipCenterEditor(){
        return "center/article/editor.html";
    }
}
