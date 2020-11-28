package com.github.FredO1211.Lotto;

import java.util.*;

public class LottoCompany {
    private static final int COUPON_COST = 3;

    private static Map<Integer, Integer> winningAmountMap = new HashMap<>();

    static {
        winningAmountMap.put(0, 0);
        winningAmountMap.put(1, 0);
        winningAmountMap.put(2, 0);
        winningAmountMap.put(3, 24);
        winningAmountMap.put(4, 300);
        winningAmountMap.put(5, 5000);
        winningAmountMap.put(6, 1000000);
    }

    static int getCouponCost() {
        return COUPON_COST;
    }

    static int getWinningValue(Integer quantityOfCorrectNumbers) {
        return LottoCompany.getWinningAmountMap().get(quantityOfCorrectNumbers);
    }

    static Map<Integer, Integer> getWinningAmountMap() {
        return winningAmountMap;
    }

    public static Set<Integer> drawNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            numbers.add(random.nextInt(98) + 1);
        }
        System.out.println(MessageGenerator.BEFORE_DRAW_MSG);
        numbers.stream().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();
        return numbers;
    }

    public static Optional<Coupon> validCoupon(Set<Integer> numbers) {
        if (numbers.stream()
                .allMatch(number -> number > 0 && number < 100)) {
            return Optional.of(new Coupon(numbers));
        }
        System.out.println(MessageGenerator.WRONG_COUPON_MSG);
        return Optional.empty();
    }

}
