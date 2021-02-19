package com.loadbalancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author madongyu
 * @title: RandomLoadbalanceStrategy
 * @projectName algorithm
 * @description: 随机算法
 * @date 2021/2/1619:54
 */
public class RandomLoadbalanceStrategy implements LoadbalanceStrategy{
    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object object) {
        int index = new Random().nextInt(configs.size());
        return configs.get(index);
    }


    public static void main(String[] args) {
        LoadbalanceStrategy strategy1 = new RandomLoadbalanceStrategy();
        loadbalace(strategy1,10,1000);

    }


    //strategy 　　负载均衡策略：随机，加权随机，轮询，加权轮询
//configNum　　生产者个数
//testCount　　测试次数
    public static void loadbalace(LoadbalanceStrategy strategy, int configNum, int testCount){
        List<ProviderConfig> configs = new ArrayList<>();
        int[] counts = new int[configNum];


        for(int i = 0; i< configNum; i++){
            ProviderConfig config = new ProviderConfig();
            config.setInterfaceName("com.serviceImpl");
            config.setHost("127.0.0.1");
            config.setPort(i);
            config.setWeight(new Random().nextInt(100));
            configs.add(config);
        }

        //System.out.println(configs);

        for(int i = 0; i< testCount ; i++){
            ProviderConfig config = strategy.select(configs,null);
            // System.out.println("选中的:"+config);
            Integer count = counts[config.getPort()];
            counts[config.getPort()] = ++count;

        }

        for(int i = 0; i< configNum; i++){
            System.out.println("序号:" + i + " 权重：" + configs.get(i).getWeight() + "--次数：" + counts[i]);
        }
    }
}
