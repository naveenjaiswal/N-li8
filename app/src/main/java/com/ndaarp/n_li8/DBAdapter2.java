

package com.ndaarp.n_li8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by naveen on 9/23/2015.
 */
public class DBAdapter2 {

    DBHelper2 helper2;
    SQLiteDatabase db;

    public DBAdapter2(Context context) {
        helper2 = new DBHelper2(context);
        db = helper2.getWritableDatabase();
        Log.d("logtag", "adapter 2 constructor");
    }

    // public long insertData (String id , String deptname ,String sub , String msg, ){
    public long insertData(String deptname, String sub, String msg) {
        // db = helper2.getWritableDatabase();
        Log.d("logtag", "insert data");
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper2.DB_CLUB, deptname);
        contentValues.put(DBHelper2.DB_HEAD, sub);
        contentValues.put(DBHelper2.DB_MSG, msg);


        return db.insert(DBHelper2.TABLE_NAME2, null, contentValues);
    }


    public ArrayList<String[]> getAlldata() {
       // db = helper2.getWritableDatabase();
        Log.d("logtag", "get data");
        SQLiteDatabase db = helper2.getWritableDatabase();
        String[] columns = {DBHelper2.DB_CLUB, DBHelper2.DB_HEAD, DBHelper2.DB_MSG};
        Cursor cursor = db.query(DBHelper2.TABLE_NAME2, columns, null, null, null, null, null);

        ArrayList<String[]> mStringList = new ArrayList<String[]>();

        while (cursor.moveToNext()) {
            String[] result = new String[3];
            String dep = cursor.getString(cursor.getColumnIndex(DBHelper2.DB_CLUB));
            String subj = cursor.getString(cursor.getColumnIndex(DBHelper2.DB_HEAD));
            String note = cursor.getString(cursor.getColumnIndex(DBHelper2.DB_MSG));

            result[0] = dep;
            result[1] = subj;
            result[2] = note;

            Log.d("logtag", result[0]);
            Log.d("logtag", result[1]);
            Log.d("logtag", result[2]);

            mStringList.add(result);

        }
        return mStringList;
    }


    static class DBHelper2 extends SQLiteOpenHelper {


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


        public DBHelper2(Context context) {
            super(context, DB_NAME2, null, DB_VERSION2);
            Log.d("logtag", "helper 2 constructor");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE2);
            Log.d("logtag", "db created");
            // Toast.makeText(this, "DB Created", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE2);
            // Toast.makeText(this, "DB dropped", Toast.LENGTH_SHORT).show();
            onCreate(db);
            Log.d("logtag", "db upgraded");

        }
    }
}


