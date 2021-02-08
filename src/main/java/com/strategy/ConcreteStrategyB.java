package com.strategy;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/717:41
 */
public class ConcreteStrategyB implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}
