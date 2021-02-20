package com.fly.common.codeGeneration;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
/**
* @Description: 代码生成器配置类
* @Author: XueBiao
* @Date: 2020/11/24
**/
public class GeneratorDataSourceUtil {
    private YmlConfig ymlConfig = new YmlConfig();

    /**
    * @Description: 全局配置
    * @Author: XueBiao
    * @Date: 2020/11/24
    **/
    public  GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/server/src/main/java");
        gc.setAuthor("fly");
        gc.setOpen(true);
        // 自定义生成的ServiceName，去掉默认的ServiceName前面的I
        gc.setServiceName("%s" + ConstVal.SERVICE);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        return gc;
    }
    /**
    * @Description: 数据源配置
    * @Author: XueBiao
    * @Date: 2020/11/24
    **/
    public  DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(YmlConfig.getProperties("driver"));
        dsc.setUrl(YmlConfig.getProperties("url"));
        if(ObjectUtils.isNotEmpty(YmlConfig.getProperties("schemaName"))){
            dsc.setSchemaName(YmlConfig.getProperties("schemaName"));
        }
        dsc.setUsername(YmlConfig.getProperties("username"));
        dsc.setPassword(YmlConfig.getProperties("password"));
        return dsc;
    }
    /**
    * @Description: 包配置
    * @Author: XueBiao
    * @Date: 2020/11/24
    **/
    public  PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        // 生成PACKAGE_NAME.MODULE_NAME的包路径
        pc.setParent(YmlConfig.getProperties("packageName"));
        pc.setModuleName(YmlConfig.getProperties("moduleName"));
        return pc;
    }
    /**
    * @Description: 自定义配置
    * @Author: XueBiao
    * @Date: 2020/11/24
    **/
    public  InjectionConfig getInjectionConfig() {
        // 这里模板引擎使用的是freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        String projectPath = System.getProperty("user.dir");
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化
                return projectPath + "/server/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper"
                        + StringPool.DOT_XML;
            }
        });

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        cfg.setFileOutConfigList(focList);
        return cfg;
    }
    /**
    * @Description: 模板配置
    * @Author: XueBiao
    * @Date: 2020/11/24
    **/
    public  TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        return templateConfig;
    }
    /**
    * @Description: 策略配置
    * @Author: XueBiao
    * @Date: 2020/11/24
    **/
    public  StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略-下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略-下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 <code>@RestController</code> 控制器
        strategy.setRestControllerStyle(true);
        //需要包含的表名，允许正则表达式（与exclude二选一配置）
        if(ObjectUtils.isNotEmpty(YmlConfig.getProperties("tableName"))){
            strategy.setInclude(YmlConfig.getProperties("tableName").split(","));
        }
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //要去掉表的前缀
        strategy.setTablePrefix(YmlConfig.getProperties("tablePrefix"));
        //是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        return strategy;
    }
}
