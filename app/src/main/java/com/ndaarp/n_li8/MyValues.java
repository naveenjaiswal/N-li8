package com.ndaarp.n_li8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by naveen on 9/24/2015.
 */
public class MyValues extends AppCompatActivity {


    DBAdapter2 adp2 ;
    //int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        adp2 = new DBAdapter2(this);
    }

    String [] clubs = {"Wall Street Club","STARTUP OASIS","Economics and International Programmes and Collaboration ","SU"};

    String [] subs = {"The Technical Analysis Program","PITCHCity: Pitch wow, Start now!","PITCHCity: Pitch wow, Start now! ","ANC Food deliveries to MB after the 11 PM"};

    String [] msgs = {"Wall Street Club & Mentored Research are happy to bring to you \"The Technical Analysis Program\"\n" +
            "\n" +
            "\n" +
            "Key points: \n" +
            "- Learn Charting & Stock price patterns\n" +
            "- Learn from a 15 year veteran trader & author of books on Technical Analysis \n" +
            "- 6 weeks, no pre requisite, online, guided \n" +
            "\n" +
            "\n" ,
            "About the Program: The program Technical Analysis is a beginner course, designed to impart skills that will enable students to work towards doing technical-based trading in the financial markets. The students are empowered to forecast future price activity of stocks based on historic market data, price and volume information. Understanding the tools of technical analysis is crucial for a short-term investor, as a day trader and/or a momentum trader.\n" +
            " \n" +
            "Mentored-Research is happy to be collaborating with Mr. Balkrishna Sadekar, Founder, Profitable Candlesticks Charting, LLC.  A member of the Technical Securities Analyst Association, the leading authority of Technical Analysis in United States, Balkrishna brings to the table his 15+ years of industry experience. In course of this program, he will guide the participants through the popular technical trading methods, and their applications through assignments. Mr. Sadekar is also the author of the book “How to make money trading with candlestick charts”.\n" +
            " \n" +
            "No Pre-requisites. Students from any discipline can apply \n" +
            " \n" +
            "Operational Details:\n" ,
            "• Opening registrations for the program. \n" +
            "• Well-thought out and carefully designed resource material and video lectures, in sync with popular industry practices, are shared regularly with the mentee to guide him/her through the program deliverables \n" +
            "• The participant will have the support of an expert query support team.\n" +
            "• The mentees will have the opportunity to interact with Mr. Sadekar periodically, in course of the program, through live webinars\n" +
            "• Exceptional performers may have the opportunity to take part in exciting internship opportunities\n" +
            " \n" +
            " \n",
            "Dates: The program is expected to begin on 10th October, and is scheduled to go on till the 2nd week of November\n" +
            "\u200B\n" +
            " \n" +
            "Program Deliverables: 3 Assignments, covering Indicators, Oscillators, Moving Averages, Western technical patterns, Candlestick charting, Ichimoku system. The assignments will be based on real world charts, and the participant, if sincere, will develop a keen understanding of the art of charting. \n" +
            " \n" +
            " \n" +
            "Cost: \n" +
            "• INR 5,999/- per student\n" +
            "• Early bird registrations: INR 5,499/- for registrations prior to 1stOct, 2015\n"
    };


    public void addDataDb () {

        for(int i=0;i<4;i++) {
            String club_str = clubs[i];
            String sub_str = subs[i];
            String msg_str = msgs[i];



            long ret_id = adp2.insertData(club_str, sub_str, msg_str);
            if (ret_id < 0) {
                Toast toast = Toast.makeText(this, "Unsuccessful: notices", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Toast toast = Toast.makeText(this, ret_id + " rows notices Inserted", Toast.LENGTH_SHORT);
                toast.show();
            }
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
