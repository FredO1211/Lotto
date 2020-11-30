package com.github.fredO1211.lotto.model;

import java.util.Set;

public class Coupon {
    private static final int COUPON_SIZE = 6;
    private static final int COUPON_RAGE = 99;

    private final Set<Integer> numbers;

    public Coupon(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static int getCouponSize() {
        return COUPON_SIZE;
    }

    public static int getCouponRage() {
        return COUPON_RAGE;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
