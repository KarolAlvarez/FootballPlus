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

import com.example.k11.footballplus.Adapters.CommentFagmentAdapter;
import com.example.k11.footballplus.Helpers.SqliteHelper;
import com.example.k11.footballplus.Models.Comment;
import com.example.k11.footballplus.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends Fragment {
    RecyclerView recyclerViewComments;
    CommentFagmentAdapter commentFagmentAdapter;
    List<Comment> commentList = new ArrayList<>();
    SqliteHelper sqliteHelper;


    public CommentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        recyclerViewComments = (RecyclerView) view.findViewById(R.id.recyclerViewComments);
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


            Cursor cursor = db.rawQuery("SELECT * FROM COMMENT  WHERE ID_CAMP = " + getArguments().getInt("idCamp") + " ORDER BY TITLE ASC", null);

            while (cursor.moveToNext()) {
                Comment comment = new Comment();
                comment.setIdComment(cursor.getInt(0));
                comment.setIdUserComment(cursor.getInt(1));
                comment.setIdCampComment(cursor.getInt(2));
                comment.setTitleCommnet(cursor.getString(3));
                comment.setDescriptionComment(cursor.getString(4));
                commentList.add(comment);
            }

            cursor.close();

            if (commentList.size() != 0) {
                processData();
            }


        } catch (Exception e) {

        }
    }

    public void processData() {
        commentFagmentAdapter = new CommentFagmentAdapter(commentList, getActivity());
        recyclerViewComments.setAdapter(commentFagmentAdapter);
    }

}
