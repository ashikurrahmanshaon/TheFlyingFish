package com.shaon.flyingfishgames.theflyingfish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class GameOverActivity extends AppCompatActivity {
    private Button StartGameAgain;
    private TextView DisplayScore;
    private String score;

    private AdRequest adRequest;
    private AdView mAdView;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);






        adRequest = new AdRequest.Builder().build();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-2606660907793468/2813421942");
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                dispAd();

            }
        });

        score = getIntent().getExtras().get("score").toString();


        StartGameAgain = (Button)findViewById(R.id.Play_again_btn);


        DisplayScore = (TextView)findViewById(R.id.displayscore);


        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(GameOverActivity.this,MainActivity.class);
                startActivity(mainIntent);
            }
        });


        DisplayScore.setText("Score =" + score );

    }


    public void dispAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
}



