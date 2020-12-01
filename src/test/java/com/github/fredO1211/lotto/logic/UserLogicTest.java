package com.github.fredO1211.lotto.logic;

import com.github.fredO1211.lotto.messagegenerator.MessageGenerator;
import com.github.fredO1211.lotto.lottocompany.LottoCompany;
import com.github.fredO1211.lotto.user.User;
import com.github.fredO1211.lotto.user.UserLogic;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class UserLogicTest {
    @Test
    public void notEnoughMoneyForCouponTest() throws Exception {
        User user = new User(LottoCompany.getCouponCost() - 1);
        UserLogic userLogic = new UserLogic(user);
        var userBalance = user.getBalance();

        String consoleMsg = tapSystemOut(userLogic::buyCoupon);

        Assert.assertEquals(userBalance, user.getBalance());
        Assert.assertEquals(MessageGenerator.NOT_ENOUGH_MONEY_MSG, consoleMsg.trim());
    }

    @Test
    public void incorrectValueDuringFillNumbersOfCouponTest() throws Exception {
        User user = new User(LottoCompany.getCouponCost());
        UserLogic userLogic = new UserLogic(user);

        String userData = "R\r\n1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n";

        System.setIn(new ByteArrayInputStream(userData.getBytes()));
        String consoleMsg = tapSystemOut(userLogic::pickNumbers);

        Assert.assertTrue(consoleMsg.contains(MessageGenerator.INVALID_VALUE_MSG));
    }

    @Test
    public void correctCouponPurchaseTest() {
        User user = new User(LottoCompany.getCouponCost());
        UserLogic userLogic = new UserLogic(user);
        var countOfUserCoupons = user.getCoupons().size();

        String userData = "1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n";

        System.setIn(new ByteArrayInputStream(userData.getBytes()));
        userLogic.buyCoupon();

        Assert.assertEquals(0, user.getBalance());
        Assert.assertEquals(countOfUserCoupons + 1, user.getCoupons().size());
    }
}