package com.loadbalancing;

import java.util.List;

/**
 * @author madongyu
 * @title: UniformityHashLoadbalanceStrategy
 * @projectName algorithm
 * @description: 一致性hash
 * @date 2021/2/1620:36
 */
public class UniformityHashLoadbalanceStrategy implements  LoadbalanceStrategy{


    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object object) {
        return null;
    }
}
