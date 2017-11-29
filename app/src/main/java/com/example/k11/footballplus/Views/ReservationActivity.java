package com.example.k11.footballplus.Views;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.R;

import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity {
    TextView txtDateActivityReservation;
    Button btnDateActivityReservation;
    private int day, month, year;

    private Spinner spinerHourActivityRreservation;

    private String[] hours = {"07:00",
            "08:00", "09:00", "10:00",
            "11:00", "12:00", "13:00",
            "14:00", "15:00", "16:00",
            "17:00", "18:00", "19:00",
            "20:00", "21:00", "22:00",
            "23:00"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        txtDateActivityReservation = (TextView) findViewById(R.id.txtDateActivityReservation);
        btnDateActivityReservation = (Button) findViewById(R.id.btnDateActivityReservation);
        spinerHourActivityRreservation = (Spinner) findViewById(R.id.spinerHourActivityRreservation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, hours);
        spinerHourActivityRreservation.setAdapter(adapter);


        btnDateActivityReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        txtDateActivityReservation.setText(i2 + "/" + i1 + "/" + i);
                    }
                }, day, month, year);

                datePickerDialog.show();


            }
        });

    }


}