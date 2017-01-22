package net.gamepickle.rcap;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    GameVariables gameVariables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        gameVariables = new GameVariables(this);

        gameVariables.setPlayer_stats(50);
        gameVariables.setPlayer_happiness(50);

        ImageButton changeScreen = (ImageButton) findViewById(R.id.Changing_Room);

        changeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent match=new Intent(getApplicationContext(), Simulation.class);
                startActivity(match);
            }
        });
    }





}
