package com.nepous;

import com.baomidou.mybatisplus.annotation.DbType;
import com.nepous.constant.GlobalConstant;
import com.nepous.util.ConfigProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class Mysql8Generator {

    public static void main(String[] args) {
        DbType dbType = DbType.MYSQL;
        try {
            Yaml yaml = new Yaml();

            InputStream in =
                    Mysql8Generator.class.getClassLoader().getResourceAsStream("application.yml");
            Map<String, String> map = (Map) yaml.loadAs(in,Map.class);
            String driver = map.get(GlobalConstant.DataSourceMap.driver);
            String dbUrl = map.get(GlobalConstant.DataSourceMap.url);
            String username = map.get(GlobalConstant.DataSourceMap.username);
            String password = map.get(GlobalConstant.DataSourceMap.password);
            String[] tablePrefixs = GlobalConstant.TABLE_PREFIX;
            String packageName = GlobalConstant.BASE_PACKAGE_NAME;
            String[] tablesName = GlobalConstant.TABLE_NAMES;
            ConfigProvider.execute(dbType, dbUrl, username, password, driver, tablePrefixs,tablesName, packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
