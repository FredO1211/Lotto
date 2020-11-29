package com.github.FredO1211.Lotto;

import com.github.FredO1211.Game;
import com.github.FredO1211.Lotto.logic.LottoCompanyLogic;
import com.github.FredO1211.Lotto.logic.UserLogic;
import com.github.FredO1211.Lotto.messagegenerator.MessageGenerator;
import com.github.FredO1211.Lotto.model.User;

import java.util.Scanner;

public class LottoGame implements Game {
    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        User user = new User(35);
        UserLogic userLogic = new UserLogic(user);

        while (true) {
            System.out.println(MessageGenerator.MENU_MSG);

            int index = scanner.nextInt();

            if (index == 1) {
                userLogic.buyCoupon();
            } else if (index == 2) {
                userLogic.checkAllCoupons(LottoCompanyLogic.drawNumbers());
            } else if (index == 3) {
                user.printCoupons();
            } else {
                System.out.println(MessageGenerator.INVALID_MENU_OPTION_MSG);
            }
        }
    }
}
