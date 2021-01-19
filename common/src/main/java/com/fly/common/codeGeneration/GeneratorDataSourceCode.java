package com.fly.common.codeGeneration;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.stereotype.Component;

/**
* @Description: 代码生成器类
* @Author: XueBiao
* @Date: 2020/11/24
**/
@Component
public class GeneratorDataSourceCode {
    private GeneratorDataSourceUtil generatorDataSourceUtil = new GeneratorDataSourceUtil();
  /**
  * @Description: 执行代码生成器
  * @Author: XueBiao
  * @Date: 2020/11/24
  **/
    public void runGeneratorCode (){
        // 0.代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1.全局配置
        GlobalConfig gc = generatorDataSourceUtil.getGlobalConfig();
        mpg.setGlobalConfig(gc);

        // 2.数据源配置
        DataSourceConfig dsc = generatorDataSourceUtil.getDataSourceConfig();
        mpg.setDataSource(dsc);

        // 3.包配置
        PackageConfig pc =generatorDataSourceUtil. getPackageConfig();
        mpg.setPackageInfo(pc);

        // 4.自定义配置
        InjectionConfig cfg = generatorDataSourceUtil.getInjectionConfig();
        mpg.setCfg(cfg);

        // 5.模板配置
        TemplateConfig templateConfig = generatorDataSourceUtil.getTemplateConfig();
        mpg.setTemplate(templateConfig);
        // 使用Freemarker模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 6.策略配置
        StrategyConfig strategy = generatorDataSourceUtil.getStrategyConfig();
        mpg.setStrategy(strategy);

        // 7.开始生成代码
        mpg.execute();
    }
}
