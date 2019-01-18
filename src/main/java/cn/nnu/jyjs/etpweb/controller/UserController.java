package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.mapper.UserMapper;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Logger;

/**
 * Project :   etpweb
 * Time :   9/1/2018 19:52
 * Author :   wangj
 * Description:
 *  if request map include ".do",this method will return ResponseBody
 *      other will return a html page
 *  Version 1.0 :
 *      method : Sign-In / Sign-Up / Sign-Out / getSession /
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger("UserController");

    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private UserMapper userMapper;

    private List<Integer> users = new LinkedList<Integer>();

    /**
     *
     */
    @RequestMapping(value = "/getCookie.do")
    public void getCookie(){

    }

    /**
     * get session
     * @return if session is newly-built,put "null" into response-body,
     *          else put session['userId'] in response-body
     */
    @RequestMapping(value = "/getSession.do")
    public @ResponseBody String getSession(HttpServletRequest request){

        if(request.getSession().getAttribute("userId") == null) {
            //logger.info("NOT FOUND request to get session");
            return "null";
        }
        //logger.info(request.getSession().getAttribute("userId").toString() + " request to get session");
        return request.getSession().getAttribute("userId").toString();
    }

    /**
     * signin
     *
     * @param userName ID or name or email all is OK
     * @param isSave if isSave isn't null, we will send userId and userPassword to browsers. and then
     * @return  SUCCESS         : success
     *          PASSWORD_ERR    : password error
     *          USER_NOT_FOUND  : user not found
     *          ISLOGIN         : this user is login
     */
    @RequestMapping(value = "/SignIn.do",method = RequestMethod.POST)
    public @ResponseBody String SignIn(@RequestParam(name = "userName") String userName,
                         @RequestParam(name = "userPassword") String userPassword,
                         @RequestParam(name = "isSave", required = false) String isSave,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         Model model){
        // check name type
        User user;
        if(userName.contains("@")){
            user = userService.selectByEmail(userName);
        }else{
            user = userService.selectByName(userName);
        }
        /*  check multiple login */
        if(userService.islogin(user.getUserId())){
            return "ISLOGIN";
        }
        if(user == null){
            return "USER_NOT_FOUND";
        }
        userPassword = Encryption.getPsdCipher(userPassword);
        HttpSession session = request.getSession();
        logger.info("new user login in "+new Date(session.getCreationTime()).toString());
        logger.info("user name is "+userName);
        if(user.getUserPassword().equals(userPassword)){
            userService.login(user.getUserId());
            session.setAttribute("userId",user.getUserId());
            session.setMaxInactiveInterval(36000);
            if(isSave != null){
                /*
                 * addition : put userId into cookie and return browsers,
                 *              then users can remember Password;
                 *            AND COOKIE Save age is One month;(30 days)
                 */
                Cookie cookie = new Cookie("userId", user.getUserId().toString());// 创建Cookie
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
            }

            users.add(user.getUserId());
            return "SUCCESS";
        }
        model.addAttribute("Msg","PasswordError");
        return "PASSWORD_ERR";
    }

    /**
     * sign up (register)
     * @return "EMAIL_UNIQUE" :email unique (email will as the ONLY channel to change the password)
     *         "NAME_UNIQUE"  :name unique
     *         "SUCCESS"      :success
     */
    @RequestMapping(value = "/SignUp.do",method = RequestMethod.POST)
    public @ResponseBody String SignUp(@RequestParam(name = "userName") String userName,
                                       @RequestParam(name = "userPassword") String userPassword,
                                       @RequestParam(name = "userEmail") String userEmail){
        userPassword = Encryption.getPsdCipher(userPassword);
        User user = new User(userName,userPassword,userEmail);
        // use userMapper
        if(userService.selectByEmail(userEmail) != null ){
            return "EMAIL_UNIQUE";
        }else if(userMapper.selectByName(userName) != null){
            return "NAME_UNIQUE";
        }else{
            userMapper.insertSelective(user);
            return "SUCCESS";
        }
        // use userService

    }

    /**
     * deal with go back(log out) event
     * @return "SUCCESS" :success
     *
     */
    @RequestMapping(value = "/SignOut.do")
    public @ResponseBody String SignOut(HttpServletRequest request){
        users.remove(request.getSession().getAttribute("userId"));
        logger.info(request.getSession().getAttribute("userId")+" is log out");
        userService.exitUser((int)request.getSession().getAttribute("userId"));
        request.getSession().invalidate();
        return "SUCCESS";
    }

    @RequestMapping(value = "/Authority.do")
    public @ResponseBody String getAuthority(@RequestParam("userId") String userId){
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId));
        return user.getUserAuthority();
    }

}
