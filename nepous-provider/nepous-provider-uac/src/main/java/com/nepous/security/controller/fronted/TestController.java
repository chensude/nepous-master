package com.nepous.security.controller.fronted;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nepous.core.annotation.LogAnnotation;
import com.nepous.core.generator.IncrementIdGenerator;
import com.nepous.core.generator.UniqueIdGenerator;
import com.nepous.security.feign.TestClient;
import com.nepous.security.mapper.UacUserMapper;
import com.nepous.security.model.domain.UacUser;
import com.nepous.util.result.RestResult;
import com.nepous.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

//    @Autowired
//    private UacUserMapper uacUserMapper;
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private TestClient testClient;
//
//    @GetMapping("get/user")
//    public void TestMapper() {
//        QueryWrapper<UacUser> query = Wrappers.<UacUser>query();
//        query.eq("user_name","张三");
//
//        //测试自定义分页
//        Page<UacUser> uacUserPage = new Page<UacUser>(1,2);
//        IPage<UacUser> uacUserIPage = uacUserMapper.selectMyUserPage(uacUserPage, query);
//
//        System.out.println(uacUserIPage.getRecords());
//    }
//
//    @PostMapping("insert")
//    public void insert() {
//        UacUser uacUser = new UacUser();
//        uacUser.setEmail("12312");
//        uacUser.setSalt("2312");
//        uacUser.setStatus("21321");
//        uacUser.setMobileNo("21312331223112");
//        uacUser.setUserName("张三");
//        int insert = uacUserMapper.insert(uacUser);
//        System.out.println("insertCount:"+insert);
//    }

    @LogAnnotation(isSaveRequestData = true)
    @GetMapping("/log")
    @SentinelResource("log")
    public Result testLogAnnotation() {
        return RestResult.ok("Log Annotation");
    }

    @GetMapping("/hello")
    @SentinelResource("hello")
    public Result testHelloLogAnnotation() {
        System.out.println( "最后的ID："+UniqueIdGenerator.generateId());
        return RestResult.ok("Log Annotation Hello");
    }

    @GetMapping("/tesd")
    @SentinelResource("tesd")
    public Result testTesd (){
        return RestResult.ok("Log Annotation tesd");
    }


    @PostMapping("/uac/role/queryList1")
    public Result testFeign() {
        testClient.getHello();
        return RestResult.ok("Feign client test");
    }
}
