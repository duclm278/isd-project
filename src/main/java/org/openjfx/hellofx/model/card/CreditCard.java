package org.openjfx.hellofx.model.card;

public class CreditCard extends Card {
    private String cvv;
    private String exprDate;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String cardHolderName, String cvv, String exprDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.exprDate = exprDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExprDate() {
        return exprDate;
    }

    public void display() {
        System.out.println(cardNumber);
        System.out.println(cardHolderName);
        System.out.println(cvv);
        System.out.println(exprDate);
        return;
    }
}
