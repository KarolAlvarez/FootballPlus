package com.example.k11.footballplus.Views;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.k11.footballplus.Utilities.IdUser;

import java.util.HashMap;

/**
 * Created by Administrator on 5/5/2016.
 */
public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;
    public static final String KEY_NAME = "name";
    public static final Integer KEY_ID = 0;



    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();

    }

    public void setLoggedin(boolean logggedin, String name, Integer pass){
        editor.putBoolean("loggedInmode",logggedin);
      //  editor.putInt(String.valueOf(KEY_ID),id);
        editor.putString(KEY_NAME,name);

        editor.commit();
    }




    public void setId( Integer id ){


        editor.putInt(String.valueOf(KEY_ID),id);

        editor.commit();
    }



    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, prefs.getString(KEY_NAME, null));


        return user;
    }


    public HashMap<Integer, Integer> getUserIde(){
        HashMap<Integer, Integer> IDE = new HashMap<Integer, Integer>();
        // user name
        IDE.put(KEY_ID, prefs.getInt(String.valueOf(KEY_ID), 0));


        return IDE;
    }






    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode", false);
    }
}
