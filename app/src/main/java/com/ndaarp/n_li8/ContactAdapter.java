package com.ndaarp.n_li8;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by naveen on 9/23/2015.
 */
public class ContactAdapter extends
        RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);

        Log.d("ci",ci.club_str);
        Log.d("ci",ci.head_str);
        Log.d("ci", ci.msg_str);
        contactViewHolder.vName.setText(ci.head_str);
       // contactViewHolder.vSurname.setText(ci.head_str);
       // contactViewHolder.vEmail.setText(ci.msg_str);
        contactViewHolder.vTitle.setText(ci.club_str);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);
        return new ContactViewHolder(itemView);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;
        public View view;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
           // vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            //vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            vTitle = (TextView) v.findViewById(R.id.title);

        }
    }
}

