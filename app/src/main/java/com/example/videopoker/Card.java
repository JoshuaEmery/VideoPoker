package com.example.videopoker;

public class Card {
    private final int imgId;
    private final int value;
    private final int suitId;
    private final String suit;
    final String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };

    public Card(int value, int suitId, int imgId) {
        this.imgId = imgId;
        this.value = value;
        this.suitId = suitId;
        this.suit = suits[suitId];
    }

    public int getImgId() {
        return this.imgId;
    }

    public int getValue() {
        return this.value;
    }

    public int getSuitId() {
        return this.suitId;
    }

    public String getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return getDisplayValue() + " of " + getSuit();
    }

    private String getDisplayValue() {
        switch (value) {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return Integer.toString(getValue());
        }
    }

}