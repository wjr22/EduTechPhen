package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.mapper.BlogMapper;
import cn.nnu.jyjs.etpweb.mapper.UserMapper;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Constant;
import cn.nnu.jyjs.etpweb.utils.Encryption;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Project :   etpweb
 * @Time :   9/1/2018 19:52
 * @Auther :   wangj
 * @Description:
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger("PostController");

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @RequestMapping(value = "/getCookie.do")
    public void getCookie(){

    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSession.do")
    public @ResponseBody String getSession(HttpServletRequest request){
        logger.info("One User needed get session");
        if(request.getSession().getAttribute("userId") == null) {
            return "null";
        }
        logger.info(request.getSession().getAttribute("userId").toString());

        return request.getSession().getAttribute("userId").toString();
    }

    /**
     * signin
     * @param userName
     * @param userPassword
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/SignIn.do",method = RequestMethod.POST)
    public @ResponseBody String SignIn(@RequestParam(name = "userName") String userName,
                         @RequestParam(name = "userPassword") String userPassword,
                         @RequestParam(name = "isSave", required = false) String isSave,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         Model model){
        User user = userService.selectByName(userName);
        userPassword = Encryption.getPsdCipher(userPassword);
        HttpSession session = request.getSession();
        logger.info("new user login in "+new Date(session.getCreationTime()).toString());
        logger.info("session id is "+session.getId());
        logger.info("user name is "+userName);
        if(user.getUserPassword().equals(userPassword)){
            /*
             * NOT USE
             *if(user.getUserStatus() == 1){
             *   model.addAttribute("Msg","isLogin");
             *   return "login.html";
             *}
             *user.setUserStatus(1);
             *userMapper.updateByPrimaryKey(user);
             */
            session.setAttribute("userName",user.getUserName());
            session.setAttribute("userId",user.getUserId());
            session.setAttribute("userAuthority",user.getUserAuthority());
            session.setMaxInactiveInterval(36000);
            if(isSave != null){
                /**
                 * 附加项：把用户名保存到cookie中，发送给客户端浏览器
                 * 当再次打开login时，login中会读取request中的cookie，把它显示到用户名文本框中
                 **/
                Cookie cookie = new Cookie("userId", user.getUserId().toString());// 创建Cookie
                cookie.setMaxAge(60 * 60 * 24 * 30);// 设置cookie生存周期为30天
                response.addCookie(cookie);// 保存cookie
            }
            return "SUCCESS";
        }
        model.addAttribute("Msg","PasswordError");

        return "PASSWORD_ERR";
    }

    /**
     *
     * @param userName
     * @param userPassword
     * @param userEmail
     * @param ui
     * @param response
     * @return MSG
     */
    @RequestMapping(value = "/SignUp.do",method = RequestMethod.POST)
    public @ResponseBody String SignUp(@RequestParam(name = "userName") String userName,
                                       @RequestParam(name = "userPassword") String userPassword,
                                       @RequestParam(name = "userEmail") String userEmail,
                                       ModelMap ui, HttpResponse response){
        userPassword = Encryption.getPsdCipher(userPassword);
        User user = new User(userName,userPassword,userEmail);
        if(userMapper.selectByEmail(userEmail) != null ){
            return "EMAIL_UNIQUE";
        }else if(userMapper.selectByName(userName) != null){
            return "NAME_UNIQUE";
        }else{
            userMapper.insertSelective(user);
            return "SUCCESS";
        }
    }

    /**
     *
     * @param p_title
     * @param p_abstract
     * @param p_category
     * @param p_content
     * @return
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
        return "postSuccess.html";
    }

    /**
     *
     * @param page
     * @param category
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
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



    /**
     * deal with go back(log out) event
     * @param request
     * @return
     */
    @RequestMapping(value = "/goBack.do")
    public @ResponseBody String goBack(HttpServletRequest request){
        request.getSession().invalidate();
        logger.info(request.getSession().getAttribute("userId")+" is log out");
        return "SUCCESS";
    }

}
