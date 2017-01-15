package net.gamepickle.rcap;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Created by Joseph on 21/12/2016.
 */

public class GameVariables{
    private int cash;
    private int popularity;
    private int player_stats;
    private int player_happiness;
    private Context mContext;

    public GameVariables(Context context) {
        String file_name = "Stats";
        mContext = context;

        // Stats file name
        // {"CASH": int cash; "POPULARITY": int popularity;
        // "PLAYER_STATS": int player_stats; "NAME": string name
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        editor = settings.edit();

        String cash_key = "CASH";
        String popularity_key = "POPULARITY";
        String player_stats_key = "PLAYER_STATS";
        String player_happiness_key = "PLAYER_HAPPINESS";
        String name_key = "NAME";


        // Cash Variable
        // If it exists read from it else create it with a value of 0
        setCash(settings.getInt(cash_key, 0));

        // Popularity Variable
        // If it exists read from it else create it with a value of 0
        setPopularity(settings.getInt(popularity_key, 0));

        // Player_stats Variable
        // If it exists read from it else create it with a value of 0

        setPlayer_stats(settings.getInt(player_stats_key, 0));

        setPlayer_happiness(settings.getInt(player_happiness_key, 0));


    }

    public void setCash(int amount) {
        cash = amount;
        TextView t = (TextView)((Activity)mContext).findViewById(R.id.cash_text);
        t.setText(String.valueOf(cash));
    }

    public void setCash(int amount, boolean increment) {
        if(increment) {
            amount += cash;
        }
        setCash(amount);
    }

    public void setPopularity(int amount) {
        popularity = amount;
        TextView t = (TextView)((Activity)mContext).findViewById(R.id.popularity_text);
        t.setText(String.valueOf(popularity));
    }

    public void setPopularity(int amount, boolean increment) {
        if(increment) {
            amount += popularity;
        }
        setPopularity(amount);
    }

    public void setPlayer_stats(int amount) {
        player_stats = amount;
        TextView t = (TextView)((Activity)mContext).findViewById(R.id.players_text);
        t.setText(String.valueOf(player_stats));
    }


    public void setPlayer_happiness(int amount) {
        player_happiness = amount;
        //TextView t = (TextView)((Activity)mContext).findViewById(R.id.happiness_text);
        //t.setText(String.valueOf(player_happiness));
    }
}
