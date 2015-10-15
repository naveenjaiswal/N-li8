package com.ndaarp.n_li8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by naveen on 9/23/2015.
 */
public class DBAdapter {

    DBHelper helper;

    public DBAdapter(Context context)
    {
        helper = new DBHelper(context);
    }

   // public long insertData (String email,String id , String name ,String mob , String pass, Integer date,Integer month ,Integer year ,String hostel,Integer room){
   public long insertData (String email,String id , String name ,String mob , String pass,String hostel,String room){
       Log.d("logtag", "user insert data");
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.DB_EMAIL,email);
        contentValues.put(DBHelper.DB_ID,id);
        contentValues.put(DBHelper.DB_UNAME,name);
        contentValues.put(DBHelper.DB_MOB,mob);
        contentValues.put(DBHelper.DB_PASS,pass);
        //contentValues.put(DBHelper.DB_DATE,date);
       // contentValues.put(DBHelper.DB_MONTH,month);
       // contentValues.put(DBHelper.DB_YEAR,year);
       contentValues.put(DBHelper.DB_HOSTEL,hostel);
       contentValues.put(DBHelper.DB_ROOM, room);
       contentValues.put(DBHelper.DB_ISVERF, "no");

       return db.insert(DBHelper.TABLE_NAME1,null,contentValues);
    }

    public String getdataPass() {
        Log.d("logtag", "user get data");
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns= {DBHelper.DB_EMAIL,DBHelper.DB_PASS};
        Cursor cursor = db.query(DBHelper.TABLE_NAME1,columns,null,null,null,null,null);
        String result = new String("");

        while(cursor.moveToNext())
        {
            String email = cursor.getString(cursor.getColumnIndex(DBHelper.DB_EMAIL));
            String pass = cursor.getString(cursor.getColumnIndex(DBHelper.DB_PASS));
            result = pass;

        }

        return  result;

    }

    public String getdata(String uid) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns= {DBHelper.DB_EMAIL,DBHelper.DB_PASS};
        Cursor cursor = db.query(DBHelper.TABLE_NAME1,columns,DBHelper.DB_EMAIL + " = '"+uid+"'",null,null,null,null);
        String result = new String("not found");

        while(cursor.moveToNext())
        {
            String email = cursor.getString(cursor.getColumnIndex(DBHelper.DB_EMAIL));
            String pass = cursor.getString(cursor.getColumnIndex(DBHelper.DB_PASS));
            result = pass;

        }

        return  result;

    }
    static class DBHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "AppDB";
        private static final String TABLE_NAME1 = "USERS";
        private static final int DB_VERSION1 = 18;
        private static final String DB_EMAIL = "_email";
        private static final String DB_ID = "bits_id";
        private static final String DB_UNAME = "name";
        private static final String DB_MOB = "mobile";
        private static final String DB_PASS = "password";
        private static final String DB_DATE = "date";
        private static final String DB_MONTH = "month";
        private static final String DB_YEAR = "year";
        private static final String DB_HOSTEL = "hostel";
        private static final String DB_ROOM = "room";
        private static final String DB_ISVERF = "verified";
        private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME1 + " ( "+
                DB_EMAIL + " VARCHAR(30) PRIMARY KEY, " + DB_ID + " VARCHAR(15), " +
                DB_UNAME+ " VARCHAR(30), " + DB_MOB + " VARCHAR(15), " +
                DB_PASS + " VARCHAR(30), " +
                //+ DB_DATE + "INTEGER, " +
               // DB_MONTH + "INTEGER, " + DB_YEAR + "INTEGER, " +
                DB_HOSTEL + " VARCHAR(15), " + DB_ROOM + " VARCHAR(15), " +
               DB_ISVERF + " VARCHAR(5) );" ;


        private static final String DROP_TABLE = "DROP TABLE IF EXISTS  "+ TABLE_NAME1;

       private static final String DB_NAME2 = "AppDB";
        private static final String TABLE_NAME2 = "NOTICES";
        private static final int DB_VERSION2 = 20;
        private static final String DB_CLUB = "dept_name";
        private static final String DB_ID2 = "_noticeid";
        private static final String DB_HEAD = "subject";
        private static final String DB_MSG = "message";
        private static final String DB_UPD = "update";


        private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " ( " +
                DB_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DB_CLUB + " VARCHAR(30), " +
                DB_HEAD + " TEXT, " + DB_MSG + " TEXT );";


        private static final String DROP_TABLE2 = "DROP TABLE IF EXISTS  " + TABLE_NAME2;

        private Context context;


        public DBHelper(Context context) {
            super(context, DB_NAME,null, DB_VERSION1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE2);
            Log.d("logtag", "table created user");
            // Toast.makeText(this, "DB Created", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
           // db.execSQL(DROP_TABLE2);

           // Toast.makeText(this, "DB dropped", Toast.LENGTH_SHORT).show();
            onCreate(db);
            Log.d("logtag", "user upgrade table");

        }
    }
}
