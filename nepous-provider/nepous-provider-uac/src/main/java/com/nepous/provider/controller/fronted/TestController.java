package com.nepous.provider.controller.fronted;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nepous.provider.mapper.UserMapper;
import com.nepous.provider.model.domain.UacUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("get/user")
    public void TestMapper() {
//        List<UacUser> uacUsers = userMapper.selectList(null);
//        uacUsers.forEach(System.out::println);
//        UacUser uacUser = userMapper.getUserById(1);
//        System.out.println(uacUser);
        QueryWrapper<UacUser> query = Wrappers.<UacUser>query();

        query.eq("user_name","张三");
//     //   userMapper.getUserById(query);
//        System.out.println("结果"+userMapper.getUserById(query));


        //测试自定义分页
        Page<UacUser> uacUserPage = new Page<UacUser>(1,2);
        IPage<UacUser> uacUserIPage = userMapper.selectMyUserPage(uacUserPage, query);

        System.out.println(uacUserIPage.getRecords());
    }


    @GetMapping("insert")
    public void insert() {
        UacUser uacUser = new UacUser();
        uacUser.setEmail("12312");
        uacUser.setSalt("2312");
        uacUser.setStatus("21321");
        uacUser.setMobileNo("21312331223112");
        uacUser.setUserName("张三");
        int insert = userMapper.insert(uacUser);
        System.out.println("insertCount:"+insert);
    }
}
