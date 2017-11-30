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
import android.widget.Toast;

import com.example.k11.footballplus.Adapters.FavoritesFragmentAdapter;
import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.Models.Favorites;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.IdUser;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    RecyclerView recyclerViewContactsListFieldSoccer;
    FavoritesFragmentAdapter favoritesFragmentAdapter;
    List<Favorites> favoritesList = new ArrayList<>();
    SqliteHelper sqliteHelper;


    public FavoritesFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        sqliteHelper = new SqliteHelper(getActivity(), "DB_CAMP_FOOTBALL", null, 1);
        recyclerViewContactsListFieldSoccer = (RecyclerView) view.findViewById(R.id.recyclerViewFragmenFavorites);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewContactsListFieldSoccer.setLayoutManager(linearLayoutManager);

        listCampFavourite();
        return view;


    }

    public void listCampFavourite() {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  FAVOURITE.ID, USER.ID,CAMP.ID,CAMP.NAME_CAMP,CAMP.DESCRIPTION,CAMP.IMAGE " +
                "FROM FAVOURITE " +
                "INNER JOIN USER ON FAVOURITE.ID_USER=USER.ID " +
                "INNER JOIN CAMP ON FAVOURITE.ID_CAMP=CAMP.ID " +
                "WHERE FAVOURITE.ID_USER= "+ IdUser.getIdUser()+ " GROUP BY FAVOURITE.ID", null);

        while (cursor.moveToNext()) {
            Favorites favorites = new Favorites();
            favorites.setIdFavorite(cursor.getInt(0));
            favorites.setIdUser(cursor.getInt(1));
            favorites.setIdCamp(cursor.getInt(2));
            favorites.setNameCamp(cursor.getString(3));
            favorites.setDescriptionCamp(cursor.getString(4));
            favorites.setImageCamp(cursor.getString(5));
            favoritesList.add(favorites);
        }

        cursor.close();

        if (favoritesList.size() != 0) {
            processData();
        } else {
            Toast.makeText(getActivity(), "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData() {
        favoritesFragmentAdapter = new FavoritesFragmentAdapter(favoritesList, getActivity());
        recyclerViewContactsListFieldSoccer.setAdapter(favoritesFragmentAdapter);
    }


}
