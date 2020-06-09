package com.example.videopoker;

import java.util.HashMap;

public class HandAnalyzer {
    private Hand hand;
    private boolean[] handScore;
    private Card[] cards;
    private HashMap<Integer, Integer> frequency;

    public HandAnalyzer(Hand hand) {
        this.hand = hand;
        cards = hand.getCards();
        frequency = new HashMap<Integer, Integer>();
        handScore = new boolean[10];
    }

    public boolean[] analyzeHand() {
        pairAnalyzer();
        if (!handScore[0]) {
            straightFlushAnalyzer();
        }
        return handScore;
    }

    public void pairAnalyzer() {
        for (int i = 0; i < cards.length; i++) {
            Card card = cards[i];
            int count = frequency.containsKey(card.getValue()) ? frequency.get(card.getValue()) : 0;
            frequency.put(card.getValue(), count + 1);
        }
        switch (frequency.size()) {
            case 5:
                return;
            case 4:
                handScore[0] = true;
                if (checkPairJacks())
                    handScore[1] = true;
                return;
            case 3:
                if (checkThreeKind())
                    handScore[3] = true;
                else
                    handScore[2] = true;
                return;
            case 2:
                if (checkFourKind())
                    handScore[7] = true;
                else
                    handScore[6] = true;
                return;
        }
    }

    public void straightFlushAnalyzer() {
        int[] minMaxValues = getMinMaxValues();
        if(minMaxValues[1] - minMaxValues[0] == 4)
            handScore[4] = true;
        else if(minMaxValues[1] - minMaxValues[0] == 12 && minMaxValues[2] - minMaxValues[0] == 3)
            handScore[4] = true;
        if(checkFlush())
            handScore[5] = true;
        if(handScore[4] && handScore[5]){
            handScore[8] = true;
            if(minMaxValues[0] == 10)
                handScore[9] = true;
        }
    }

    private boolean checkPairJacks() {
        for (int i = 0; i < cards.length; i++) {
            if (frequency.get(cards[i].getValue()) == 2 && cards[i].getValue() >= 11)
                return true;
        }
        return false;
    }

    private boolean checkThreeKind() {
        if (getMaxFrequency() == 3)
            return true;
        return false;
    }

    private boolean checkFourKind() {
        if (getMaxFrequency() == 4)
            return true;
        return false;
    }

    private int getMaxFrequency() {
        int max = 0;
        for (int i = 0; i < cards.length; i++) {
            int value = frequency.get(cards[i].getValue());
            if (value > max)
                max = value;
        }
        return max;
    }
    private int[] getMinMaxValues(){
        int minValue = 15, maxValue = 0, secondMax = 0;
        for (int i = 0; i <cards.length ; i++) {
            int value = cards[i].getValue();
            if(value < minValue)
                minValue = value;
            if(value > maxValue){
                secondMax = maxValue;
                maxValue = value;
            }
            else if(value > secondMax)
                secondMax = value;

        }
        return new int[] {minValue, maxValue, secondMax};
    }
    private boolean checkFlush(){
        boolean flush = true;
        String suit = cards[0].getSuit();
        for (int i = 0; i <cards.length ; i++) {
            if(!suit.equals(cards[i].getSuit())){
                flush = false;
                break;
            }
        }
        return flush;
    }
}