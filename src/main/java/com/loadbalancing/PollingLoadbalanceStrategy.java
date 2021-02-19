package com.loadbalancing;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.loadbalancing.RandomLoadbalanceStrategy.loadbalace;

/**
 * @author madongyu
 * @title: PollingLoadbalanceStrategy
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/1620:08
 */
public class PollingLoadbalanceStrategy implements LoadbalanceStrategy{

    //使用一个Ｍap来缓存每类应用的轮询索引
    private Map<String,Integer> indexMap = new ConcurrentHashMap<>();

    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object object) {
        Integer index = indexMap.get(getKey(configs.get(0)));
        if(index == null){
            indexMap.put(getKey(configs.get(0)),0);
            return configs.get(0);
        }
        else {
            index++;
            //当index超过size时，重置为0，在从头开始循环
            if(index >= configs.size()){
                index = 0;
            }
            indexMap.put(getKey(configs.get(0)),index);
            return configs.get(index);
        }
    }

    public String getKey(ProviderConfig config){
        return  config.getInterfaceName();
    }


    public static void main(String[] args) {
        System.out.println("\r\n轮询负载均衡.....");
        LoadbalanceStrategy strategy3 = new PollingLoadbalanceStrategy();
        loadbalace(strategy3,10,1000);
    }
}
