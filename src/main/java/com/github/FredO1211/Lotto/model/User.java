package com.github.FredO1211.Lotto.model;

import java.util.ArrayList;

public class User {
    private ArrayList<Coupon> coupons = new ArrayList<>();
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
        System.out.println("Twoje kupony:");
        for (Coupon coupon : coupons) {
            System.out.println(coupon.getNumbers());
        }
    }
}
