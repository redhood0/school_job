package com.hooli.work.util;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @ClassName MySqlGenerator
 * @Description 代码生成器
 */
@Slf4j
public class MySqlGenerator {
    public static void main(String[] args) {
        //全局策略配置
        GlobalConfig config = new GlobalConfig();
        //获得当前项目根路径d:/dev/SpringBoot/spring-boot-learning
        String projectPath = System.getProperty("user.dir");

        config.setActiveRecord(true)
                //作者注释
                .setAuthor("dylan")
                //代码生成输出路径
                .setOutputDir(projectPath + "/src/main/java")
                //覆盖已有文件，默认false
                .setFileOverride(false)
                //是否打开输出目录窗口。默认true
                .setOpen(false)
                //开启swagger2模式
                //.setSwagger2(true)
                //开启ActiveRecord模式
                .setActiveRecord(true)
                //mapper添加restMap
                .setBaseResultMap(true)
                //mapper添加Base_Column_List
                .setBaseColumnList(true)
                //时间类型对应策略，默认time_pack
                //.setDateType(DateType.TIME_PACK)
                //相关包中的接口和类名后缀
                .setMapperName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl");

        //数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        StrategyConfig strategyConfig = new StrategyConfig();
        //是否大写命名
        strategyConfig.setCapitalMode(true)
                //是否跳过视图
                .setSkipView(true)
                //数据库表映射到实体的命名策略为驼峰式
                .setNaming(NamingStrategy.underline_to_camel)
                //生成表，可以写多个,如果不加参数，默认为所有表

                .setInclude("work_demand")
                .setEntityBuilderModel(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setEntityTableFieldAnnotationEnable(true);

        //包名配置
        PackageConfig packageConfig = new PackageConfig();
        //父包名
        packageConfig.setParent("com.hooli.work")
//                .setMapper("mapper")
//                .setService("service")
//                .setController("controller")
                .setXml("mapper")
                .setEntity("entity");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        cfg.setFileCreate((configBuilder, fileType, filePath) -> {
            //如果是Entity则直接返回true表示写文件
            if (fileType == FileType.ENTITY) {
                return true;
            }
            //否则先判断文件是否存在
            File file = new File(filePath);
            boolean exist = file.exists();
            if (!exist) {
                file.getParentFile().mkdirs();
            }
            //文件不存在或者全局配置的fileOverride为true才写文件
            return !exist || configBuilder.getGlobalConfig().isFileOverride();
        });


        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://47.101.179.127:3306/school_job?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai")
                .setUsername("zq")
                .setPassword("123456");

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setStrategy(strategyConfig)
                .setDataSource(dataSourceConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setPackageInfo(packageConfig)
                .setCfg(cfg);

        autoGenerator.execute();
        log.info("=============代码生成成功================");
    }
}
