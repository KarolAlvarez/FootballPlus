package com.example.k11.footballplus.Views;


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

import com.example.k11.footballplus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {

    private Integer flagOfUpdate = 0;

    ImageView imgBtnNameFragmentMyProfile,
            imgBtnLastnameFragmentMyProfile,
            imgBtnUsernameFragmentMyProfile;

    TextView txtLastnameFragmentMyProfile,
            txtNameFragmentMyProfile,
            txtUsernameFragmentMyProfile;
    EditText edtUpdateFragmentMyProfile;

    Button btnUpdateFragmentMyProfile;

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


        imgBtnNameFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagOfUpdate = 1;

                edtUpdateFragmentMyProfile.setText(txtNameFragmentMyProfile.getText().toString());

            }
        });

        imgBtnLastnameFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagOfUpdate = 2;

                edtUpdateFragmentMyProfile.setText(txtLastnameFragmentMyProfile.getText().toString());

            }
        });

        imgBtnUsernameFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flagOfUpdate=3;
                edtUpdateFragmentMyProfile.setText(txtUsernameFragmentMyProfile.getText().toString());

            }
        });


        btnUpdateFragmentMyProfile = (Button) view.findViewById(R.id.btnUpdateFragmentMyProfile);
        btnUpdateFragmentMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateMyProfile();
                flagOfUpdate = 0;
                edtUpdateFragmentMyProfile.setText("");
            }
        });


        return view;

    }


    public void updateMyProfile() {
        switch (flagOfUpdate) {
            case 0:

                Toast.makeText(getActivity(), "There is no data to update", Toast.LENGTH_SHORT).show();
                break;
            case 1:
//colocar el metodo para actualizar el nombre de el usuario
                Toast.makeText(getActivity(), "Your Name was updated successfully", Toast.LENGTH_SHORT).show();
                break;
            case 2:
//colocar el metodo para actualizar el apellido de el usuario
                Toast.makeText(getActivity(), "Your Lastname was updated successfully", Toast.LENGTH_SHORT).show();
                break;
            case 3:
//colocar el metodo para actua.izar el nombre-de-usuario de el usuario
                Toast.makeText(getActivity(), "Your Username was updated successfully", Toast.LENGTH_SHORT).show();
                break;

        }

    }


}
