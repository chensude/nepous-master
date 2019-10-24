/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacUser.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.nepous.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("pc_uac_user")
public class UacUser  {
	private static final long serialVersionUID = 5465775492730080699L;

	private String salt;

	private String userCode;
	private String userName;
	private String mobileNo;
	private String status;
	private String email;

}