package com.nepous.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepous.security.model.domain.UacAction;

import java.util.List;

public interface UacActionMapper extends BaseMapper<UacAction> {
    List<UacAction> getOwnUacActionListByUserId(Long userId);
}
