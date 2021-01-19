package com.fly.common.codeGeneration;


import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
* @Description: 获取配置参数类
* @Author: XueBiao
* @Date: 2020/11/24
**/
public class YmlConfig {
    /**
     * @Description: 获取配置文件参数值
     * @Param: keyWord 参数名
     * @Return: String 参数值
     * @Author: XueBiao
     * @Date: 2020/11/24
     **/
    public static String getProperties(String keyWord){
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties("generator.properties");
            // 根据关键字查询相应的值
            value = prop.getProperty(keyWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
