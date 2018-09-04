package cn.nnu.jyjs.etpweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "cn.nnu.jyjs.etpweb.mapper")
@SpringBootApplication
public class EtpwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtpwebApplication.class, args);
    }
}
