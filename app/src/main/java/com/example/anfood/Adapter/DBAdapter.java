package com.example.anfood.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.anfood.Model.Store;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends SQLiteOpenHelper{
    private SQLiteDatabase mDatabase;
    public static final String DBName = "RESTAURANTS.db";
    @SuppressLint("SdCardPath")
    public static String DBPath = "../data/data/com.example.anfood/databases/RESTAURANTS.db";
    private Context mContext;

    // param
    public static final String RESTAURANTS = "RESTAURANTS";
    public static final String COUNTRY = "COUNTRY";
    public static final String NAME = "NAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String RATING = "RATING";
    public static final String IMAGE = "IMAGE";


    public DBAdapter(@Nullable  Context context){
        super(context, DBName, null, 1);
        this.mContext = context;
        this.DBPath = "/data/data/" + context.getPackageName() + "/" + "databases/";
    }
//    @Override
//    public void onCreate(SQLiteDatabase db) {
////        String createTableStatement = "CREATE TABLE " +  RESTAURANTS  + "(" + COUNTRY + " TEXT, " + NAME + " TEXT, " + ADDRESS + " TEXT, " + RATING + " INT);";
//        String createTableStatement = "CREATE TABLE " + RESTAURANTS
//                + " (" + COUNTRY + " text (40) ,"
//                + NAME + " text (40) ," +  ADDRESS
//                + " text (40));";
//        db.execSQL(createTableStatement);
//    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBName).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }
//    public ArrayList<String> getAllData(){
//        openDatabase();
//        Cursor cursor = mDatabase.rawQuery("SELECT * FROM DlerTB1_Sheet1 ORDER BY English LIMIT 50;", null);
//        ArrayList<String> aList = new ArrayList<String>();
//        while (cursor.moveToNext()){
//            aList.add(cursor.getString(1));
//        }
//        cursor.close();
//        closeDatabase();
//        return aList;
//    }

    public ArrayList<Store> geteverything(){
        ArrayList<Store>returnList = new ArrayList<>();

        String queryString = " select * from " + RESTAURANTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                String country = cursor.getString(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                double rate = cursor.getInt(3);
                Integer img = cursor.getInt(4);


                Store newStore = new Store(country,name,address,rate,img);
                returnList.add(newStore);
            }while(cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return returnList;
    }
    //Returning the meaning of the words
//    public String getMeaning(String meanW){
//        openDatabase();
//        Cursor cursor = mDatabase.rawQuery("SELECT * FROM DlerTB1_Sheet1" +
//                " WHERE English='" + meanW + "';", null);
//
//        while (cursor.moveToNext()) {
//            meanW = cursor.getString(2);
//        }
//        cursor.close();
//        closeDatabase();
//        return meanW;
//    }
}
