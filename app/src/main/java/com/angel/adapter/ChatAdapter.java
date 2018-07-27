package com.angel.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.angel.R;
import com.angel.activity.AngelChatActivity;
import com.angel.model.LoggedInUser;

import java.util.ArrayList;

/**
 * Created by Mindbowser on 6/7/2018.
 */

public class ChatAdapter extends BaseAdapter {

    protected LayoutInflater inflater;
    Context context;
    ArrayList<LoggedInUser> loggedInUsersList;

    public ChatAdapter(Context context,ArrayList<LoggedInUser> loggedInUsersList) {
        this.inflater = LayoutInflater.from(context);
        this.loggedInUsersList = loggedInUsersList;
        this.context = context;

    }


    @Override
    public int getCount() {
        return loggedInUsersList.size();
    }

    @Override
    public Object getItem(int position) {
        return loggedInUsersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inflater.inflate(R.layout.chat_message_row, parent, false);
            ViewHolder holder = new ViewHolder(row);
            row.setTag(holder);
        }
        final ViewHolder holder = (ViewHolder) row.getTag();

//        holder.userName.setText(userDeatailsKeys[position]);
//
//        holder.message.setText(userDetailsValues[position]);





        return row;

    }

    class ViewHolder {

        protected TextView userName;
        protected TextView message;
        protected TextView date;

        public ViewHolder(View view) {
            userName = (TextView) view.findViewById(R.id.activity_angel_name_tv);
            message = (TextView) view.findViewById(R.id.activity_angel_message_tv);
            date = (TextView) view.findViewById(R.id.activity_angel_date_tv);
        }
    }

}
