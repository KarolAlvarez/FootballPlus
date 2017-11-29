package com.example.k11.footballplus.Views;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentField extends Fragment {
    SqliteHelper sqliteHelper;
    SQLiteDatabase db;

    TextView txtNameFragmentField,
            txtDescriptionFragmentField,
            txtAddressFragmentField,
            txtPhoneFragmentField;
    ImageView imgNameFieldActivity;


    public FragmentField() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_field, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_field, container, false);
        sqliteHelper = new SqliteHelper(getActivity(), "DB_CAMP_FOOTBALL", null, 1);

        txtNameFragmentField = (TextView) view.findViewById(R.id.txtNameFragmentField);
        txtDescriptionFragmentField = (TextView) view.findViewById(R.id.txtDescriptionFragmentField);
        txtAddressFragmentField = (TextView) view.findViewById(R.id.txtAddressFragmentField);
        txtPhoneFragmentField = (TextView) view.findViewById(R.id.txtPhoneFragmentField);
        imgNameFieldActivity=(ImageView)view.findViewById(R.id.imgNameFieldActivity);
        // Toast.makeText(getActivity(), "" + getArguments().getInt("idCamp"), Toast.LENGTH_SHORT).show();
        campData();

        return view;
    }

    public void campData() {

        db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NAME_CAMP, DESCRIPTION, ADDRESS,IMAGE,PHONE FROM CAMP WHERE CAMP.ID =" + getArguments().getInt("idCamp"), null);

        try {
            while (cursor.moveToNext()) {

                txtNameFragmentField.setText(cursor.getString(0));
                txtDescriptionFragmentField.setText(cursor.getString(1));
                txtAddressFragmentField.setText(cursor.getString(2));
                txtPhoneFragmentField.setText(cursor.getString(4));

                Picasso.with(getActivity()).load(cursor.getString(3)).into(imgNameFieldActivity);


            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "el usuario no existe", Toast.LENGTH_SHORT).show();

        }
        db.close();

    }


}
