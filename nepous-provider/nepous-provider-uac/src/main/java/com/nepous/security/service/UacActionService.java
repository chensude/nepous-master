package com.nepous.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nepous.security.model.domain.UacAction;

import java.util.List;

public interface UacActionService extends IService<UacAction> {
    List<UacAction> getOwnActionListByUserId(Long id);
}
