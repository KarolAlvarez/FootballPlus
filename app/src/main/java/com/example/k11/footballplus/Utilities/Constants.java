package com.example.k11.footballplus.Utilities;

/**
 * Created by k11 on 25/11/17.
 */

public class Constants {


    //TABLA DE USUARIOS
    public static final String TABLA_NAME_USER = "USER";
    public static final String TABLA_USER_ID = "ID";
    public static final String TABLA_USER_NAME = "NAME";
    public static final String TABLA_USER_LASTNAME = "LAST_NAME";
    public static final String TABLA_USER_USERNAME = "USER_NAME";
    public static final String TABLA_USER_PIN = "PIN";
    public static final String TABLA_USER_GENDER = "GENDER";
    public static final String TABLA_USER_IMAGE = "IMAGE";
    public static final String CREATE_TABLE_USER =
            "CREATE TABLE " + TABLA_NAME_USER + " (" +
                    TABLA_USER_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    TABLA_USER_NAME + " TEXT NOT NULL, " +
                    TABLA_USER_LASTNAME + " TEXT NOT NULL, " +
                    TABLA_USER_USERNAME + " TEXT NOT NULL UNIQUE, " +
                    TABLA_USER_PIN + " INTEGER NOT NULL, " +
                    TABLA_USER_GENDER + " TEXT NOT NULL, " +
                    TABLA_USER_IMAGE + " TEXT NOT NULL)";

    //TABLA DE CANCHAS
    public static final String TABLA_NAME_CAMP = "CAMP";
    public static final String TABLA_CAMP_ID = "ID";
    public static final String TABLA_CAMP_NAME_CAMP = "NAME_CAMP";
    public static final String TABLA_CAMP_DESCRIPTION = "DESCRIPTION";
    public static final String TABLA_CAMP_ADDRESS = "ADDRESS";
    public static final String TABLA_CAMP_PHONE = "PHONE";
    public static final String CREATE_TABLE_CAMP =
            "CREATE TABLE " + TABLA_NAME_CAMP + " (" +
                    TABLA_CAMP_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    TABLA_CAMP_NAME_CAMP + " TEXT NOT NULL, " +
                    TABLA_CAMP_DESCRIPTION + " TEXT NOT NULL, " +
                    TABLA_CAMP_ADDRESS + " TEXT NOT NULL, " +
                    TABLA_CAMP_PHONE + " INTEGER NOT NULL)";

    //TABLA DE FAVORITOS
    public static final String TABLA_NAME_FAVOURITE = "FAVOURITE";
    public static final String TABLA_FAVOURITE_ID = "ID";
    public static final String TABLA_FAVOURITE_ID_USER = "ID_USER";
    public static final String TABLA_FAVOURITE_ID_CAMP = "ID_CAMP";
    public static final String CREATE_TABLE_FAVOURITE =
            "CREATE TABLE " + TABLA_NAME_FAVOURITE + " (" +
                    TABLA_FAVOURITE_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    TABLA_FAVOURITE_ID_USER + " INTEGER NOT NULL, " +
                    TABLA_FAVOURITE_ID_CAMP + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(`ID_USER`) REFERENCES USER, " +
                    "FOREIGN KEY(`ID_CAMP`) REFERENCES CAMP)";


    //TABLA DE RESERVACIONES
    public static final String TABLA_NAME_RESERVATION = "RESERVATION";
    public static final String TABLA_RESERVATION_ID = "ID";
    public static final String TABLA_RESERVATION_ID_USER = "ID_USER";
    public static final String TABLA_RESERVATION_ID_CAMP = "ID_CAMP";
    public static final String TABLA_RESERVATION_START_TIME = "START_TIME";
    public static final String TABLA_RESERVATION_END_TIME = "END_TIME";
    public static final String TABLA_RESERVATION_DATE = "DATE";
    public static final String CREATE_TABLE_RESERVATION =
            "CREATE TABLE " + TABLA_NAME_RESERVATION + " (" +
                    TABLA_RESERVATION_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    TABLA_RESERVATION_ID_USER + " INTEGER NOT NULL, " +
                    TABLA_RESERVATION_ID_CAMP + " INTEGER NOT NULL, " +
                    TABLA_RESERVATION_START_TIME + " TEXT NOT NULL, " +
                    TABLA_RESERVATION_END_TIME + " TEXT NOT NULL, " +
                    TABLA_RESERVATION_DATE + " TEXT NOT NULL, " +
                    "FOREIGN KEY(`ID_USER`) REFERENCES USER, " +
                    "FOREIGN KEY(`ID_CAMP`) REFERENCES CAMP)";

    //TABLA DE COMENTARIOS
    public static final String TABLA_NAME_COMMENT = "COMMENT";
    public static final String TABLA_COMMENT_ID = "ID";
    public static final String TABLA_COMMENT_ID_USER = "ID_USER";
    public static final String TABLA_COMMENT_ID_CAMP = "ID_CAMP";
    public static final String TABLA_COMMENT_TITLE = "TITLE";
    public static final String TABLA_COMMENT_DESCRIPTION = "DESCRIPTION";
    public static final String CREATE_TABLE_COMMENT =
            "CREATE TABLE " + TABLA_NAME_COMMENT + " (" +
                    TABLA_COMMENT_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    TABLA_COMMENT_ID_USER + " INTEGER NOT NULL, " +
                    TABLA_COMMENT_ID_CAMP + " INTEGER NOT NULL, " +
                    TABLA_COMMENT_TITLE + " TEXT NOT NULL, " +
                    TABLA_COMMENT_DESCRIPTION + " TEXT NOT NULL, " +
                    "FOREIGN KEY(`ID_USER`) REFERENCES USER, " +
                    "FOREIGN KEY(`ID_CAMP`) REFERENCES CAMP)";


}
