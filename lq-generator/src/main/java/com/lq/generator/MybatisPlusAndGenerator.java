package com.lq.generator;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


import java.util.ArrayList;


public class MybatisPlusAndGenerator {
    //反向生成工具
    public static void main(String[] args) {
        //创建AutoGenerator对象
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //设置输出的路径 项目的绝对路径地址
        gc.setOutputDir(projectPath + "/lq-generator/src/main/java");
        //设置作者
        gc.setAuthor("LQ");
        gc.setOpen(false);
//        gc.setIdType(id)
        //生成列
        gc.setBaseColumnList(true);
        //生成result map集合
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型

        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //连接的url地址
        // dsc.setUrl("jdbc:mysql://drds362mh8rzjb17.drds.yun.sinopec.com:3306/saasrada_int_dev?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        dsc.setUrl("jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        //设置驱动的名称
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //设置mysql的用户名
        dsc.setUsername("root");
        //设置mysql的密码
        dsc.setPassword("123456");
        //设置自动生成器的数据源
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName(scanner("模块名"));
        //设置包名
        pc.setParent("com.lq");
        //设置自动生成器的包
        mpg.setPackageInfo(pc);
        //生成策略的配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //自动填充
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategyConfig.setTableFillList(tableFills);
        strategyConfig.setVersionFieldName("version");//乐观锁列
        strategyConfig.setRestControllerStyle(true); //restful api风格控制器
        // 逻辑删除字段
        strategyConfig.setLogicDeleteFieldName("is_deleted");
//        strategyConfig.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        //生成指定表
//        strategyConfig.setInclude(new String[]{"sys_menu", "sys_role", "sys_role_menu", "sys_user", "sys_user_role"});
            //可变参数用数组，最好再模板里把它注释掉
//        strategyConfig.setTablePrefix(new String[]{""});
        //驼峰命名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //字段驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //去掉Boolean值中的is_前缀
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);
        //设置实体Bean的lombok

//        strategyConfig.setEntityLombokModel(true);
        //设置生成策略
        mpg.setStrategy(strategyConfig);
        //执行自动生成器
        mpg.execute();

    }

}

