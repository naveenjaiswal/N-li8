package com.ndaarp.n_li8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private Adapter adapter;
    //DBAdapter2 adp2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // adp2 = new DBAdapter2(this);
      // this.addDataDb();
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        ContactAdapter ca = new ContactAdapter(getList());
        recList.setAdapter(ca);



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private List<ContactInfo> getList() {

        List<ContactInfo> result = new ArrayList<ContactInfo>();
        List<String> strArr = new ArrayList<String>();
     //  strArr = adp2.getAlldata();


        for (int i=0; i < 6; i++) {
            ContactInfo ci = new ContactInfo();

         //   Log.d("mytag",strArr.get(i)[0]);
           // Log.d("mytag",strArr.get(i)[1]);
            //Log.d("mytag",strArr.get(i)[2]);
           // ci.club_str=strArr.get(i)[0];
            //ci.head_str =strArr.get(i)[1];
            //ci.msg_str =strArr.get(i)[2];

            ci.club_str=clubs[i];
            ci.head_str=subs[i];
            ci.msg_str =msgs[i];

            result.add(ci);

        }

        return result;
    }

    String [] clubs = {"Wall Street Club","STARTUP OASIS","Economics and International Programmes and Collaboration ","SU","ARCD","DANCE CLUB"};

    String [] subs = {"The Technical Analysis Program","PITCHCity: Pitch wow, Start now!","PITCHCity: Pitch wow, Start now! ","ANC Food deliveries to MB after the 11 PM","late registration","invites for garba"};

    String [] msgs = {"Wall Street Club & Mentored Research are happy to bring to you The Technical Analysis Program",
            "About the Program: The program Technical Analysis is a beginner course, designed to impart skills that will en",
                    "• Well-thought out and carefully designed resource material and video lectures, in sync with popular industry",
                    "• Early bird registrations: INR 5,499/- for registrations prior to 1stOct, 2015","f","sfs"
    };





}
