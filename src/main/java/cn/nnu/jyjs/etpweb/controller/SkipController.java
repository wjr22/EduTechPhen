package cn.nnu.jyjs.etpweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String skipAdmin(){
        return "admin.html";
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


}
