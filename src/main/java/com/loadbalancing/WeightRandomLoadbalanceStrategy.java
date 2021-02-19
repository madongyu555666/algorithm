package com.loadbalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.loadbalancing.RandomLoadbalanceStrategy.loadbalace;

/**
 * @author madongyu
 * @title: WeightRandomLoadbalanceStrategy
 * @projectName algorithm
 * @description: 加权随机算法
 * @date 2021/2/1620:03
 */
public class WeightRandomLoadbalanceStrategy implements LoadbalanceStrategy{
    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object object) {
        List<ProviderConfig> newConfigs = new ArrayList<>();

        for(ProviderConfig config:configs){

            for(int i = 0; i< config.getWeight(); i++){
                //循环添加，权重越大，在集合中占据的越多，获取的几率也越大
                newConfigs.add(config);
            }
        }

        int index = new Random().nextInt(newConfigs.size()-1);
        return newConfigs.get(index);
    }


    public static void main(String[] args) {
        System.out.println("加权随机负载均衡....");
        LoadbalanceStrategy strategy2 = new WeightRandomLoadbalanceStrategy();
        loadbalace(strategy2,10,1000);
    }
}
