package com.example.k11.footballplus.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.k11.footballplus.Utilities.Constants;

/**
 * Created by k11 on 25/11/17.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_USER);
        db.execSQL(Constants.CREATE_TABLE_CAMP);
        db.execSQL(Constants.CREATE_TABLE_FAVOURITE);
        db.execSQL(Constants.CREATE_TABLE_RESERVATION);
        db.execSQL(Constants.CREATE_TABLE_COMMENT);


        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Monumental', 'Cancha para 7 contra 7','calle 11 #39-100',7300000,'https://www.canchasupergol.com/wp-content/uploads/2016/06/Jugando_Canchas_Futbol5_Bogota_Kennedy.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Punto penal', 'Cancha para 5 contra 5','calle 8 #20-10',7212001,'http://www.tsinteticadeportiva.com/wp-content/uploads/2015/04/muestra_deportivo02.png')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Camp now', 'en esta cancha juegan los mejores su capacidad 7 contra 7', 'calle 13 #52-19',7229634,'http://staticmd1.lavozdelinterior.com.ar/sites/default/files/styles/alto_529/public/listas/5-_0.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Metropolitano', 'capacidad de 9 contra 9','calle 34 #25-160',7243037, 'https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/image_landscape/public/170816_minnesota_1.jpg?itok=aXTO0hLH\n')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Campin', 'capacidad de 5 contra 5', 'calle 342 #245-150',7312465,'https://i.pinimg.com/originals/0b/fa/77/0bfa773b2badb0a79c217dc0a04b6d06.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Bernabeu', 'capacidad de 6 contra 6','calle 21 #280-46', 7283124,'http://www.varzesh11.com/images/gallery/-49896.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Tiro libre', 'capacidad de 7 contra 7', 'calle 6 #24-180',7212020,'http://zonacero.com/sites/default/files//styles/1260x720/public/2017/9/02/foto_detalle/metropolitano_seleccion_colombia_41.jpg?itok=XnxbvGpk')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Alianz arena', 'capacidad de 9 contra 9', 'calle 11 #9-140',7321700,'https://i1.wp.com/independientesantafe.com/wp-content/uploads/2017/03/Santa-Fe-vs-Cortulu%C3%A1-Febrero-2017-1280x655.jpg?fit=1200%2C614')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Atanasio Girardot', 'capacidad de 7 contra 7','calle 18 #23-67',7227766, 'https://3dwarehouse.sketchup.com/warehouse/getpubliccontent?contentId=f07bc29e-cccd-4317-b43e-26ca44dbf1b0')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Bombonera', 'capacidad de 9 contra 9', 'calle 245 #80-110',7807323,'https://t3.kn3.net/taringa/9/1/3/0/1/1/TWISTEDMETAL_PS3/47D.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Old Trafford', 'capacidad de 7 contra 7','calle 21 #2-46', 7285544,'https://www.thesun.co.uk/wp-content/uploads/2017/10/nintchdbpict000345464740.jpg?strip=all&w=960')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Pascual guerrero', 'capacidad de 5 contra 5', 'calle 8 #249-10',7211620,'https://www.elespectador.com/sites/default/files/48f4d1a7ced5bf5caa7dd22c95b9affc.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Maracana', 'capacidad de 11 contra 11', 'calle 17 #9-40',7328080,'http://visit.rio/wp-content/uploads/2015/09/9185352778_aa7bd28d1a_k1.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Luis II', 'capacidad de 5 contra 5','calle 138 #2-78',7232423, 'http://stadiumdb.com/pictures/stadiums/fra/stade_louis_ii/stade_louis_ii11.jpg')");
        db.execSQL("INSERT INTO " + Constants.TABLA_NAME_CAMP + " (ID,NAME_CAMP, DESCRIPTION,ADDRESS,PHONE,IMAGE ) VALUES (NULL, 'Stamford Bridge', 'capacidad de 9 contra 9', 'calle 25 #180-190',7802828,'http://paulgerald.com/wp-content/uploads/2014/04/image1.jpg')");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLA_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLA_NAME_CAMP);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLA_NAME_FAVOURITE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLA_NAME_RESERVATION);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLA_NAME_COMMENT);
        onCreate(db);
    }
}