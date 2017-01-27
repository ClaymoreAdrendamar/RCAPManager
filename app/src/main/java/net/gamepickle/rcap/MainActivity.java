package net.gamepickle.rcap;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Created by Joseph on 21/12/2016.
 */

public class GameVariables{
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    Context context;

    public GameVariables(Context context) {
        String file_name = "Stats";
        this.context = context;

        // Stats file name
        // {"CASH": int cash; "POPULARITY": int popularity;
        // "PLAYER_STATS": int player_stats; "NAME": string name

        settings = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        editor = settings.edit();

    }

    private void setText(int id, String text) {
        TextView t = (TextView) ((Activity) context).findViewById(id);
        t.setText(text);
    }

    public int getInt(String key) {
        return settings.getInt(key, 0);
    }

    public void setInt(String key, int amount) {
        editor.putInt(key, amount);
        editor.commit();
    }

    public void setInt(String key, int amount, int id) {
        setInt(key, amount);
        setText(id, String.valueOf(amount));
    }

    public String getString(String key) {
        return settings.getString(key, "");
    }

    public void setString(String key, String text) {
        editor.putString(key, text);
        editor.commit();
    }

    public void setString(String key, String text, int id) {
        setString(key, text);
        setText(id, text);
    }
}
