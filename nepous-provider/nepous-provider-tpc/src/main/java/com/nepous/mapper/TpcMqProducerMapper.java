package com.nepous.mappper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepous.model.domain.TpcMqProducer;
import com.nepous.model.vo.TpcMqProducerVo;
import com.nepous.model.vo.TpcMqPublishVo;

import java.util.List;

public interface TpcMqProducerMapper extends BaseMapper<TpcMqProducer> {
    List<TpcMqProducerVo> listProducerVoWithPage(TpcMqProducer mdcMqProducer);

    List<TpcMqPublishVo> listTpcMqPublishVoWithPage(TpcMqProducer mdcMqProducer);

    int deletePublishByProducerId(Long id);

    TpcMqProducer getByPid(String producerGroup);
}
