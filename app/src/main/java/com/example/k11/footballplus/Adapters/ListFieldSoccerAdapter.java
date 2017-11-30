package com.example.k11.footballplus.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.Models.CampFootball;
import com.example.k11.footballplus.R;
import com.example.k11.footballplus.Utilities.Constants;
import com.example.k11.footballplus.Utilities.IdUser;
import com.example.k11.footballplus.Views.CommentActivity;
import com.example.k11.footballplus.Views.FieldActivity;
import com.example.k11.footballplus.Views.ListFieldSoccerActivity;
import com.example.k11.footballplus.Views.ReservationActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k11 on 25/11/17.
 */

public class ListFieldSoccerAdapter extends RecyclerView.Adapter<ListFieldSoccerAdapter.ViewHolder> {

    List<CampFootball> campFootballList = new ArrayList<>();
    Context context;

    public ListFieldSoccerAdapter(List<CampFootball> campFootballList, Context context) {
        this.campFootballList = campFootballList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_field_soccer, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.txtNameFieldSoccer.setText(campFootballList.get(position).getName());
        holder.txtDescriptionFieldSoccer.setText(campFootballList.get(position).getDescription());
        //imagen con picaso
        Picasso.with(context).load(campFootballList.get(position).getImage()).into((holder.imgItemListFieldSoccerProfile));



        SqliteHelper sqliteHelper;
        SQLiteDatabase db;

        sqliteHelper = new SqliteHelper(context, "DB_CAMP_FOOTBALL", null, 1);

        db = sqliteHelper.getWritableDatabase();

        Cursor cursor= db.rawQuery("SELECT * FROM FAVOURITE WHERE ID_USER ="+IdUser.getIdUser()+" AND ID_CAMP ="+campFootballList.get(position).getId(),null);

        if (cursor.getCount()!=0){

            holder.checkboxFavoriteItemListFieldSoccer.setChecked(true);

        }else {
            holder.checkboxFavoriteItemListFieldSoccer.setChecked(false);
        }





        holder.imgItemListFieldSoccerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), FieldActivity.class);
                intent.putExtra("idCamp", campFootballList.get(position).getId());
                context.startActivity(intent);
            }
        });


        holder.btnReserveItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReservationActivity.class);

                intent.putExtra("idCamp", campFootballList.get(position).getId());

                context.startActivity(intent);

                Toast.makeText(view.getContext(), "reservar cancha", Toast.LENGTH_SHORT).show();
            }
        });


        holder.btnCommentItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CommentActivity.class);
                intent.putExtra("idCamp", campFootballList.get(position).getId());
                context.startActivity(intent);
            }
        });

        holder.checkboxFavoriteItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteHelper sqliteHelper;
                SQLiteDatabase db;

                sqliteHelper = new SqliteHelper(context, "DB_CAMP_FOOTBALL", null, 1);

                if (holder.checkboxFavoriteItemListFieldSoccer.isChecked()) {
                    Toast.makeText(view.getContext(), "I saved as favorite", Toast.LENGTH_SHORT).show();
                    //se debe agregar en favorito
                    db = sqliteHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(Constants.TABLA_FAVOURITE_ID_USER, IdUser.getIdUser());
                    values.put(Constants.TABLA_FAVOURITE_ID_CAMP, campFootballList.get(position).getId());

                    db.insert(Constants.TABLA_NAME_FAVOURITE, Constants.TABLA_FAVOURITE_ID, values);


                } else {
                    Toast.makeText(view.getContext(), "was removed from favorites", Toast.LENGTH_SHORT).show();

                    //la base de datos eliminar de favorito
                    db = sqliteHelper.getWritableDatabase();
                    db.execSQL("DELETE FROM FAVOURITE WHERE ID_USER = "+IdUser.getIdUser()+" AND ID_CAMP = "+campFootballList.get(position).getId());

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return campFootballList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameFieldSoccer, txtDescriptionFieldSoccer;
        ImageView imgItemListFieldSoccerProfile;
        CheckBox checkboxFavoriteItemListFieldSoccer;
        Button btnReserveItemListFieldSoccer, btnCommentItemListFieldSoccer;

        public ViewHolder(View item) {
            super(item);
            txtNameFieldSoccer = (TextView) item.findViewById(R.id.txtNameFieldSoccer);
            txtDescriptionFieldSoccer = (TextView) item.findViewById(R.id.txtDescriptionFieldSoccer);
            checkboxFavoriteItemListFieldSoccer = (CheckBox) item.findViewById(R.id.checkboxFavoriteItemListFieldSoccer);
            imgItemListFieldSoccerProfile = (ImageView) item.findViewById(R.id.imgItemListFieldSoccerProfile);
            btnReserveItemListFieldSoccer = (Button) item.findViewById(R.id.btnReserveItemListFieldSoccer);
            btnCommentItemListFieldSoccer = (Button) item.findViewById(R.id.btnCommentItemListFieldSoccer);
        }


    }

}