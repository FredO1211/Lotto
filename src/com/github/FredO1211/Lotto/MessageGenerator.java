package com.github.FredO1211.Lotto;

public class MessageGenerator {
    public static final String WINNING_MSG = "Gratulacje, wygrałeś ";
    public static final String LOSING_MSG = "Niestety tym razem się nie udało wygrać";
    public static final String NOT_ENOUGH_MONEY_MSG = "Niestety nie posiadasz wystarczających środków na koncie";
    public static final String WRONG_COUPON_MSG = "Skreślone liczby są nieprawidłowe";
    public static final String PICK_NUMBER_MSG = "Skreśl liczbę:";
    public static final String BEFORE_DRAW_MSG = "W dzisiejszym losowaniu padły następujące numery: ";
    public static final String MENU_MSG = "1. Puść kupon\n2. Realizuj kupony\n3. Pokaż moje kupony";
    public static final String INVALID_MENU_OPTION_MSG = "Nieprawidłowa liczba. Spróbuj jeszcze raz!";
    public static final String EMPTY_COUPONS_ARRAY_MSG = "Nie posiadasz żadnych kuponów";
    public static final String CURRENCY = "zł";

    public static void resultMessage(Integer quantityOfCorrectNumbers) {
        int prize = LottoCompany.getWinningValue(quantityOfCorrectNumbers);

        if (prize > 0) {
            System.out.println(WINNING_MSG + prize + CURRENCY);
        } else {
            System.out.println(LOSING_MSG);
        }
    }

    public static void printBalance(User user) {
        System.out.println("Twój aktualny balans wynosi: " + user.getBalance());
    }
}
