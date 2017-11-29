package com.example.k11.footballplus.Session;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Administrator on 5/5/2016.
 */
public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;
    public static final String KEY_NAME = "name";


    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin,String name,String pass){
        editor.putBoolean("loggedInmode",logggedin);
        editor.putString(KEY_NAME,name);

        editor.commit();
    }
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAME, prefs.getString(KEY_NAME, null));


        return user;
    }
    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode", false);
    }
}
