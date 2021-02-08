package com.strategy;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/717:40
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}
