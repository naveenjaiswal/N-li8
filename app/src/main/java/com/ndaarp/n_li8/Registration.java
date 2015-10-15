package com.ndaarp.n_li8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


public class Registration extends AppCompatActivity {

    EditText email,id,name,mob,passwd,room;
   // DatePicker date;
    Spinner hostel;
    DBAdapter adp ;
    //int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email =(EditText) findViewById(R.id.editText4);
        id =(EditText) findViewById(R.id.editText5);
        name =(EditText) findViewById(R.id.editText6);
        mob =(EditText) findViewById(R.id.editText7);
        passwd =(EditText) findViewById(R.id.editText8);
        room =(EditText) findViewById(R.id.editText9);
        //date = (DatePicker) findViewById(R.id.datePicker);
        hostel = (Spinner) findViewById(R.id.spinner1);

       // final Calendar c = Calendar.getInstance();
       // year = c.get(Calendar.YEAR);
       // month = c.get(Calendar.MONTH);
        //day = c.get(Calendar.DAY_OF_MONTH);
        adp = new DBAdapter(this);
    }



    public void addUser(View view) {
        String email_str = email.getText().toString();
        String id_str = id.getText().toString();
        String name_str = name.getText().toString();
        String mob_str = mob.getText().toString();
        String pass_str = passwd.getText().toString();
        String hostel_str = hostel.getSelectedItem().toString();
        String room_str = room.getText().toString();

      //  long ret_id = adp.insertData(email_str, name_str, id_str, mob_str, pass_str, day, month, year, hostel_str, room_int);
        long ret_id = adp.insertData(email_str, name_str, id_str, mob_str, pass_str,hostel_str,room_str);
        if (ret_id < 0) {Toast toast = Toast.makeText(this, "Registration not successful", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG);
            toast.show();
            startActivity(new Intent(Registration.this, Login.class));
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
