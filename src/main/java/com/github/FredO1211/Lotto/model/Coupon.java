package com.github.FredO1211.Lotto.model;

import java.util.Set;

public class Coupon {
    private final Set<Integer> numbers;

    public Coupon(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
