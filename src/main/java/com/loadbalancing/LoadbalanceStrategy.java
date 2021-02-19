package com.loadbalancing;

import java.util.List;

/**
 * @author madongyu
 * @title: LoadbalanceStrategy
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/1619:53
 */
public interface LoadbalanceStrategy {

    //object为扩展参数
    public ProviderConfig select(List<ProviderConfig> configs, Object object);
}
