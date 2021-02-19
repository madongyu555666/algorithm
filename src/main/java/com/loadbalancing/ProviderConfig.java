package com.loadbalancing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author madongyu
 * @title: ProviderConfig
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/1619:50
 */
/*@Slf4j*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderConfig {
    private static final long serialVersionUID = 1;
    //通信host
    private String host;
    //通信端口
    private Integer port;
    //请求接口名称
    private String interfaceName;
    //请求方法
    private String[] methods;
    //应用名称
    private String application;
    //权重
    private int weight;
    //调用时间
    private int callTime;
}
