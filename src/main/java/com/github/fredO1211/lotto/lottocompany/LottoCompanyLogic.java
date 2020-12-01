package com.github.fredO1211.lotto.lottocompany;

import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;
import com.github.fredO1211.lotto.coupon.Coupon;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class LottoCompanyLogic {

    public static Set<Integer> drawNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < Coupon.getCouponSize()) {
            numbers.add(random.nextInt(Coupon.getCouponRage() - 1) + 1);
        }

        System.out.println(MessageGenerator.BEFORE_DRAW_MSG);
        numbers.stream().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();
        return numbers;
    }

    public static Optional<Coupon> validCoupon(Set<Integer> numbers) {
        if (numbers.stream()
                .allMatch(number -> number > 0 && number <= Coupon.getCouponRage())) {
            return Optional.of(new Coupon(numbers));
        }
        System.out.println(MessageGenerator.WRONG_COUPON_MSG);
        return Optional.empty();
    }

}
