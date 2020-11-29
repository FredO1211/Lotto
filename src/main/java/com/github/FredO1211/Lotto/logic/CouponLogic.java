package com.github.FredO1211.Lotto.logic;

import com.github.FredO1211.Lotto.messagegenerator.MessageGenerator;
import com.github.FredO1211.Lotto.model.Coupon;
import com.github.FredO1211.Lotto.model.LottoCompany;

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
