package com.github.fredO1211.lotto.lottocompany;

import java.util.HashMap;
import java.util.Map;

public class LottoCompany {
    private static final int COUPON_COST = 3;

    private static final Map<Integer, Integer> winningAmountMap = new HashMap<>();

    static {
        winningAmountMap.put(0, 0);
        winningAmountMap.put(1, 0);
        winningAmountMap.put(2, 0);
        winningAmountMap.put(3, 24);
        winningAmountMap.put(4, 300);
        winningAmountMap.put(5, 5000);
        winningAmountMap.put(6, 1000000);
    }

    public static int getCouponCost() {
        return COUPON_COST;
    }

    public static int getWinningValue(Integer quantityOfCorrectNumbers) {
        return LottoCompany.getWinningAmountMap().get(quantityOfCorrectNumbers);
    }

    static Map<Integer, Integer> getWinningAmountMap() {
        return winningAmountMap;
    }
}
