package com.loadbalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.loadbalancing.RandomLoadbalanceStrategy.loadbalace;

/**
 * @author madongyu
 * @title: WeightPollingLoadbalanceStrategy
 * @projectName algorithm
 * @description: 加权轮训算法
 * @date 2021/2/1620:18
 */
public class WeightPollingLoadbalanceStrategy implements LoadbalanceStrategy {

    private Map<String,Integer> indexMap = new ConcurrentHashMap<>();

    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object object){

        Integer index = indexMap.get(getKey(configs.get(0)));
        if(index == null){
            indexMap.put(getKey(configs.get(0)),0);
            return configs.get(0);
        }
        else {

            List<ProviderConfig> newConfigs = new ArrayList<>();

            for(ProviderConfig config:configs){

                for(int i = 0; i< config.getWeight(); i++){
                    newConfigs.add(config);
                }
            }
            index++;
            if(index >= newConfigs.size()){
                index = 0;
            }
            indexMap.put(getKey(configs.get(0)),index);
            return newConfigs.get(index);

        }
    }

    public String getKey(ProviderConfig config){

        return  config.getInterfaceName();
    }

    public static void main(String[] args) {
        System.out.println("\r\n加权轮询负载均衡.....");
        LoadbalanceStrategy strategy4 = new WeightPollingLoadbalanceStrategy();
        loadbalace(strategy4,10,1000);
    }
}
