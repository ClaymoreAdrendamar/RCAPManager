package net.gamepickle.rcap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static net.gamepickle.rcap.R.id.Name;
import static net.gamepickle.rcap.R.id.cash_text;
import static net.gamepickle.rcap.R.id.players_text;
import static net.gamepickle.rcap.R.id.popularity_text;

public class MainActivity extends AppCompatActivity {
    GameVariables gameVars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseHeader();
    }

    private void initialiseHeader() {
        gameVars = new GameVariables(this);
        gameVars.setInt("CASH", 2, cash_text);
        gameVars.setInt("POPULARITY", 42, popularity_text);
        gameVars.setInt("PLAYER_STATS", 3, players_text);
        gameVars.setString("NAME", gameVars.getString("NAME"), Name);
    }
}
