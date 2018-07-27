package com.angel.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.angel.R;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.activity.HomeActivity;
import com.angel.model.LoggedInUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mDatabase;
    public ArrayList<LoggedInUser> adminUserList;

    private CircleImageView iv;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        adminUserList = new ArrayList<>();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        iv = (CircleImageView) view.findViewById(R.id.profile_image);

        mDatabase = mFirebaseDatabase.getReference().child("LOGIN_USER");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("ProfileFragment", "called always");

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    try {
                        LoggedInUser message = postSnapshot.getValue(LoggedInUser.class);
                        adminUserList.add(message);

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("ProfileFragment", "databaseError"+e);

                    }
                }

                String userId = SharedPreferencesUtils.loadLoggedInUser(getActivity()).toString();

                for (int i = 0; i<adminUserList.size(); i++){
                    if (userId.equals(adminUserList.get(i).getId())){
//                        Picasso.with(getActivity()).load(adminUserList.get(i).getProfilePic()).into(iv);
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("ProfileFragment", "databaseError"+databaseError);
            }
        });



    }

}
