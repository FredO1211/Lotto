package com.github.fredO1211.lotto.logic;

import com.github.fredO1211.lotto.model.Coupon;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LottoCompanyLogicTest {
    @Test
    public void validCouponOverRangeTest() {
        Set<Integer> numbersSet = new HashSet<>(Arrays.asList(-50, 12, 36, 68, 73, 63));

        Assert.assertFalse(LottoCompanyLogic.validCoupon(numbersSet).isPresent());
    }

    @Test
    public void validCouponInRangeTest() {
        Set<Integer> numbersSet = new HashSet<>(Arrays.asList(17, 12, 36, 68, 73, 63));

        Assert.assertTrue(LottoCompanyLogic.validCoupon(numbersSet).isPresent());
    }

    @Test
    public void sizeOfDrawNumbersSetTest() {
        Assert.assertEquals(Coupon.getCouponSize(), LottoCompanyLogic.drawNumbers().size());
    }

    @Test
    public void rageOfDrawNumbersSetTest() {
        Set<Integer> testSet = LottoCompanyLogic.drawNumbers();

        Assert.assertTrue(
                testSet.stream()
                        .max(Integer::compareTo).get() <= Coupon.getCouponRage());
        Assert.assertTrue(
                testSet.stream()
                        .min(Integer::compareTo).get() > 0);
    }
}