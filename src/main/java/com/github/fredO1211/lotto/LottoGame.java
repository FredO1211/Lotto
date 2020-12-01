package com.github.fredO1211.lotto;

import com.github.fredO1211.Game;
import com.github.fredO1211.lotto.lottocompany.LottoCompanyLogic;
import com.github.fredO1211.lotto.user.UserLogic;
import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;
import com.github.fredO1211.lotto.user.User;

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
        final int INVALID_VALUE = -1;
        final int QUIT = 0;
        final int BUY_COUPONS = 1;
        final int CHECK_ALL_COUPONS = 2;
        final int PRINT_COUPONS = 3;


        Scanner scanner = new Scanner(System.in);
        Integer choice;

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            choice = INVALID_VALUE;
        }

        switch (choice) {
            case QUIT:
                System.out.println(MessageGenerator.THANKS_FOR_GAME);
                Runtime.getRuntime().exit(0);
                break;
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
