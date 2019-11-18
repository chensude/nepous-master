package com.nepous.mappper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepous.model.domain.TpcMqConsumer;
import com.nepous.model.vo.TpcMqConsumerVo;
import com.nepous.model.vo.TpcMqSubscribeVo;

import java.util.List;

public interface TpcMqConsumerMapper extends BaseMapper<TpcMqConsumer> {
    List<TpcMqConsumerVo> listTpcMqConsumerVoWithPage(TpcMqConsumer tpcMqConsumer);

    List<TpcMqSubscribeVo> listTpcMqSubscribeVoWithPage(TpcMqConsumer tpcMqConsumer);

    int deleteSubscribeTagByTagId(Long tagId);

    List<String> listConsumerGroupByTopic(String topic);

    List<TpcMqSubscribeVo> listSubscribeVo(List<Long> subscribeIdList);

    List<Long> listSubscribeIdByConsumerId(Long consumerId);

    void deleteSubscribeByConsumerId(Long consumerId);

    void deleteSubscribeTagBySubscribeIdList(List<Long> subscribeIdList);

    TpcMqConsumer getByCid(String consumerGroup);
}
