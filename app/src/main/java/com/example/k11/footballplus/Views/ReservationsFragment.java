package com.example.k11.footballplus.Views;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k11.footballplus.Adapters.ReservationsFragmentAdapter;
import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.Models.Reservations;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.IdUser;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservationsFragment extends Fragment {
    RecyclerView recyclerViewComments;
    ReservationsFragmentAdapter reservationsFragmentAdapter;
    List<Reservations> reservationsList = new ArrayList<>();
    SqliteHelper sqliteHelper;

    public ReservationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservations, container, false);

        recyclerViewComments = (RecyclerView) view.findViewById(R.id.recyclerViewFragmenReservations);
        sqliteHelper = new SqliteHelper(getActivity(), "DB_CAMP_FOOTBALL", null, 1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewComments.setLayoutManager(linearLayoutManager);

        listComment();
        return view;
    }

    public void listComment() {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        try {


            Cursor cursor = db.rawQuery("SELECT  RESERVATION.ID ,CAMP.NAME_CAMP," +
                    " RESERVATION.START_TIME,RESERVATION.END_TIME , RESERVATION.DATE, " +
                    "CAMP.ADDRESS,CAMP.PHONE " +
                    "FROM RESERVATION INNER JOIN USER ON RESERVATION.ID_USER=USER.ID " +
                    "INNER JOIN CAMP ON RESERVATION.ID_CAMP=CAMP.ID" +
                    " WHERE RESERVATION.ID_USER ="+ IdUser.getIdUser()+" GROUP BY RESERVATION.ID", null);





            while (cursor.moveToNext()) {
                Reservations comment = new Reservations();
                comment.setIdReservations(cursor.getInt(0));
                comment.setNameCampReservation(cursor.getString(1));
                comment.setStartTimeReservation(cursor.getString(2));
                comment.setEndTimeResrvation(cursor.getString(3));
                comment.setDateReservation(cursor.getString(4));
                comment.setAddresCampReservation(cursor.getString(5));
                comment.setPhoneCampReservation(cursor.getInt(6));

                reservationsList.add(comment);
            }

            cursor.close();

            if (reservationsList.size() != 0) {
                processData();
            }


        } catch (Exception e) {

        }
    }

    public void processData() {
        reservationsFragmentAdapter = new ReservationsFragmentAdapter(reservationsList, getActivity());
        recyclerViewComments.setAdapter(reservationsFragmentAdapter);
    }


}
