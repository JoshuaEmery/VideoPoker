package com.example.videopoker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
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
    Deck deck;
    Hand hand;
    Button btn;
    Button btn2;
    HandAnalyzer analyzer;
    boolean[] held;
    boolean[] result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        held = new boolean[5];
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        setCardImageIds();
        setImageViews();
        setTextViews();
        setDeck();
        setButton();
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
    private void setImageViews(){
        imageViews = new ImageView[5];
        imageViews[0] = findViewById(R.id.imgCard1);
        imageViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[0])
                    held[0] = false;
                else
                    held[0] = true;
            }
        });
        imageViews[1] = findViewById(R.id.imgCard2);
        imageViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[1])
                    held[1] = false;
                else
                    held[1] = true;
            }
        });
        imageViews[2] = findViewById(R.id.imgCard3);
        imageViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[2])
                    held[2] = false;
                else
                    held[2] = true;
            }
        });
        imageViews[3] = findViewById(R.id.imgCard4);
        imageViews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[3])
                    held[3] = false;
                else
                    held[3] = true;
            }
        });
        imageViews[4] = findViewById(R.id.imgCard5);
        imageViews[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(held[4])
                    held[4] = false;
                else
                    held[4] = true;
            }
        });
    }
    private void setTextViews(){
        textViews = new TextView[5];
        textViews[0] = findViewById(R.id.txtCard1);
        textViews[1] = findViewById(R.id.txtCard2);
        textViews[2] = findViewById(R.id.txtCard3);
        textViews[3] = findViewById(R.id.txtCard4);
        textViews[4] = findViewById(R.id.txtCard5);
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
    private void newHand(){
        hand = new Hand(deck);
        hand.drawCards();
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
    private void setButton(){
        btn = findViewById(R.id.btnDraw);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDeck();
                newHand();
                displayHand();
                analyzeHand();
                displayAnalyzerResult();
            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawCards();
                displayHand();
                analyzeHand();
                displayAnalyzerResult();
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
            if(result[i]){
                Toast.makeText(getApplicationContext(), pokerHands[i],Toast.LENGTH_SHORT).show();
                return;
            }

        }
    }
    private void hideActionBar(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}