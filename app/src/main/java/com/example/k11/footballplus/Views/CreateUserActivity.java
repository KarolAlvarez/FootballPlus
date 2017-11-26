package com.example.k11.footballplus.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.LoginActivity;
import com.example.k11.footballplus.Models.Gender;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.Constants;

public class CreateUserActivity extends AppCompatActivity {
    private Button btnCreateUser;
    private String flagImgUser, flagGender;
    TextInputEditText edtNameCreateUser, edtLastNameCreateUser, edtPasswordCreateUser, edtUserNameCreateUser;
    RadioGroup radioGroupButonCreateuser;
    SqliteHelper sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);


        edtNameCreateUser = (TextInputEditText) findViewById(R.id.edtNameCreateUser);
        edtLastNameCreateUser = (TextInputEditText) findViewById(R.id.edtLastNameCreateUser);
        edtPasswordCreateUser = (TextInputEditText) findViewById(R.id.edtPasswordCreateUser);
        edtUserNameCreateUser = (TextInputEditText) findViewById(R.id.edtUserNameCreateUser);
        radioGroupButonCreateuser = (RadioGroup) findViewById(R.id.radioGroupButonCreateuser);

        sqliteHelper = new SqliteHelper(this, "DB_CAMP_FOOTBALL", null, 1);


        radioGroupButonCreateuser.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioButtonMaleCreateUser) {
                    flagImgUser = Gender.MALE;
                    flagGender = "Man";
                } else if (checkedId == R.id.radioButtonFemaleCreateUser) {
                    flagImgUser = Gender.FEMALE;
                    flagGender = "Woman";
                }
            }
        });


        btnCreateUser = (Button) findViewById(R.id.btnCreateUser);
        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickcreateUser();

            }
        });
    }


    public void onClickcreateUser() {


        String stringName = edtNameCreateUser.getText().toString();
        String stringLastName = edtLastNameCreateUser.getText().toString();
        String stringUserName = edtUserNameCreateUser.getText().toString();
        String stringPassword = edtPasswordCreateUser.getText().toString();


        if (TextUtils.isEmpty(stringName)) {
            Toast.makeText(this, "The name field is empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(stringLastName)) {
            Toast.makeText(this, "The lastname field is empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(stringUserName)) {
            Toast.makeText(this, "The username field is empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(stringPassword)) {
            Toast.makeText(this, "The password field is empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(flagImgUser)) {
            Toast.makeText(this, "the gender has not been selected", Toast.LENGTH_SHORT).show();
        } else {
            createUser();
        }
    }

    public void createUser() {

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.TABLA_USER_NAME, edtNameCreateUser.getText().toString());
        values.put(Constants.TABLA_USER_LASTNAME, edtLastNameCreateUser.getText().toString());
        values.put(Constants.TABLA_USER_USERNAME, edtUserNameCreateUser.getText().toString());
        values.put(Constants.TABLA_USER_PIN, Integer.parseInt(edtPasswordCreateUser.getText().toString()));
        values.put(Constants.TABLA_USER_GENDER, flagGender);
        values.put(Constants.TABLA_USER_IMAGE, flagImgUser);

        Long idResult = db.insert(Constants.TABLA_NAME_USER, Constants.TABLA_USER_ID, values);
        edtNameCreateUser.setText("");
        edtLastNameCreateUser.setText("");
        edtPasswordCreateUser.setText("");
        edtUserNameCreateUser.setText("");

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}
