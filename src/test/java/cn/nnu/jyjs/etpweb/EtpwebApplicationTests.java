package cn.nnu.jyjs.etpweb;

import cn.nnu.jyjs.etpweb.bean.*;
import cn.nnu.jyjs.etpweb.controller.BackstorageController;
import cn.nnu.jyjs.etpweb.mapper.CategoryMapper;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import cn.nnu.jyjs.etpweb.service.MessageService;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtpwebApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    MessageService messageService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void contextLoads() {
        User user = userService.selectByName("test");
        if(user == null){
            System.out.println("null");
        }else{
            System.out.println(user.toString());
        }
    }

    @Test
    public void testCategory() {
        Category categoryId = categoryMapper.selectByName("博客");
        System.out.println("category id is " + categoryId);
        //Category categoryId2 = categoryMapper.selectTest("博客");
        //System.out.println("category id is "+ categoryId2);
    }

    @Test
    public void testMessage() {

        /*Message m = new Message();
        m.setFromId(2);
        m.setToId(1);
        m.setMessage("test");
        messageService.insertMessage(m);*/
        List<Message> messages = messageService.selectByFromId(userService.selectByName("admin").getUserId());
        //List<Message> messages = messageService.selectByFrom("admin");
        for (Message m :
                messages) {
            System.out.println(m.getMessage());
        }
    }

    @Test
    public void getJSON(){
        List<BlogSet> blogSets = blogService.selectByStatus(2);
        BlogSet blogSet;
        for (int i=0; i<blogSets.size(); i++) {
            blogSet = blogSets.get(i);
            System.out.println(blogSet.getAuthor());
            System.out.println(blogSet.getBlogAbstract());
            System.out.println(blogSet.getBlogId());
            System.out.println(blogSet.getBlogStatus());
            System.out.println("\n\n");
        }
    }

    @Test
    public void write(){
        for(int i = 10; i < 30; i++){
            Blog blog = new Blog();
            blog.setAuthorId(3);
            blog.setBlogContent("<h1>test</h1><h2>this id="+i+" and author name = "+userService.selectById(2).getUserName()+"!");
            blog.setBlogTitle("id is "+i);
            blog.setBlogCategory(5);
            blogService.insert(blog);
        }
    }

    @Value("${file.upload}")
    private String path;

    /**
     * 文件上传测试
     */
    @Test
    public void uploadTest() throws Exception {
        File f = new File("D:/tree.jpg");
        FileCopyUtils.copy(f, new File(path + "/1.jpg"));
    }

    @Test
    public void listFilesTest() {
        File file = new File(path);
        for (File f : file.listFiles()) {
            System.out.println("fileName : " + f.getName());
        }
    }
}
