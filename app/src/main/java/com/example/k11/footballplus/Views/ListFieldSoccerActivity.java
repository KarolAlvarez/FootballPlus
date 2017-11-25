package com.example.k11.footballplus.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.k11.footballplus.LoginActivity;
import com.example.k11.footballplus.R;

public class ListFieldSoccerActivity extends AppCompatActivity {
    private CheckBox checkboxFavoriteItemListFieldSoccer;
    private ImageView imagen;
    private Button BtnCommentItemListFieldSoccer,BtnReserveItemListFieldSoccer;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_field_soccer);
        checkboxFavoriteItemListFieldSoccer = (CheckBox) findViewById(R.id.checkboxFavoriteItemListFieldSoccer);
        //checkboxFavoriteItemListFieldSoccer.setChecked(true); cuando la vase de datos tenga almacenado como favorito

        imagen = (ImageView)findViewById(R.id.imgItemListFieldSoccerProfile);

        //#################### se de ve copiar en el adapter lista de canchas###############################
        checkboxFavoriteItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkboxFavoriteItemListFieldSoccer.isChecked()) {
                    Toast.makeText(view.getContext(), "I saved as favorite", Toast.LENGTH_SHORT).show();
                    //se debe agregar en favorito
                } else {
                    Toast.makeText(view.getContext(), "was removed from favorites", Toast.LENGTH_SHORT).show();

                    //la base de datos eliminar de favorito

                }
            }
        });


        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),FieldActivity.class);
                startActivity(intent);
            }
        });

        BtnCommentItemListFieldSoccer=(Button)findViewById(R.id.BtnCommentItemListFieldSoccer);
        BtnCommentItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),CommentActivity.class);
                startActivity(intent);

                Toast.makeText(view.getContext(),"crear comentario",Toast.LENGTH_SHORT).show();
            }
        });

        BtnReserveItemListFieldSoccer= (Button)findViewById(R.id.BtnReserveItemListFieldSoccer);
        BtnReserveItemListFieldSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),ReservationActivity.class);
                startActivity(intent);
                Toast.makeText(view.getContext(),"reservar cancha",Toast.LENGTH_SHORT).show();
            }
        });

        //###############################################################################


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_field_soccer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuLookProfileListfieldSoccer) {

            Intent intent = new Intent(this, PerfilUserActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menuSignOffListfieldSoccer) {

//
// ############################### metodo para cerrar sesion  ###############################

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
