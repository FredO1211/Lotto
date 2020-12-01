package com.github.fredO1211.lotto.coupon;

import com.github.fredO1211.lotto.lottocompany.LottoCompany;
import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;

import java.util.Set;

public class CouponLogic {
    Coupon coupon;

    public CouponLogic(Coupon coupon) {
        this.coupon = coupon;
    }

    public int realiseCoupon(Set<Integer> winningNumbers) {
        int correctNumbersCounter = (int) coupon.getNumbers().stream()
                .filter(winningNumbers::contains).count();

        MessageGenerator.resultMessage(correctNumbersCounter);
        return LottoCompany.getWinningValue(correctNumbersCounter);
    }
}
