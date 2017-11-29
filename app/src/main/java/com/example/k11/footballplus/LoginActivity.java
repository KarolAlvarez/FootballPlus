package com.example.k11.footballplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.Utilities.IdUser;
import com.example.k11.footballplus.Views.CreateUserActivity;
import com.example.k11.footballplus.Views.ListFieldSoccerActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView txtBtnCreateUser;
    private EditText edtUserNameLogin, edtUserPasswordLogin;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtBtnCreateUser = (TextView) findViewById(R.id.txt_BtnCreateUser);

        edtUserNameLogin = (EditText) findViewById(R.id.edtUserNameLogin);
        edtUserPasswordLogin = (EditText) findViewById(R.id.edtPasswordLogin);
        btnEnter = (Button) findViewById(R.id.btnEnter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //guardar id de el usuario que ingresa

                IdUser.setIdUser(1);


                Intent intent = new Intent(view.getContext(), ListFieldSoccerActivity.class);
                startActivity(intent);

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
}
