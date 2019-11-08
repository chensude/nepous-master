package com.nepous.properties;

import com.nepous.base.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class NepousProperties {
    private SwaggerProperties swagger = new SwaggerProperties();

    private AsyncTaskProperties task = new AsyncTaskProperties();

    private AliyunProperties aliyun = new AliyunProperties();
    private ZookeeperProperties zk = new ZookeeperProperties();
}
