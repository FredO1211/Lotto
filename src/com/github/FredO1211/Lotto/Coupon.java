package com.github.FredO1211.Lotto;

import java.util.Set;

public class Coupon {
    private final Set<Integer> numbers;

    public Coupon(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int realiseCoupon(Set<Integer> winningNumbers) {
        int correctNumbersCounter = (int) numbers.stream()
                .filter(winningNumbers::contains).count();

        MessageGenerator.resultMessage(correctNumbersCounter);
        return LottoCompany.getWinningValue(correctNumbersCounter);
    }
}
