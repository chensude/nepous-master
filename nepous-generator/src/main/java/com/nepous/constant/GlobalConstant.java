package com.nepous.constant;


public class GlobalConstant {

    /** 文件名后缀：Model */
    public static final String FILE_NAME_ENTITY = "%s";

    /** 文件名后缀：Mapper */
    public static final String FILE_NAME_MAPPER = "%sMapper";

    /**Service结尾 */
    public static final String FILE_NAME_SERVICE = "%sService";

    /** 文件名后缀：ServiceImpl */
    public static final String FILE_NAME_SERVICE_IMPL = "%sServiceImpl";

    /** 文件名后缀：Controller */
    public static final String FILE_NAME_CONTROLLER = "%sController";

    /** 作者 */
    public static final String AUTHOR = "陈苏德";

    // 生成文件的根输出目录
    public static String projectPath = System.getProperty("user.dir");

    //生成Model的包名和位置
    public static String MODEL_TARGET_PACKAGE = "/nepous-generator/src/main/java";
    //生成映射文件的包名和位置
    public static String XML_TARGET_PACKAGE = "/nepous-generator/src/main/resources/mapper";
    //基本包名
    public static String BASE_PACKAGE_NAME = "com.nepous";

    //修改为您的表前缀(数组)
    public static String[] TABLE_PREFIX = {""};


    // 表名，为空，生成所有的表
    public static String [] TABLE_NAMES = {};

    public  static  final class DataSourceMap{
        private DataSourceMap() {}
        public static final String driver = "driver-class-name" ;
        public static final String url = "url";
        public static final String username = "username";
        public static final String password = "password";
    }

}
