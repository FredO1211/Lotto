package com.github.fredO1211.lotto.model;

import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;

import java.util.ArrayList;

public class User {
    private final ArrayList<Coupon> coupons = new ArrayList<>();
    private int balance;

    public User(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void printCoupons() {
        System.out.println(MessageGenerator.BEFORE_PRINT_COUPONS_MSG);
        for (Coupon coupon : coupons) {
            System.out.println(coupon.getNumbers());
        }
    }
}
