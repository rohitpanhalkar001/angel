package com.angel.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.angel.R;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.activity.AngelChatActivity;
import com.angel.activity.HomeActivity;
import com.angel.adapter.UserChatListAdapter;
import com.angel.model.LoggedInUser;
import com.angel.model.UserChatMessageList;
import com.angel.model.UserQuestion;
//import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    ArrayList<UserQuestion> userQuestionArrayList;
    FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;

    LinearLayout layout;
    RelativeLayout layout_2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
//    Firebase reference1, reference2;


    ListView lv;
    EditText messageEd;
    ImageView sendBtnImg;
    UserChatListAdapter userChatListAdapter;
    String fromUserId;
    String toUserId;
    String username;
    ArrayList<UserChatMessageList> userChatMessageList = new ArrayList<>();
    ArrayList<UserChatMessageList> selectedUserList = new ArrayList<>();

    UserChatMessageList userChatMessage = new UserChatMessageList();

    int randomPickedUser;
    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        initParameters(view);
        initView(view);


        return view;
    }

    private void initView(View view) {

//        layout = (LinearLayout) view.findViewById(R.id.layout1);
//        layout_2 = (RelativeLayout) view.findViewById(R.id.layout2);
//        sendButton = (ImageView) view.findViewById(R.id.sendButton);
//        messageArea = (EditText) view.findViewById(R.id.messageArea);
//        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
//
//
//        Firebase.setAndroidContext(getActivity());
//        reference1 = new Firebase("https://androidchatapp-76776.firebaseio.com/messages/" + UserDetails.username + "_" + UserDetails.chatWith);
//        reference2 = new Firebase("https://androidchatapp-76776.firebaseio.com/messages/" + UserDetails.chatWith + "_" + UserDetails.username);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        getAllChatMsgBetweenAngelAndFreeSpirit();
    }

    private void getAllChatMsgBetweenAngelAndFreeSpirit() {
        mDatabase = mFirebaseDatabase.getReference().child("USER_CHAT");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("SocialMediaActivity", "called always");

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    try {
                        UserChatMessageList message = postSnapshot.getValue(UserChatMessageList.class);
                        userChatMessageList.add(message);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0;i<userChatMessageList.size(); i++){
                    String userId[] = userChatMessageList.get(i).getToUserID().split("-");

                    if (userId[1].equals("LGtU86rtCUZuj2rVqpi")) {
                        selectedUserList.add(userChatMessageList.get(i));
                    }

                }
                    setAdapter();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("SocialMediaActivity", "databaseError"+databaseError);
            }
        });
    }


    private void setAdapter() {
        userChatListAdapter = new UserChatListAdapter(getActivity(),selectedUserList);
        lv.setAdapter(userChatListAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AngelChatActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initParameters(View view) {
        userQuestionArrayList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.userChatListLv);
        sendBtnImg = (ImageView) view.findViewById(R.id.fragment_chat_sendBtnImg);
        messageEd = (EditText) view.findViewById(R.id.fragment_chat_messageEd);



        sendBtnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (SharedPreferencesUtils.LoadSelectedUser(getActivity()).equals("Angel")){

                    for (int i = 0; i<userChatMessageList.size(); i++){
                        fromUserId = userChatMessageList.get(i).getFromUserId();
                        if (userChatMessage.getToUserID()==null){
                            Toast.makeText(getActivity(),"No Host Available ",Toast.LENGTH_SHORT).show();

                        }else {
                            if (userChatMessageList.get(i).getToUserID().contains("-LF1JoOfs0gqN_SeIoD")) {
                                toUserId = userChatMessageList.get(i).getToUserID();
                                username = userChatMessageList.get(i).getUsername();

                                insertChatMessageToDb();
                            }
                        }

                    }
                }else {
                    toUserId = HomeActivity.loggedInUser.getId();
                    fromUserId = SharedPreferencesUtils.loadLoggedInUser(getActivity()).toString();
                    username = SharedPreferencesUtils.loadUserName(getActivity()).toString();

                    insertChatMessageToDb();
                }



            }
        });
    }

    private void insertChatMessageToDb() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("USER_CHAT").push();

        String firebaseUserId = databaseReference.getKey();
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("ChatID", firebaseUserId);
        userDetails.put("fromUserId",fromUserId);
        userDetails.put("toUserID", toUserId);
        userDetails.put("userName", username);
        userDetails.put("Message", messageEd.getText().toString());
        userDetails.put("created_Date", new Date().toString());
        databaseReference.setValue(userDetails);


        userChatListAdapter.notifyDataSetChanged();

        userChatMessage.setChatID(firebaseUserId);
        userChatMessage.setCreated_Date(new Date().toString());
        userChatMessage.setFromUserId(fromUserId);
        userChatMessage.setToUserID(toUserId);
        userChatMessage.setUsername(username);
        userChatMessage.setMessage(messageEd.getText().toString());
        selectedUserList.add(userChatMessage);

        messageEd.setText("");
        setAdapter();

    }


}
