package com.github.fredO1211.lotto.logic;

import com.github.fredO1211.lotto.coupon.CouponLogic;
import com.github.fredO1211.lotto.coupon.Coupon;
import com.github.fredO1211.lotto.lottocompany.LottoCompany;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CouponLogicTest {
    @Test
    public void realiseCouponTest_ForZeroHitNumber() {
        Set<Integer> couponNumbersSet = new HashSet<>(Arrays.asList(1, 12, 35, 68, 72, 62));
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(2, 13, 36, 69, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(couponNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(0),
                couponLogic.realiseCoupon(winningNumbersSet));
    }

    @Test
    public void realiseCouponTest_ForOneHitNumber() {
        Set<Integer> couponNumbersSet = new HashSet<>(Arrays.asList(1, 12, 35, 68, 72, 62));
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(2, 13, 36, 68, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(couponNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(1),
                couponLogic.realiseCoupon(winningNumbersSet));
    }

    @Test
    public void realiseCouponTest_ForTwoHitNumber() {
        Set<Integer> couponNumbersSet = new HashSet<>(Arrays.asList(1, 12, 35, 68, 72, 63));
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(2, 13, 36, 68, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(couponNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(2),
                couponLogic.realiseCoupon(winningNumbersSet));
    }

    @Test
    public void realiseCouponTest_ForThreeHitNumber() {
        Set<Integer> couponNumbersSet = new HashSet<>(Arrays.asList(1, 12, 35, 68, 72, 63));
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(1, 13, 36, 68, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(couponNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(3),
                couponLogic.realiseCoupon(winningNumbersSet));
    }

    @Test
    public void realiseCouponTest_ForFourHitNumber() {
        Set<Integer> couponNumbersSet = new HashSet<>(Arrays.asList(1, 12, 36, 68, 72, 62));
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(1, 12, 36, 68, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(couponNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(4),
                couponLogic.realiseCoupon(winningNumbersSet));
    }

    @Test
    public void realiseCouponTest_ForFiveHitNumber() {
        Set<Integer> couponNumbersSet = new HashSet<>(Arrays.asList(1, 12, 36, 68, 73, 62));
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(1, 12, 36, 68, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(couponNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(5),
                couponLogic.realiseCoupon(winningNumbersSet));
    }

    @Test
    public void realiseCouponTest_ForSixHitNumber() {
        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(1, 12, 36, 68, 73, 63));
        CouponLogic couponLogic = new CouponLogic(new Coupon(winningNumbersSet));

        Assert.assertEquals(
                LottoCompany.getWinningValue(6),
                couponLogic.realiseCoupon(winningNumbersSet));
    }
}