package net.gamepickle.rcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Simulation extends AppCompatActivity {


    int rcapScore = 0;
    int otherScore = 0;
    int rcapStats = 53;
    int otherTeamStats = 50;
    int playerHappiness = 50;
    int timeTilFinished = 15;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);

        Button forfeit = (Button) findViewById(R.id.forfeit);





        forfeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });
















    }

    public void pressedPlay(View view){

        TextView rcapsScore = (TextView) findViewById(R.id.textView11);
        TextView otherTeamsScore = (TextView) findViewById(R.id.textView12);
        TextView text = (TextView) findViewById(R.id.textView7);
        Button forfeit = (Button) findViewById(R.id.forfeit);


        while (timeTilFinished>0){
            match(rcapStats, otherTeamStats, playerHappiness);
            rcapsScore.setText(rcapScore+"");
            otherTeamsScore.setText(otherScore+"");
            timeTilFinished--;
            if (timeTilFinished==0){
                if(rcapScore>otherScore){
                    text.setText("Win!");
                }else if(otherScore>rcapScore){
                    text.setText("Lose...");

                }else{
                    text.setText("Tie.");
                }
                forfeit.setText("Go Home");
            }

        }


    }

    public void match(int rcapStats, int otherTeamStats, int playerHappiness){
        Random rand = new Random();
        int number = rand.nextInt(100);
        int result;
        int happinessModifier=playerHappiness;
        TextView t = (TextView) findViewById(R.id.textView7);




        int limit = 50 + ((rcapStats - otherTeamStats) * (3 / 2))+(happinessModifier-50);

        int tie;
        if(rcapStats-otherTeamStats==0){
            tie =20;
        }else{
            tie = 200*(1/(Math.abs(rcapStats-otherTeamStats)));
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
        }




    }

    public void pressedrcapMinus(View view){
        TextView rcapNewScore = (TextView) findViewById(R.id.newRcapStat);
        rcapStats--;
        rcapNewScore.setText(rcapStats+"");
    }
    public void pressedRcapPlus(View view){
        TextView rcapNewScore = (TextView) findViewById(R.id.newRcapStat);
        rcapStats++;
        rcapNewScore.setText(rcapStats+"");
    }
    public void pressedOtherMinus(View view){
        TextView otherNewScore = (TextView) findViewById(R.id.newOtherStat);
        otherTeamStats--;
        otherNewScore.setText(otherTeamStats+"");
    }

    public void pressedOtherPlus(View view){
        TextView otherNewScore = (TextView) findViewById(R.id.newOtherStat);
        otherTeamStats++;
        otherNewScore.setText(otherTeamStats+"");
    }
}
