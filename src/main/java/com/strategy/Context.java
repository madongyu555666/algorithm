package com.strategy;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/717:41
 */
public class Context {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod(){
        strategy.strategyMethod();
    }
}
