package com.example.k11.footballplus.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.k11.footballplus.LoginActivity;
import com.example.k11.footballplus.R;

public class CreateUserActivity extends AppCompatActivity {
private Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        btnCreateUser=(Button)findViewById(R.id.btnCreateUser);
        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
