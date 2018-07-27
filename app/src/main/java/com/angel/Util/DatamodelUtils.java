package com.angel.Util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.angel.activity.HomeActivity;
import com.angel.fragment.AnxietyFragment;
import com.angel.model.LoggedInUser;
import com.angel.model.UserQuestion;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Mindbowser on 6/30/2018.
 */

public class DatamodelUtils {

    public static HashMap<String, String> hashMap = new HashMap<String, String>();

    public static ArrayList<UserQuestion> userQuestionArrayList;
    public static Context context;

    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabase;
    public static int randomPickedUser;

    public static ArrayList<LoggedInUser> adminUserList;
    public static LoggedInUser loggedInUser;

    public DatamodelUtils(Context context){
        this.context = context;
        userQuestionArrayList = new ArrayList<>();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        adminUserList = new ArrayList<>();

    }


    public static void getValuesToStoreInDB(){
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            UserQuestion userQuestion = new UserQuestion();
            userQuestion.setQuestion(entry.getKey());
            userQuestion.setAnswer(entry.getValue());
            userQuestionArrayList.add(userQuestion);
        }

        SharedPreferencesUtils.saveSelectedSession(userQuestionArrayList, context);

    }



    public static void getAdminUserToChat(final Context activity) {
        mDatabase = mFirebaseDatabase.getReference().child("LOGIN_USER");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("SocialMediaActivity", "called always");

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    try {
                        LoggedInUser message = postSnapshot.getValue(LoggedInUser.class);
                        adminUserList.add(message);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                randomPickedUser = random.nextInt(adminUserList.size());

                Log.i("SocialMediaActivity", "called randomPickedUser "+randomPickedUser);
                loggedInUser = adminUserList.get(randomPickedUser);

                Intent intent = new Intent(activity, HomeActivity.class);
                intent.putExtra("loggerUser",loggedInUser);
                activity.startActivity(intent);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("SocialMediaActivity", "databaseError"+databaseError);
            }
        });
    }


}
