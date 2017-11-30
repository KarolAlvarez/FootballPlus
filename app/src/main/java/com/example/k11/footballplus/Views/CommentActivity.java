package com.example.k11.footballplus.Views;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.Constants;
import com.example.k11.footballplus.Utilities.IdUser;

public class CommentActivity extends AppCompatActivity {
    Bundle bundle;
    SqliteHelper sqliteHelper;
    SQLiteDatabase db;

    EditText edtTitleActivityComment,
            edtDecriptionActivityComment;

    Button btnAddCommentActivityComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        sqliteHelper = new SqliteHelper(this, "DB_CAMP_FOOTBALL", null, 1);

        edtTitleActivityComment = (EditText) findViewById(R.id.edtTitleActivityComment);
        edtDecriptionActivityComment = (EditText) findViewById(R.id.edtDecriptionActivityComment);
        btnAddCommentActivityComment = (Button) findViewById(R.id.btnAddCommentActivityComment);

        bundle = getIntent().getExtras();

        btnAddCommentActivityComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickcreateComment();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("COMMENT");
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_perfil_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menuMyProfile) {

            //  Intent intent = new Intent(this, ListFieldSoccerActivity.class);
            // startActivity(intent);

            return true;
        }else if (id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }




    public void onClickcreateComment() {


        String stringTitle = edtTitleActivityComment.getText().toString();
        String stringDescription = edtDecriptionActivityComment.getText().toString();


        if (TextUtils.isEmpty(stringTitle)) {
            Toast.makeText(this, "The title field is empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(stringDescription)) {
            Toast.makeText(this, "The description field is empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "the comment was added successfully", Toast.LENGTH_SHORT).show();
            createComment();
        }
    }

    public void createComment() {

        db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.TABLA_COMMENT_ID_USER, IdUser.getIdUser());
        values.put(Constants.TABLA_COMMENT_ID_CAMP, bundle.getInt("idCamp"));
        values.put(Constants.TABLA_COMMENT_TITLE, edtTitleActivityComment.getText().toString());
        values.put(Constants.TABLA_COMMENT_DESCRIPTION, edtDecriptionActivityComment.getText().toString());

        db.insert(Constants.TABLA_NAME_COMMENT, Constants.TABLA_COMMENT_ID, values);
        finish();
        db.close();
    }


}
