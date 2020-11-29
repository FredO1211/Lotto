package com.github.FredO1211.Lotto.logic;

import com.github.FredO1211.Lotto.messagegenerator.MessageGenerator;
import com.github.FredO1211.Lotto.model.Coupon;
import com.github.FredO1211.Lotto.model.LottoCompany;
import com.github.FredO1211.Lotto.model.User;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserLogic {
    private final User user;

    public UserLogic(User user) {
        this.user = user;
    }

    public void buyCoupon() {
        if (user.getBalance() < LottoCompany.getCouponCost()) {
            System.out.println(MessageGenerator.NOT_ENOUGH_MONEY_MSG);
        } else {
            Set<Integer> userNumbers;
            do {
                userNumbers = pickNumbers();
            } while (LottoCompanyLogic.validCoupon(userNumbers).isEmpty());
            user.getCoupons().add(LottoCompanyLogic.validCoupon(userNumbers).get());

            user.setBalance(user.getBalance() - LottoCompany.getCouponCost());
        }
    }

    public Set<Integer> pickNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (numbers.size() < 6) {
            System.out.println(MessageGenerator.PICK_NUMBER_MSG);
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    public void checkAllCoupons(Set<Integer> winningsNumbers) {
        if (user.getCoupons().size() > 0) {
            for (Coupon coupon : user.getCoupons()) {
                user.setBalance(user.getBalance() + new CouponLogic(coupon).realiseCoupon(winningsNumbers));
                MessageGenerator.printBalance(user);
            }
            user.getCoupons().clear();
        } else {
            System.out.println(MessageGenerator.EMPTY_COUPONS_ARRAY_MSG);
        }
    }

}
