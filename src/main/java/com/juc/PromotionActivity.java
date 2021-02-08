package com.juc;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: TODO
 * @date 2020/12/2218:51
 */
public class PromotionActivity {

    private PatternStrategyInterface promotionStrategy;

    public PromotionActivity(PatternStrategyInterface promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }
    public void execute(){
        promotionStrategy.doPromotion();
    }
}
