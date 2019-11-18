package com.nepous.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName("pc_tpc_mq_consumer")
@EqualsAndHashCode(callSuper = true)
public class TpcMqConsumer extends Model<TpcMqConsumer> {

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 任务ID
     */
    private Long messageId;

    /**
     * 消息唯一标识
     */
    private String messageKey;

    /**
     * 消费者编码
     */
    private String consumberCode;

    /**
     * 消费的数次
     */
    private Integer  consumeCount;

    /**
     * 状态, 10 - 未确认 ; 20 - 已确认; 30 已消费
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
