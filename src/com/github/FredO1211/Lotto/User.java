package com.github.FredO1211.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User {
    private ArrayList<Coupon> coupons = new ArrayList<>();
    private int balance;

    public User(int balance) {
        this.balance = balance;
    }

    int getBalance() {
        return balance;
    }

    public void printMyCoupons() {
        System.out.println("Twoje kupony:");
        for (Coupon coupon : coupons) {
            System.out.println(coupon.getNumbers());
        }
    }

    public void buyCoupon() {
        if (balance < LottoCompany.getCouponCost()) {
            System.out.println(MessageGenerator.NOT_ENOUGH_MONEY_MSG);
        } else {
            Set<Integer> userNumbers;
            do {
                userNumbers = pickNumbers();
            } while (LottoCompany.validCoupon(userNumbers).isEmpty());
            coupons.add(LottoCompany.validCoupon(userNumbers).get());

            balance -= LottoCompany.getCouponCost();
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
        if (coupons.size() > 0) {
            for (Coupon coupon : coupons) {
                balance += coupon.realiseCoupon(winningsNumbers);
                MessageGenerator.printBalance(this);
            }
            coupons.clear();
        } else {
            System.out.println(MessageGenerator.EMPTY_COUPONS_ARRAY_MSG);
        }
    }

}
