package com.github.fredO1211.lotto;

import com.github.fredO1211.Game;
import com.github.fredO1211.lotto.logic.LottoCompanyLogic;
import com.github.fredO1211.lotto.logic.UserLogic;
import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;
import com.github.fredO1211.lotto.model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoGame implements Game {
    User user = new User(35);
    UserLogic userLogic = new UserLogic(user);

    @Override
    public void play() {
        while (true) {
            System.out.println(MessageGenerator.MENU_MSG);
            handleMenu();
        }
    }

    private void handleMenu() {
        final int INVALID_VALUE = 0;
        final int BUY_COUPONS = 1;
        final int CHECK_ALL_COUPONS = 2;
        final int PRINT_COUPONS = 3;


        Scanner scanner = new Scanner(System.in);
        Integer choice = null;

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            choice = INVALID_VALUE;
        }

        switch (choice) {
            case BUY_COUPONS:
                userLogic.buyCoupon();
                break;
            case CHECK_ALL_COUPONS:
                userLogic.checkAllCoupons(LottoCompanyLogic.drawNumbers());
                break;
            case PRINT_COUPONS:
                user.printCoupons();
                break;
            default:
                System.out.println(MessageGenerator.INVALID_VALUE_MSG);
                break;
        }
    }
}
