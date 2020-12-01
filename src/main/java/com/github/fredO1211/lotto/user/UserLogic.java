package com.github.fredO1211.lotto.user;

import com.github.fredO1211.lotto.coupon.CouponLogic;
import com.github.fredO1211.lotto.lottocompany.LottoCompanyLogic;
import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;
import com.github.fredO1211.lotto.coupon.Coupon;
import com.github.fredO1211.lotto.lottocompany.LottoCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (numbers.size() < Coupon.getCouponSize()) {
            System.out.println(MessageGenerator.PICK_NUMBER_MSG);
            try {
                String gettingValue = reader.readLine();
                numbers.add(Integer.parseInt(gettingValue));
            } catch (NumberFormatException | IOException e) {
                System.out.println(MessageGenerator.INVALID_VALUE_MSG);
            }
        }
        return numbers;
    }

    public void checkAllCoupons(Set<Integer> winningsNumbers) {
        if (user.getCoupons().size() > 0) {
            for (Coupon coupon : user.getCoupons()) {
                System.out.println(coupon.getNumbers());
                user.setBalance(user.getBalance() + new CouponLogic(coupon).realiseCoupon(winningsNumbers));
            }
            MessageGenerator.printBalance(user);
            user.getCoupons().clear();
        } else {
            System.out.println(MessageGenerator.EMPTY_COUPONS_ARRAY_MSG);
        }
    }
}
