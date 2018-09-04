package cn.nnu.jyjs.etpweb.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project :   etpweb
 * @Time :   9/1/2018 12:05
 * @Auther :   wangj
 * @Description:
 *  generate mybatis XML JAVACLIENT and MODEL
 */
public class MybatisGenerate {
    public static void main(String[] args){
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            Configuration config = cp.parseConfiguration(configFile);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
    }
}
