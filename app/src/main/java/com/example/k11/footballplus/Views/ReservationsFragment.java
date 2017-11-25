package com.example.k11.footballplus.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.k11.footballplus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservationsFragment extends Fragment {
    Button btnpruebaFragment;

    public ReservationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_reservations,container,false);

/*
        btnpruebaFragment=(Button)v.findViewById(R.id.butonPruebaFagmenReservaciones);
        btnpruebaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Mis reservaciones",Toast.LENGTH_SHORT).show();
            }
        });
*/


        return v;}

}
