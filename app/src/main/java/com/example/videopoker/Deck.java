package com.example.videopoker;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    Random rand;

    public Deck() {
        rand = new Random();
        deck = new ArrayList<>();
    }

//    private ArrayList<Card> generateNewDeck() {
//        final ArrayList<Card> result = new ArrayList<Card>();
//        for (int i = 2; i < 15; i++) {
//            for (int j = 0; j < 4; j++) {
//                result.add(new Card(i, j, 5));
//            }
//        }
//        return result;
//    }

    public void displayDeck() {
        for (final Card card : deck) {
            System.out.println(card);
        }
    }
    public void addCard(Card card){
        deck.add(card);
    }

    public void shuffleDeck() {
        for (int i = 0; i < deck.size(); i++) {
            int j;
            do {
                j = rand.nextInt(deck.size());
            } while (j == i);
            final Card card = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, card);
        }
    }

    public Card dealCard() {
        if (deck.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        shuffleDeck();
        return deck.remove(0);
    }
}
