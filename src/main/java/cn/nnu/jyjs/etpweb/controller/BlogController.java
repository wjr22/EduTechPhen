package cn.nnu.jyjs.etpweb.controller;

import cn.nnu.jyjs.etpweb.bean.*;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import cn.nnu.jyjs.etpweb.service.MessageService;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Encryption;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Autowired
    private MessageService messageService;

    @Value("${file.upload}")
    private String location;


    /**
     * from editor
     * @param p_title post title
     * @param p_abstract post abstract
     * @param p_category post category
     * @param p_content post content
     * @param method "draft" or "posts" default publish
     * @return
     *      postSuccess html page
     */
    @RequestMapping(value = "/posts")
    public String getPosts(@RequestParam(value = "title") String p_title,
                           @RequestParam(value = "abstract") String p_abstract,
                           @RequestParam(value = "category", required = false) String p_category,
                           @RequestParam(value = "content") String p_content,
                           @RequestParam(value = "method", required = false) String method,
                           HttpServletRequest request){
        logger.info(p_content);
        logger.info(request.getSession().getAttribute("userId").toString());
        int userId = (int) request.getSession().getAttribute("userId");
        Blog blog = new Blog(p_title,p_content,p_abstract);
        if (method == null) {
            blog.setBlogStatus(2);
        }else{
            switch (method) {
                case "draft":
                    blog.setBlogStatus(0);
                    break;
                case "post":
                    if (userId == 1) {
                        //admin
                        blog.setBlogStatus(1);
                    } else {
                        blog.setBlogStatus(2);
                        // send message
                        Message m = new Message();
                        m.setToId(userId);
                        m.setFromId(1);
                        m.setMessage("您的文章审核通过，已发布，谢谢");
                        messageService.insertMessage(m);
                    }
                    break;
            }
        }
        if (p_category == null) {
            p_category = "博客";
        }

        blogService.insertBlog(blog, (int)request.getSession().getAttribute("userId"),
                categoryService.getId(p_category));
        return "Success.html";
    }

    /**
     * upload files
     * step 1 : read Input Stream from request
     * step 2 : save into location dir
     * step 3 : response result which is json data including file's name and file's url.
     *
     * @param file
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/images.do")
    public void uploadImage(@RequestParam(value = "upload") MultipartFile[] file,
                            HttpServletResponse response,
                            HttpServletRequest request) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        Random random = new Random();
        // step 3 CREATE
        out = response.getWriter();
        logger.info(location);
        //如果目录不存在，自动创建文件夹
        File dir = new File(location);
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (int i = 0; i < file.length; i++) {
            if (null != file[i]) {
                String contentType = file[i].getContentType();
                if (!contentType.contains("")) {
                    logger.info("error ===");
                }
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                String fileName = dateFormat.format(date) + request.getSession().getAttribute("userId") + file[i].getOriginalFilename().hashCode();
                switch (contentType) {
                    case "image/jpeg":
                        fileName = fileName + ".jpg";
                        break;
                }
                logger.info("upload:" + fileName + "    type:" + contentType + "    into:" + location);
                File output = new File(location, fileName);
                if (output.exists()) {
                    fileName = random.nextInt() + fileName;
                    output = new File(location, fileName);
                }
                FileCopyUtils.copy(file[i].getBytes(), output);
                //Encryption.saveFile(file[i],location,fileName);
                Map<String, Object> map = new HashMap<>();
                // response
                map.put("fileName", fileName);
                map.put("uploaded", 1);
                map.put("url", "/getImage.do/" + fileName);
                String res = JSONArray.toJSONString(map);
                out.write(res);
            }
        }
    }

    /**
     * get images from server
     *
     * @param imageName
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getImage.do/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File(location + "/" + imageName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    /**
     * One blog audit
     *
     * @param blogId
     * @param target
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/doAudit.do")
    @ResponseBody
    public String audit(@RequestParam(value = "blogId") Integer blogId,
                        @RequestParam(value = "target") String target,
                        @RequestParam(value = "reason", required = false) String reason,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (blogId == null) {
            result.put("request", "null");
        } else {
            Blog blog = blogService.selectById(blogId);
            if (target == null) {
                target = "notpass";
            }
            switch (target) {
                case "notpass":
                    blog.setBlogStatus(3);
                    break;
                case "pass":
                    blog.setBlogStatus(1);
                    break;
                case "draft":
                    blog.setBlogStatus(0);
                    break;
            }
            blogService.updateStatus(blog);
        }
        String json = JSONArray.toJSONString(result);
        return json;
    }


    /**
     * NOT USE
     * @param page
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/audit")
    public String getAudit(@RequestParam(required = true,defaultValue = "1") Integer page,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "15") Integer pageSize,
                           Model model) {
        List<BlogSet> blogSets = blogService.selectByStatus(2);
        int startItem = (page - 1)*15;
        int itemSize = blogSets.size();
        Page pageInfo = new Page(pageSize,itemSize);
        pageInfo.setCurrentPage(page);
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
     * according to user name or category,return blog list
     *
     * @param userName NOT NECESSARY
     * @param category NOT NECESSARY
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String getList(@RequestParam(value = "userName",required = false) String userName,
                          @RequestParam(value = "category",required = false) String category,
                          Model model){
        List<BlogSet> blogSets;
        String cases = null;
        if(userName == null){

        }else{
            User user = userService.selectByName(userName);
            blogSets = blogService.selectByUserId(user.getUserId());
            model.addAttribute("blogSets",blogSets);

        }
        if (category == null) {

        } else {
            User user = userService.selectByName(userName);
            blogSets = blogService.selectByUserId(user.getUserId());
            model.addAttribute("blogSets", blogSets);
        }
        model.addAttribute("cases", cases);
        return "userMain.html";
    }

    /**
     * NOT USE
     * @param page
     * @param category
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/articles")
    public String getPosts(@RequestParam(required = true,defaultValue = "1") Integer page,
                           @RequestParam(required = false,value = "category") String category,
                           @RequestParam(required = false,value = "mod") String mod,
                           HttpServletRequest request,
                           Model model) {
        List<BlogSet> blogs = null;
        if(category != null) {
            PageHelper.startPage(page, 15);
            blogs = blogService.selectByCategory(category);
            logger.info("category is" + category + " and blogs num is " + blogs.size());
        } else {
            PageHelper.startPage(page, 15);
            //blogs = blogService.selectAll();
            logger.info("blogs num is "+blogs.size());
        }
        PageInfo<BlogSet> pageInfo = pageInfo = new PageInfo<BlogSet>(blogs);;
        if(blogs != null && pageInfo != null) {
            model.addAttribute("page", pageInfo);
            model.addAttribute("blogs", blogs);
        }else{
            model.addAttribute("msg","NET_ERROR");
        }
        return "list.html";
    }

}

