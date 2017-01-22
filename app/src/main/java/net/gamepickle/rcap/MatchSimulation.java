package net.gamepickle.rcap;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MatchSimulation extends AppCompatActivity {



    Button play = (Button) findViewById(R.id.play);
    Button pause = (Button) findViewById(R.id.pause);
    Button home = (Button) findViewById(R.id.Home);
    int rcapStats = 75;
    int otherTeamStats = 50;
    int rcapHappiness = 50;
    boolean clicked = false;
    int rcapScore=0;
    int otherScore=0;
    TextView scoreRcap = (TextView) findViewById(R.id.Rcap);
    TextView scoreOther = (TextView) findViewById(R.id.notRcap);
    TextView t = (TextView) findViewById(R.id.textView);

    CountDownTimer timer = new CountDownTimer(60000,3000) {
        @Override
        public void onTick(long millisUntilFinished) {
            match(rcapStats,otherTeamStats,rcapHappiness);
            scoreRcap.setText(String.valueOf(rcapScore));
            scoreOther.setText(String.valueOf(otherScore));
            home.setEnabled(false);
        }

        @Override
        public void onFinish() {
            if(rcapScore>otherScore){
                t.setText("You win!!!");
            }else if(rcapScore<otherScore){
                t.setText("You lose...");
            }else {
                t.setText("It's a tie.");
            }
            clicked=true;
            home.setEnabled(true);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_simulation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent main=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();

            }
        });



    }

    public void match(int rcapStats, int otherTeamStats, int playerHappiness){
        Random rand = new Random();
        int number = rand.nextInt(100);
        int result;
        int happinessModifier=playerHappiness;




        int limit = 50 + ((rcapStats - otherTeamStats) * (3 / 2))+(happinessModifier-50);

        int tie;
        if(rcapStats-otherTeamStats==0){
            tie =20;
        }else{
            tie = Math.abs(1/(rcapStats-otherTeamStats)*15);
        }

        if(number > limit+tie){
            //result= 0;
            otherScore++;
        }
        else if(number<=limit+tie&&number>=limit-tie){
            //result= 1;
        }else if (number < limit-tie){
            rcapScore++;
            //result= 2;
        } else {
            //result =3;
            t.setText("Problématique..."+number);

        }

        /*switch(result){
            case 0:
                otherScore++;
                break;
            case 1:
                break;
            case 2:
                rcapScore++;
                break;
            case 3:
                t.setText("Problématique..."+number);
                break;
        }*/



        }
}
