package com.nepous.security.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nepous.security.model.domain.UacUser;
import org.apache.ibatis.annotations.Param;

public interface UacUserMapper extends BaseMapper<UacUser> {


    IPage<UacUser> selectMyUserPage(Page<UacUser> page,
                                    @Param(Constants.WRAPPER) Wrapper<UacUser> wrapper);

    UacUser selectUserInfoByUserId(Long id);
}
