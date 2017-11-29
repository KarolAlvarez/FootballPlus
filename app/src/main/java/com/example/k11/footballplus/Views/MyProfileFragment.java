package com.example.k11.footballplus.Views;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.IdUser;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {

    private Integer flagOfUpdate = 0;


    ImageView imgBtnNameFragmentMyProfile,
            imgBtnLastnameFragmentMyProfile,
            imgBtnUsernameFragmentMyProfile,
            imgItemListFieldSoccerProfile;

    TextView txtLastnameFragmentMyProfile,
            txtNameFragmentMyProfile,
            txtUsernameFragmentMyProfile;
    EditText edtUpdateFragmentMyProfile;

    Button btnUpdateFragmentMyProfile;
    SqliteHelper sqliteHelper;
    SQLiteDatabase db;

    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        imgBtnNameFragmentMyProfile = (ImageView) view.findViewById(R.id.imgBtnNameFragmentMyProfile);
        imgBtnLastnameFragmentMyProfile = (ImageView) view.findViewById(R.id.imgBtnLastnameFragmentMyProfile);
        imgBtnUsernameFragmentMyProfile = (ImageView) view.findViewById(R.id.imgBtnUsernameFragmentMyProfile);
        txtLastnameFragmentMyProfile = (TextView) view.findViewById(R.id.txtLastnameFragmentMyProfile);
        txtNameFragmentMyProfile = (TextView) view.findViewById(R.id.txtNameFragmentMyProfile);
        txtUsernameFragmentMyProfile = (TextView) view.findViewById(R.id.txtUsernameFragmentMyProfile);
        edtUpdateFragmentMyProfile = (EditText) view.findViewById(R.id.edtUpdateFragmentMyProfile);
        edtUpdateFragmentMyProfile.setVisibility(View.INVISIBLE);


        imgItemListFieldSoccerProfile = (ImageView) view.findViewById(R.id.imgItemListFieldSoccerProfile);
        sqliteHelper = new SqliteHelper(getActivity(), "DB_CAMP_FOOTBALL", null, 1);


        imgBtnNameFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagOfUpdate = 1;
                edtUpdateFragmentMyProfile.setVisibility(View.VISIBLE);
                btnUpdateFragmentMyProfile.setVisibility(view.VISIBLE);
                edtUpdateFragmentMyProfile.setText(txtNameFragmentMyProfile.getText().toString());

            }
        });

        imgBtnLastnameFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagOfUpdate = 2;
                edtUpdateFragmentMyProfile.setVisibility(View.VISIBLE);

                edtUpdateFragmentMyProfile.setText(txtLastnameFragmentMyProfile.getText().toString());

            }
        });

        imgBtnUsernameFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flagOfUpdate = 3;
                edtUpdateFragmentMyProfile.setVisibility(View.VISIBLE);

                edtUpdateFragmentMyProfile.setText(txtUsernameFragmentMyProfile.getText().toString());

            }
        });


        btnUpdateFragmentMyProfile = (Button) view.findViewById(R.id.btnUpdateFragmentMyProfile);
        btnUpdateFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateMyProfile();
                edtUpdateFragmentMyProfile.setVisibility(View.INVISIBLE);

                flagOfUpdate = 0;
                edtUpdateFragmentMyProfile.setText("");
            }
        });


        userData();

        return view;

    }

    public void userData() {

        db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NAME, LAST_NAME, USER_NAME,IMAGE FROM USER WHERE USER.ID =" + IdUser.getIdUser(), null);

        try {
            while (cursor.moveToNext()) {

                txtNameFragmentMyProfile.setText(cursor.getString(0));
                txtLastnameFragmentMyProfile.setText(cursor.getString(1));
                txtUsernameFragmentMyProfile.setText(cursor.getString(2));

                Picasso.with(getActivity()).load(cursor.getString(3)).into(imgItemListFieldSoccerProfile);


            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "el usuario no existe", Toast.LENGTH_SHORT).show();

        }
        db.close();

    }

    public void updateMyProfile() {
        switch (flagOfUpdate) {
            case 0:

                Toast.makeText(getActivity(), "There is no data to update", Toast.LENGTH_SHORT).show();
                break;
            case 1:
//colocar el metodo para actualizar el nombre de el usuario
                updateName();
                Toast.makeText(getActivity(), "Your Name was updated successfully", Toast.LENGTH_SHORT).show();
                break;
            case 2:
//colocar el metodo para actualizar el apellido de el usuario
                updateLastName();
                Toast.makeText(getActivity(), "Your Lastname was updated successfully", Toast.LENGTH_SHORT).show();
                break;
            case 3:
//colocar el metodo para actua.izar el nombre-de-usuario de el usuario
                updateUserName();
                Toast.makeText(getActivity(), "Your Username was updated successfully", Toast.LENGTH_SHORT).show();
                break;

        }


    }


    public void updateName() {
        db = sqliteHelper.getReadableDatabase();

        db.execSQL("UPDATE USER SET NAME = '" + edtUpdateFragmentMyProfile.getText() + "' WHERE ID =" + IdUser.getIdUser());
        userData();
    }

    public void updateLastName() {
        db = sqliteHelper.getReadableDatabase();

        db.execSQL("UPDATE USER SET LAST_NAME = '" + edtUpdateFragmentMyProfile.getText() + "' WHERE ID =" + IdUser.getIdUser());
        userData();
    }

    public void updateUserName() {
        db = sqliteHelper.getReadableDatabase();

        db.execSQL("UPDATE USER SET USER_NAME = '" + edtUpdateFragmentMyProfile.getText() + "' WHERE ID =" + IdUser.getIdUser());
        userData();

    }

}
