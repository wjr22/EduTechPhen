package cn.nnu.jyjs.etpweb;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.BlogSet;
import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.controller.BackstorageController;
import cn.nnu.jyjs.etpweb.service.BlogService;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testMap(){
        Map<String,Integer> tes = new LinkedHashMap<String,Integer>();
        tes.put("你好",1);
        tes.put("你不好",2);
        tes.put("你好",3);
        tes.put("你好",4);
        tes.put("你好",5);
        tes.put("你好",2);
        System.out.println(tes);
        for (Map.Entry<String, Integer> entry: tes.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
