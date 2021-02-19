package com.loadbalancing;

import java.util.*;

/**
 * @author madongyu
 * @title: LeastActiveLoadbalanceStrategy
 * @projectName algorithm
 * @description: 最小时延算法
 * @date 2021/2/1620:25
 */
public class LeastActiveLoadbalanceStrategy implements  LoadbalanceStrategy{



    @Override
    public ProviderConfig select(List<ProviderConfig> configs, Object object) {
        ProviderConfig[] registryConfigs= new ProviderConfig[configs.size()];
        configs.toArray(registryConfigs);

        Arrays.sort(registryConfigs, new Comparator<ProviderConfig>() {
            @Override
            public int compare(ProviderConfig o1, ProviderConfig o2) {

                if(o1.getCallTime() < o2.getCallTime()){
                    return -1;
                }

                else  if(o1.getCallTime() == o2.getCallTime()){
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
        return registryConfigs[0];
    }


    public static void leastActiveLoadbalance(LoadbalanceStrategy strategy, int configNum){
        List<ProviderConfig> configs = new ArrayList<>();

        for(int i = 0; i< configNum; i++){
            ProviderConfig config = new ProviderConfig();
            config.setInterfaceName("com.serviceImpl");
            config.setHost("127.0.0.1");
            config.setPort(i);
            config.setWeight(i);
            //这里使用随机数来模拟调用耗时。
            config.setCallTime(new Random().nextInt(100));
            configs.add(config);
        }

        for(ProviderConfig c:configs){
            System.out.println("序号:" + c.getPort()  +"--时延:" + c.getCallTime() );
        }
        System.out.println("--------------");
        ProviderConfig config = strategy.select(configs,null);
        System.out.println("最终选择　序号:" + config.getPort()  +"--时延:" + config.getCallTime() );

    }


    public static void main(String[] args) {
        System.out.println("\r\n最小时延负载均衡.....");
        LoadbalanceStrategy strategy5 = new LeastActiveLoadbalanceStrategy();
        leastActiveLoadbalance(strategy5,10);
    }
}
