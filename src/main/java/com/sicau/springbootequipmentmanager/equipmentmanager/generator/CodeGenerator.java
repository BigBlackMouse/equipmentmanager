package com.sicau.springbootequipmentmanager.equipmentmanager.generator;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // String projectPath = System.getProperty("user.dir");
        // gc.setOutputDir(projectPath + "/src/main/java");
        String projectPath = "C:\\Users\\ASUS\\Desktop\\equipmentmanager\\springboot-equipment\\equipmentCode";
        gc.setOutputDir(projectPath);
        gc.setAuthor("软件工程实训：2023/5/25");
        //设置完之后是否打开资源管理器
        gc.setOpen(false);
        gc.setSwagger2(false);
        gc.setIdType(IdType.AUTO);
        //设置是否覆盖原始生成的文件
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        //去掉service的i前缀
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl(
                "jdbc:mysql://127.0.0.1:3306/devicemanage?useUnicode=true&characterEncoding=utf8");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("user");// 模块名
        pc.setParent("com.sicau.springbootequipmentmanager.equipmentmanager");
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {

            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {

            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude("tb_feedback");// 表名
        // strategy.setSuperEntityColumns("id");
        // strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityTableFieldAnnotationEnable(true);
//        strategy.setLogicDeleteFieldName("del_flag");
        //设置是否启用Lombok
        strategy.setEntityLombokModel(true);
        List<TableFill> tableFillList = new ArrayList<TableFill>();
        TableFill tableFill1 = new TableFill("create_time", FieldFill.INSERT);
        TableFill tableFill2 = new TableFill("creator", FieldFill.INSERT);
        TableFill tableFill3 = new TableFill("update_time", FieldFill.UPDATE);
        TableFill tableFill4 = new TableFill("operator", FieldFill.UPDATE);
        tableFillList.add(tableFill1);
        tableFillList.add(tableFill2);
        tableFillList.add(tableFill3);
        tableFillList.add(tableFill4);
        strategy.setTableFillList(tableFillList);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
