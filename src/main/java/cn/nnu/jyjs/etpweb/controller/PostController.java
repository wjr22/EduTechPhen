package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project :   etpweb
 * @Time :   9/1/2018 19:52
 * @Auther :   wangj
 * @Description:
 */
@Controller
public class PostController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/postEditor")
    public String skipPostEditor(){
        return "postEditor.html";
    }

    @RequestMapping(value = "/postEditorDoc")
    public String skipPostEditorDoc(){
        return "postEditorDoc.html";
    }
}
