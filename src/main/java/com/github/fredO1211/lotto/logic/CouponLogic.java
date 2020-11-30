package com.github.fredO1211.lotto.logic;

import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;
import com.github.fredO1211.lotto.model.Coupon;
import com.github.fredO1211.lotto.model.LottoCompany;

import java.util.Set;

public class CouponLogic {
    Coupon coupon;

    CouponLogic(Coupon coupon) {
        this.coupon = coupon;
    }

    public int realiseCoupon(Set<Integer> winningNumbers) {
        int correctNumbersCounter = (int) coupon.getNumbers().stream()
                .filter(winningNumbers::contains).count();

        MessageGenerator.resultMessage(correctNumbersCounter);
        return LottoCompany.getWinningValue(correctNumbersCounter);
    }
}
