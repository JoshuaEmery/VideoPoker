package com.example.videopoker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] cardImageIds;
    ImageView[] imageViews;
    TextView[] textViews;
    TextView txtBank;
    Deck deck;
    Hand hand;
    Button btnDraw;
    Button btnNew;
    HandAnalyzer analyzer;
    int bankRoll;
    boolean[] held;
    boolean[] result;
    int[] payTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bankRoll = 100;
        held = new boolean[5];
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        setAltCardImageIds();
        setImageViews();
        setTextViews();
        setDeck();
        setButtons();
        resetImageViews();
        setPayTable();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideActionBar();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideActionBar();
    }

    private void setCardImageIds(){
        cardImageIds = new int[52];
        int count =0;
        cardImageIds[count] = R.drawable.two_of_spades;
        count++;
        cardImageIds[count] = R.drawable.two_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.two_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.two_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.three_of_spades;
        count++;
        cardImageIds[count] = R.drawable.three_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.three_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.three_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.four_of_spades;
        count++;
        cardImageIds[count] = R.drawable.four_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.four_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.four_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.five_of_spades;
        count++;
        cardImageIds[count] = R.drawable.five_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.five_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.five_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.six_of_spades;
        count++;
        cardImageIds[count] = R.drawable.six_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.six_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.six_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.seven_of_spades;
        count++;
        cardImageIds[count] = R.drawable.seven_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.seven_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.seven_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.eight_of_spades;
        count++;
        cardImageIds[count] = R.drawable.eight_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.eight_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.eight_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.nine_of_spades;
        count++;
        cardImageIds[count] = R.drawable.nine_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.nine_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.nine_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.ten_of_spades;
        count++;
        cardImageIds[count] = R.drawable.ten_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.ten_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.ten_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.jack_of_spades;
        count++;
        cardImageIds[count] = R.drawable.jack_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.jack_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.jack_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.queen_of_spades;
        count++;
        cardImageIds[count] = R.drawable.queen_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.queen_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.queen_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.king_of_spades;
        count++;
        cardImageIds[count] = R.drawable.king_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.king_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.king_of_clubs;
        count++;
        cardImageIds[count] = R.drawable.ace_of_spades;
        count++;
        cardImageIds[count] = R.drawable.ace_of_hearts;
        count++;
        cardImageIds[count] = R.drawable.ace_of_diamonds;
        count++;
        cardImageIds[count] = R.drawable.ace_of_clubs;
    }
    private void setAltCardImageIds(){
        cardImageIds = new int[52];
        int count =0;
        cardImageIds[count] = R.drawable.s02;
        count++;
        cardImageIds[count] = R.drawable.h02;
        count++;
        cardImageIds[count] = R.drawable.d02;
        count++;
        cardImageIds[count] = R.drawable.c02;
        count++;
        cardImageIds[count] = R.drawable.s03;
        count++;
        cardImageIds[count] = R.drawable.h03;
        count++;
        cardImageIds[count] = R.drawable.d03;
        count++;
        cardImageIds[count] = R.drawable.c03;
        count++;
        cardImageIds[count] = R.drawable.s04;
        count++;
        cardImageIds[count] = R.drawable.h04;
        count++;
        cardImageIds[count] = R.drawable.d04;
        count++;
        cardImageIds[count] = R.drawable.c04;
        count++;
        cardImageIds[count] = R.drawable.s05;
        count++;
        cardImageIds[count] = R.drawable.h05;
        count++;
        cardImageIds[count] = R.drawable.d05;
        count++;
        cardImageIds[count] = R.drawable.c05;
        count++;
        cardImageIds[count] = R.drawable.s06;
        count++;
        cardImageIds[count] = R.drawable.h06;
        count++;
        cardImageIds[count] = R.drawable.d06;
        count++;
        cardImageIds[count] = R.drawable.c06;
        count++;
        cardImageIds[count] = R.drawable.s07;
        count++;
        cardImageIds[count] = R.drawable.h07;
        count++;
        cardImageIds[count] = R.drawable.d07;
        count++;
        cardImageIds[count] = R.drawable.c07;
        count++;
        cardImageIds[count] = R.drawable.s08;
        count++;
        cardImageIds[count] = R.drawable.h08;
        count++;
        cardImageIds[count] = R.drawable.d08;
        count++;
        cardImageIds[count] = R.drawable.c08;
        count++;
        cardImageIds[count] = R.drawable.s09;
        count++;
        cardImageIds[count] = R.drawable.h09;
        count++;
        cardImageIds[count] = R.drawable.d09;
        count++;
        cardImageIds[count] = R.drawable.c09;
        count++;
        cardImageIds[count] = R.drawable.s10;
        count++;
        cardImageIds[count] = R.drawable.h10;
        count++;
        cardImageIds[count] = R.drawable.d10;
        count++;
        cardImageIds[count] = R.drawable.c10;
        count++;
        cardImageIds[count] = R.drawable.s11;
        count++;
        cardImageIds[count] = R.drawable.h11;
        count++;
        cardImageIds[count] = R.drawable.d11;
        count++;
        cardImageIds[count] = R.drawable.c11;
        count++;
        cardImageIds[count] = R.drawable.s12;
        count++;
        cardImageIds[count] = R.drawable.h12;
        count++;
        cardImageIds[count] = R.drawable.d12;
        count++;
        cardImageIds[count] = R.drawable.c12;
        count++;
        cardImageIds[count] = R.drawable.s13;
        count++;
        cardImageIds[count] = R.drawable.h13;
        count++;
        cardImageIds[count] = R.drawable.d13;
        count++;
        cardImageIds[count] = R.drawable.c13;
        count++;
        cardImageIds[count] = R.drawable.s01;
        count++;
        cardImageIds[count] = R.drawable.h01;
        count++;
        cardImageIds[count] = R.drawable.d01;
        count++;
        cardImageIds[count] = R.drawable.c01;
    }
    private void setImageViews(){
        imageViews = new ImageView[5];
        imageViews[0] = findViewById(R.id.imgCard1);
        imageViews[1] = findViewById(R.id.imgCard2);
        imageViews[2] = findViewById(R.id.imgCard3);
        imageViews[3] = findViewById(R.id.imgCard4);
        imageViews[4] = findViewById(R.id.imgCard5);

    }
    private void setTextViews(){
        textViews = new TextView[10];
        textViews[0] = findViewById(R.id.txtCard1);
        textViews[1] = findViewById(R.id.txtCard2);
        textViews[2] = findViewById(R.id.txtCard3);
        textViews[3] = findViewById(R.id.txtCard4);
        textViews[4] = findViewById(R.id.txtCard5);
        textViews[5] = findViewById(R.id.txtHeld1);
        textViews[6] = findViewById(R.id.txtHeld2);
        textViews[7] = findViewById(R.id.txtHeld3);
        textViews[8] = findViewById(R.id.txtHeld4);
        textViews[9] = findViewById(R.id.txtHeld5);
        txtBank = findViewById(R.id.txtBank);
    }
    private void setDeck(){
        deck = new Deck();
        int k = 0;
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.addCard(new Card(i, j, cardImageIds[k]));
                k++;
            }
        }
    }
    private void setPayTable(){
        payTable = new int[10];
        payTable[0] = 0;
        payTable[1] = 1;
        payTable[2] = 2;
        payTable[3] = 3;
        payTable[4] = 4;
        payTable[5] = 6;
        payTable[6] = 9;
        payTable[7] = 25;
        payTable[8] = 90;
        payTable[9] = 800;
    }
    private void newGame(){
        hand = new Hand(deck);
        hand.drawCards();
        for (int i = 0; i < held.length; i++) {
            held[i] = false;
            textViews[5+i].setVisibility(View.INVISIBLE);
            imageViews[i].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void drawCards(){
        hand.setHeld(held);
        hand.drawCards();
    }
    private void displayHand(){
        Card[] cards = hand.getCards();
        for (int i = 0; i < cards.length; i++) {
            imageViews[i].setImageResource(cards[i].getImgId());
            textViews[i].setText(cards[i].toString());
        }
    }
    private void setButtons(){
        btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankRoll -=5;
                txtBank.setText("Credits $" + String.valueOf(bankRoll));
                setDeck();
                newGame();
                enableImageListeners();
                displayHand();
                analyzeHand();
                displayAnalyzerResult();
                btnNew.setVisibility(View.INVISIBLE);
                btnDraw.setVisibility(View.VISIBLE);
            }
        });
        btnDraw = findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawCards();
                displayHand();
                analyzeHand();
                disableImageListeners();
                payout(5);
                displayAnalyzerResult();
                txtBank.setText("Bankroll: " + String.valueOf(bankRoll));
                btnNew.setVisibility(View.VISIBLE);
                btnDraw.setVisibility(View.INVISIBLE);


            }
        });
    }
    private void analyzeHand(){
        analyzer = new HandAnalyzer(hand);
        result = analyzer.analyzeHand();
    }
    private void displayAnalyzerResult(){
        Resources res = getResources();
        String[] pokerHands = res.getStringArray(R.array.poker_hands);
        for (int i = pokerHands.length - 1; i >= 0; i--) {
            if(i==0)
                return;
            if(result[i]){
                Toast.makeText(getApplicationContext(),  pokerHands[i]+", You win!",Toast.LENGTH_SHORT).show();
                return;
            }

        }
    }
    private void enableImageListeners(){
        imageViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[0]){
                    held[0] = false;
                    imageViews[0].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    textViews[5].setVisibility(View.INVISIBLE);
                }
                else{
                    held[0] = true;
                    imageViews[0].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    textViews[5].setVisibility(View.VISIBLE);

                }
            }
        });
        imageViews[1] = findViewById(R.id.imgCard2);
        imageViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[1]){
                    held[1] = false;
                    imageViews[1].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    textViews[6].setVisibility(View.INVISIBLE);
                }
                else{
                    held[1] = true;
                    imageViews[1].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    textViews[6].setVisibility(View.VISIBLE);

                }
            }
        });
        imageViews[2] = findViewById(R.id.imgCard3);
        imageViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[2]){
                    held[2] = false;
                    imageViews[2].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    textViews[7].setVisibility(View.INVISIBLE);
                }
                else{
                    held[2] = true;
                    imageViews[2].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    textViews[7].setVisibility(View.VISIBLE);
                }
            }
        });
        imageViews[3] = findViewById(R.id.imgCard4);
        imageViews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[3]){
                    held[3] = false;
                    imageViews[3].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    textViews[8].setVisibility(View.INVISIBLE);
                }
                else{
                    held[3] = true;
                    imageViews[3].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    textViews[8].setVisibility(View.VISIBLE);

                }
            }
        });
        imageViews[4] = findViewById(R.id.imgCard5);
        imageViews[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[4]){
                    held[4] = false;
                    imageViews[4].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    textViews[9].setVisibility(View.INVISIBLE);
                }
                else{
                    held[4] = true;
                    imageViews[4].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    textViews[9].setVisibility(View.VISIBLE);

                }
            }
        });
    }
    private void disableImageListeners(){
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setOnClickListener(null);
        }
    }
    private void payout(int wager){
        for (int i = payTable.length -1; i >=0 ; i--) {
            if(i==0)
                return;
            if(result[i]){
                int pay = wager * payTable[i];
                bankRoll += pay;
                Toast.makeText(getApplicationContext(),"You won " + pay + " dollars",Toast.LENGTH_SHORT);
            }
        }
    }
    private void resetImageViews(){
        for (int i = 0; i <imageViews.length ; i++) {
            imageViews[i].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    private void hideActionBar(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}