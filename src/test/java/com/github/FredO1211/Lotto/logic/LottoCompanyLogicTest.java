package com.github.FredO1211.Lotto.logic;

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
}