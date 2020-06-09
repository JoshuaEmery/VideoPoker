package com.example.videopoker;

public class Hand {
    Card[] cards;
    boolean[] held;
    Deck deck;
    int count;

    public boolean[] getHeld() {
        return this.held;
    }

    public void setHeld(boolean[] held) {
        this.held = held;
    }

    public Card[] getCards() {
        return cards;
    }


    public Hand(Deck deck) {
        cards = new Card[5];
        held = new boolean[5];
        this.deck = deck;
        count = 0;
    }

    public void newHand() {
        deck = new Deck();
        cards = new Card[5];
        count = 0;
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.dealCard();
        }
    }

    public void drawCards() {
        for (int i = 0; i < cards.length; i++) {
            if (held[i])
                continue;
            cards[i] = deck.dealCard();
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < cards.length; i++) {
            output += cards[i] + ", ";
        }
        return output;
    }

}