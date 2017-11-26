package com.example.k11.footballplus.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.k11.footballplus.R;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {
    Button BtnCommentItemListFieldSoccer,BtnReserveItemListFieldSoccer;


    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v= inflater.inflate(R.layout.fragment_favorites,container,false);

        BtnCommentItemListFieldSoccer=(Button)v.findViewById(R.id.btnCommentItemListFieldSoccer);
        BtnCommentItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),CommentActivity.class);
                startActivity(intent);

                Toast.makeText(getActivity(),"crear comentario",Toast.LENGTH_SHORT).show();
            }
        });
        BtnReserveItemListFieldSoccer= (Button)v.findViewById(R.id.btnReserveItemListFieldSoccer);
        BtnReserveItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),ReservationActivity.class);
                startActivity(intent);
                Toast.makeText(view.getContext(),"reservar cancha",Toast.LENGTH_SHORT).show();
            }
        });



        return v;


    }

}
