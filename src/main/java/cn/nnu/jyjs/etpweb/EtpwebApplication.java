package cn.nnu.jyjs.etpweb;

import cn.nnu.jyjs.etpweb.utils.Encryption;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@MapperScan(value = "cn.nnu.jyjs.etpweb.mapper")
@SpringBootApplication(scanBasePackages = "cn.nnu.jyjs.etpweb")
public class EtpwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtpwebApplication.class, args);
        Encryption encryption = Encryption.getInstance();
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
