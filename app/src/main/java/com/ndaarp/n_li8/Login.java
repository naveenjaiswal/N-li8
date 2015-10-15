package com.ndaarp.n_li8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DBAdapter adp ;
     TextView tv;
    EditText mail_id,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adp = new DBAdapter(this);
        tv = (TextView)findViewById(R.id.textView5);
        mail_id =(EditText) findViewById(R.id.editText);
        password =(EditText) findViewById(R.id.editText2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

    }


    public void viewdata(View view)
    {
        String data = adp.getdata(mail_id.getText().toString());

        if(data.equals( password.getText().toString())){
            startActivity(new Intent(Login.this, MainActivity.class));

        }
        else {
            Toast toast = Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
