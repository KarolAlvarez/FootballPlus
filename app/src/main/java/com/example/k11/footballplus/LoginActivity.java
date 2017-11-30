package com.example.k11.footballplus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.Utilities.Constants;
import com.example.k11.footballplus.Views.CreateUserActivity;
import com.example.k11.footballplus.Views.ListFieldSoccerActivity;
import com.example.k11.footballplus.Views.Session;

public class LoginActivity extends AppCompatActivity {
    public int id;
    private TextView txtBtnCreateUser;
    private EditText edtUserNameLogin, edtUserPasswordLogin;
    private Button btnEnter;
    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Session a = new Session(this);
        if (a.loggedin()) {
            startActivity(new Intent(LoginActivity.this, ListFieldSoccerActivity.class));
            finish();
        }
        sqliteHelper = new SqliteHelper(this, "DB_CAMP_FOOTBALL", null, 1);
        txtBtnCreateUser = (TextView) findViewById(R.id.txt_BtnCreateUser);

        edtUserNameLogin = (EditText) findViewById(R.id.edtUserNameLogin);
        edtUserPasswordLogin = (EditText) findViewById(R.id.edtPasswordLogin);
        btnEnter = (Button) findViewById(R.id.btnEnter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //guardar id de el usuario que ingresa

                // IdUser.setIdUser(1);
                if (edtUserNameLogin.getText().toString().isEmpty() || edtUserPasswordLogin.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "the field username or password are empty", Toast.LENGTH_SHORT).show();
                } else {

                    login();
                    //Intent intent = new Intent(view.getContext(), ListFieldSoccerActivity.class);
                }  //startActivity(intent);

            }
        });


        txtBtnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateUserActivity.class);
                startActivity(intent);
                intent = null;
            }
        });


    }

    public boolean getUser(String name, Integer pass) {

        String selectQuery = "select * from  " + Constants.TABLA_NAME_USER + " where " +
                Constants.TABLA_USER_USERNAME + " = " + "'" + name + "'" + " and " + Constants.TABLA_USER_PIN + " = " + pass;

        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext()) {

            id = cursor.getInt(0);


            if (cursor.getCount() > 0) {

                return true;
            }

        }

        cursor.close();
        db.close();

        return false;
    }


    private void login() {


        Session a = new Session(this);
        String name = edtUserNameLogin.getText().toString();
        Integer pass = Integer.parseInt(edtUserPasswordLogin.getText().toString());


        if (getUser(name, pass)) {
            a.setLoggedin(true, name, pass);
            a.setId(id);
            Intent intent = new Intent(this, ListFieldSoccerActivity.class);

            startActivity(intent);


            finish();
        } else {
            Toast.makeText(getApplicationContext(), "incorrect username or password", Toast.LENGTH_SHORT).show();
        }

    }


}
