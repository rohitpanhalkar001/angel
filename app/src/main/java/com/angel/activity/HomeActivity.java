package com.angel.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.angel.R;
import com.angel.Util.Constants;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.adapter.ViewPagerAdapter;
import com.angel.fragment.AnxietyFragment;
import com.angel.fragment.ChatFragment;
import com.angel.fragment.DepressionFragment;
import com.angel.fragment.ProfileFragment;
import com.angel.fragment.RejectionNeverousnessFragment;
import com.angel.fragment.RelationShipFragment;
import com.angel.model.LoggedInUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;
    DataSnapshot storeSpanShot;

    public static LoggedInUser loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();


    }

    private void initView() {
        SharedPreferencesUtils.saveLoggedInUser("angel",HomeActivity.this);

        loggedInUser = (LoggedInUser) getIntent().getSerializableExtra("loggerUser");


        viewPager = (ViewPager) findViewById(R.id.activity_home_viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.activity_home_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new ChatFragment(), "Chat");

        viewPager.setAdapter(adapter);
    }

}

