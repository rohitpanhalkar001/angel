package com.angel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.angel.R;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.model.UserChatMessageList;

import java.util.ArrayList;

/**
 * Created by Mindbowser on 6/20/2018.
 */

public class UserChatListAdapter extends BaseAdapter {

    protected LayoutInflater inflater;
    Context context;
    ArrayList<UserChatMessageList> loggedInUsersList;

    protected TextView userName;
    protected TextView message;
    protected TextView date;


    public UserChatListAdapter(Context context, ArrayList<UserChatMessageList> loggedInUsersList) {
        this.context = context;
        this.loggedInUsersList = loggedInUsersList;
        this.inflater = LayoutInflater.from(context);
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
//        View row = convertView;

//        if (row == null) {
//            row = inflater.inflate(R.layout.user_chat_list_row, parent, false);
//            ViewHolder holder = new ViewHolder(row);
//            row.setTag(holder);
//        }
//        final ViewHolder holder = (ViewHolder) row.getTag();
//
//        holder.userName.setText(loggedInUsersList.get(position).getUsername());
//
//        holder.message.setText(loggedInUsersList.get(position).getMessage());
//        holder.date.setText(loggedInUsersList.get(position).getCreated_Date());


        String userId = SharedPreferencesUtils.loadLoggedInUser(context).toString();
        String id[] = userId.split("-");
        String chatUser = loggedInUsersList.get(position).getFromUserId();
        String chatUserId[] = chatUser.split("-");
        if (id[1].equals(chatUserId[1])){
            convertView=inflater.inflate(R.layout.user_chat_list_row, null,true);
            userName = (TextView) convertView.findViewById(R.id.user_chat_list_row_usernametv);
            message = (TextView) convertView.findViewById(R.id.user_chat_list_row_messageTv);

            date = (TextView) convertView.findViewById(R.id.user_chat_list_row_datetv);

            userName.setText(loggedInUsersList.get(position).getUsername());

            message.setText(loggedInUsersList.get(position).getMessage());
            date.setText(loggedInUsersList.get(position).getCreated_Date());

//                thirdLine.setText(messages.get(position).getPostedTime());

        }else {
            convertView=inflater.inflate(R.layout.row_chat_message_left, null,true);
            userName = (TextView) convertView.findViewById(R.id.user_chat_list_row_usernametv);
            message = (TextView) convertView.findViewById(R.id.user_chat_list_row_messageTv);

            date = (TextView) convertView.findViewById(R.id.user_chat_list_row_datetv);

            userName.setText(loggedInUsersList.get(position).getUsername());

            message.setText(loggedInUsersList.get(position).getMessage());
            date.setText(loggedInUsersList.get(position).getCreated_Date());

//                thirdLineleft.setText(Utils.convertUtcToLocal(messages.get(position).getPostedTime(), Utils.FORMAT_LOCAL_EVENT));
        }



        return convertView;
    }


}
