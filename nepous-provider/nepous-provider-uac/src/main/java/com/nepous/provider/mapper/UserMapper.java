package com.nepous.provider.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nepous.provider.model.domain.UacUser;
import org.apache.ibatis.annotations.Param;


public interface UserMapper extends BaseMapper<UacUser> {

    UacUser getUserById(@Param(Constants.WRAPPER) Wrapper<UacUser> wrapper);

    IPage<UacUser> selectMyUserPage(Page<UacUser> page,
                                    @Param(Constants.WRAPPER) Wrapper<UacUser> wrapper);
 }
