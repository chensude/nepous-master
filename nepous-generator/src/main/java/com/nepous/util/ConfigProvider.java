package com.nepous.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.nepous.constant.GlobalConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConfigProvider {

    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入"+tip+":");
        System.out.println(help.toString());
        if(scanner.hasNext()){
            String ipt = scanner.next();
            if(StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的"+tip+"!");
    }

    /**
     * 连接数据库信息
     */
    private static DataSourceConfig dataSourceConfig(DbType dbType, String url, String username, String password, String driver) {
        return new DataSourceConfig()
                .setDbType(dbType)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driver);
    }

    /**
     * 全局配置
     */
    private static GlobalConfig globalConfig() {
        return new GlobalConfig()
                .setOutputDir(GlobalConstant.projectPath+GlobalConstant.MODEL_TARGET_PACKAGE)//生成目文件的输出目录
                .setAuthor(GlobalConstant.AUTHOR)//设置作者
                .setOpen(false)//文件生成后，是否需要打开所在路径
                .setActiveRecord(false)//开启ActiveRecord模式
                .setFileOverride(true)//是否覆盖已有文件
                .setEnableCache(false)//是否在xml中添加二级缓存设置
                .setBaseResultMap(true)//开启BaseResultMap
                .setBaseColumnList(true)//开启BaseColumnList
                .setDateType(DateType.TIME_PACK)//时间类型对应策略
                .setControllerName(GlobalConstant.FILE_NAME_CONTROLLER)
                .setServiceName(GlobalConstant.FILE_NAME_SERVICE)
                .setServiceImplName(GlobalConstant.FILE_NAME_SERVICE_IMPL)
                .setEntityName(GlobalConstant.FILE_NAME_ENTITY)
                .setMapperName(GlobalConstant.FILE_NAME_MAPPER)
                .setXmlName(GlobalConstant.FILE_NAME_MAPPER)
                .setIdType(IdType.ID_WORKER);

    }

    /**
     * 包的配置
     *
     */
    private static PackageConfig packageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)//父包名，如果为空，将下面子包名必须写全部，否则就只需写子包名
                .setModuleName(scanner("模块名"));//父包模块名称
    }

    /**
     * 自定义配置
     *
     */
    private static InjectionConfig injectionConfig(final PackageConfig packageConfig) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return GlobalConstant.projectPath + GlobalConstant.XML_TARGET_PACKAGE + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        return injectionConfig;
    }
    /**
     * 策略配置
     *
     */
    private static StrategyConfig strategyConfig(String [] tablePrefixs,String[] tablesName) {
        return new StrategyConfig()
                .setCapitalMode(true) // 全局大写命名 ORACLE 注意
                .setTablePrefix(tablePrefixs)// 此处可以修改为您的表前缀(数组)
                .setNaming(NamingStrategy.underline_to_camel) // 表名生成策略
                .setInclude(tablesName)//修改替换成你需要的表名，多个表名传数组
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setRestControllerStyle(true)
                .setEntityLombokModel(true) // lombok实体
                .setEntityBuilderModel(false) // 【实体】是否为构建者模型（默认 false）
                .setEntityColumnConstant(false) // 【实体】是否生成字段常量（默认 false）// 可通过常量名获取数据库字段名 // 3.x支持lambda表达式
                .setControllerMappingHyphenStyle(true);
    }


    /**
     * 执行器
     */
    public static void execute(DbType dbType, String dbUrl, String username,
                               String password, String driver,
                               String [] tablePrefixs,String[] tablesNames, String packageName) {
        GlobalConfig gc = globalConfig();
        DataSourceConfig dataSourceConfig = dataSourceConfig(dbType, dbUrl, username, password, driver);
        StrategyConfig strategyConfig = strategyConfig(tablePrefixs,tablesNames);
        PackageConfig packageConfig = packageConfig(packageName);
        InjectionConfig injectionConfig = injectionConfig(packageConfig);

        //代码生成器
        new AutoGenerator()
                .setGlobalConfig(gc)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig)
                .setCfg(injectionConfig)
                .setTemplate(new TemplateConfig().setXml(null))
                .setTemplateEngine(new FreemarkerTemplateEngine()).execute();
    }

}
