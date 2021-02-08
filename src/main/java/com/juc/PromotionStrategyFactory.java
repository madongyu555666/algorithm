package com.juc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 策略模式
 * @date 2020/12/2218:43
 */
public class PromotionStrategyFactory {
    private static Map<String,PatternStrategyInterface> PROMOTION_STRATEGY_MAP = new HashMap<String,
                PatternStrategyInterface>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new PatternStrategy1());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new PatternStrategy2());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY,new PatternStrategy3());
    }

    private interface PromotionKey{
        String COUPON = "PatternStrategy1";
        String CASHBACK = "PatternStrategy2";
        String GROUPBUY = "PatternStrategy3";
    }
    //默认返回PatternStrategy1
    private static final PatternStrategy1 NON_PROMOTION = new PatternStrategy1();

    private PromotionStrategyFactory(){}

    public static PatternStrategyInterface getPatternStrategyInterface(String promotionKey){
        PatternStrategyInterface promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return  promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }


    public static void main(String[] args) {
        String promotionKey = "PatternStrategy3";
        PromotionActivity promotionActivity = new
                PromotionActivity(PromotionStrategyFactory.getPatternStrategyInterface(promotionKey));
        promotionActivity.execute();
    }
}
