package net.gamepickle.rcap;

import android.app.Activity;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    GameVariables gameVariables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameVariables = new GameVariables(this);

        gameVariables.setPlayer_stats(50);
        gameVariables.setPlayer_happiness(50);

        Button changeScreen;
        //changeScreen = new Button().findViewById(R.id.Changing_Room);
    }

        public Pair<Integer, Integer> match(){
            int rcapGoals = 0;
            int otherGoals = 0;
            return new Pair<Integer,Integer>(rcapGoals, otherGoals);
        }



}
