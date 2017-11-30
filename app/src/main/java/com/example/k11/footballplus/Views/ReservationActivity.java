package com.example.k11.footballplus.Views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.Constants;
import com.example.k11.footballplus.Utilities.IdUser;

import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity {
    TextView txtDateActivityReservation, txtNameFieldReservationActivity;
    Button btnDateActivityReservation,
            btnReserveActivityReservation;
    private int day, month, year, idCamp, sw;
    String flagHourStart, flagHourEnd, flagtwohours;
    SqliteHelper sqliteHelper;
    SQLiteDatabase db;

    RadioGroup groupRadioButonActivityReservation;

    private Spinner spinerHourActivityRreservation;

    private String[] hours = {"", "07:00",
            "08:00", "09:00", "10:00",
            "11:00", "12:00", "13:00",
            "14:00", "15:00", "16:00",
            "17:00", "18:00", "19:00",
            "20:00", "21:00", "22:00",
            "23:00"};


    private static DatePickerDialog.OnDateSetListener escucha;

    private final int dialog = 0;
    final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        txtDateActivityReservation = (TextView) findViewById(R.id.txtDateActivityReservation);
        btnDateActivityReservation = (Button) findViewById(R.id.btnDateActivityReservation);
        btnReserveActivityReservation = (Button) findViewById(R.id.btnReserveActivityReservation);

        txtNameFieldReservationActivity = (TextView) findViewById(R.id.txtNameFieldReservationActivity);

        sqliteHelper = new SqliteHelper(this, "DB_CAMP_FOOTBALL", null, 1);


        spinerHourActivityRreservation = (Spinner) findViewById(R.id.spinerHourActivityRreservation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, hours);
        spinerHourActivityRreservation.setAdapter(adapter);


        Bundle bundle = getIntent().getExtras();
        idCamp = bundle.getInt("idCamp");
        txtNameFieldReservationActivity.setText(bundle.getString("nameCamp"));


        groupRadioButonActivityReservation = (RadioGroup) findViewById(R.id.groupRadioButonActivityReservation);
        groupRadioButonActivityReservation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                flagHourStart = "";
                flagHourEnd = "";
                flagtwohours = "";
                if (checkedId == R.id.radioButtonOneHourActivityReservation) {
                    flagHourStart = hours[((int) spinerHourActivityRreservation.getSelectedItemId())];
                    flagHourEnd = hours[((int) spinerHourActivityRreservation.getSelectedItemId() + 1)];
                    sw = 1;
                } else if (checkedId == R.id.radioButtonTwoHourActivityReservation) {
                    sw = 2;
                    flagHourStart = hours[((int) spinerHourActivityRreservation.getSelectedItemId())];
                    flagtwohours = hours[((int) spinerHourActivityRreservation.getSelectedItemId() + 1)];
                    flagHourEnd = hours[((int) spinerHourActivityRreservation.getSelectedItemId() + 2)];
                }
            }
        });


        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        escucha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                day = i;
                month = i1;
                year = i2;
            }
        };

        btnDateActivityReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showDialog(dialog);
                txtDateActivityReservation.setText(year+ "/" + (month + 1) + "/" +  day);
            }
        });


        btnReserveActivityReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                onClickcreateComment(flagHourStart, flagHourEnd, idCamp);
                groupRadioButonActivityReservation.clearCheck();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("RESERVATION");
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



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this, escucha, year, month, day);

        }
        return null;

    }


    public void onClickcreateComment(String hourStar, String hourEnd, int idCamp) {


        String stringDate = txtDateActivityReservation.getText().toString();


        if (TextUtils.isEmpty(hourStar)) {
            Toast.makeText(this, "The hour field is empty", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(hourEnd)) {
            Toast.makeText(this, "the time has not been selected", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(stringDate)) {
            Toast.makeText(this, "the date has not been selected", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(this, "the camp football was reserved successfully", Toast.LENGTH_SHORT).show();
            reserve(hourStar, hourEnd, idCamp);
        }
    }

    public void reserve(String hourStar, String hourEnd, int idCamp) {

        db = sqliteHelper.getWritableDatabase();

        String selectQuery = "SELECT * FROM RESERVATION WHERE ID_CAMP = " + idCamp + " AND START_TIME = '" + hourStar + "' AND DATE = '" + txtDateActivityReservation.getText().toString() + "'";
        String selectQuery2 = "SELECT * FROM RESERVATION WHERE ID_CAMP = " + idCamp + " AND START_TIME = '" + flagtwohours + "' AND DATE = '" + txtDateActivityReservation.getText().toString() + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        Cursor cursor2 = db.rawQuery(selectQuery2, null);

        switch (sw) {
            case 1:
                if (cursor.getCount() != 0) {
                    Toast.makeText(this, "el registro ya existe", Toast.LENGTH_SHORT).show();
                    groupRadioButonActivityReservation.clearCheck();
                } else {
                    ContentValues values = new ContentValues();
                    values.put(Constants.TABLA_RESERVATION_ID_USER, IdUser.getIdUser());
                    values.put(Constants.TABLA_RESERVATION_ID_CAMP, idCamp);
                    values.put(Constants.TABLA_RESERVATION_START_TIME, hourStar);
                    values.put(Constants.TABLA_RESERVATION_END_TIME, hourEnd);
                    values.put(Constants.TABLA_RESERVATION_DATE, txtDateActivityReservation.getText().toString());
                    db.insert(Constants.TABLA_NAME_RESERVATION, Constants.TABLA_RESERVATION_ID, values);
                    finish();
                    db.close();


                }
                break;
            case 2:
                if ((cursor.getCount() != 0) || (cursor2.getCount() != 0)) {
                    Toast.makeText(this, "horario no disponible", Toast.LENGTH_SHORT).show();
                    groupRadioButonActivityReservation.clearCheck();
                } else {
                    ContentValues values = new ContentValues();
                    values.put(Constants.TABLA_RESERVATION_ID_USER, IdUser.getIdUser());
                    values.put(Constants.TABLA_RESERVATION_ID_CAMP, idCamp);
                    values.put(Constants.TABLA_RESERVATION_START_TIME, hourStar);
                    values.put(Constants.TABLA_RESERVATION_END_TIME, hourEnd);
                    values.put(Constants.TABLA_RESERVATION_DATE, txtDateActivityReservation.getText().toString());
                    db.insert(Constants.TABLA_NAME_RESERVATION, Constants.TABLA_RESERVATION_ID, values);
                    finish();
                    db.close();
                }
        }


    }


}