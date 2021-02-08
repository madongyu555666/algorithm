package com.strategy;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2021/2/717:42
 */
public class Test {

    public static void main(String[] args) {
        Context c=new Context();
        Strategy s=new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("--------");
        s=new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }
}
