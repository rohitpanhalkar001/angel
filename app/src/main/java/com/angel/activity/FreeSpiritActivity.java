package com.angel.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.angel.R;
import com.angel.Util.Constants;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.adapter.ViewPagerAdapter;
import com.angel.fragment.AnxietyFragment;
import com.angel.fragment.DepressionFragment;
import com.angel.fragment.RejectionNeverousnessFragment;
import com.angel.fragment.RelationShipFragment;
import com.angel.model.UserQuestion;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FreeSpiritActivity extends AppCompatActivity implements View.OnClickListener{

    ViewPager viewPager;
    TabLayout tabLayout;
    TextView despressionbtn;

    TextView anixetyTv;
    TextView depressionTv;
    TextView nerverounessTv;
    TextView relationshipTv;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_spirit);

        initParamters();
        initView();

////        despressionbtn = (TextView) findViewById(R.id.submitBtn);
//        despressionbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });

//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        setupViewPager(viewPager);
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);

    }

    private void initView() {

    }

    private void initParamters() {


        anixetyTv = (TextView) findViewById(R.id.activity_free_spirit_Anixety);
        depressionTv = (TextView) findViewById(R.id.activity_free_spirit_depression);
        nerverounessTv = (TextView) findViewById(R.id.activity_free_spirit_nervernous);
        relationshipTv = (TextView) findViewById(R.id.activity_free_spirit_relationship);
        linearLayout = (LinearLayout) findViewById(R.id.activity_free_sprit_grid);


        anixetyTv.setOnClickListener(this);
        depressionTv.setOnClickListener(this);
        nerverounessTv.setOnClickListener(this);
        relationshipTv.setOnClickListener(this);

        SharedPreferencesUtils.saveLoggedInUser("freeSprit", FreeSpiritActivity.this);
    }
//
//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new AnxietyFragment(), "Anxiety");
//        adapter.addFragment(new DepressionFragment(), "Depression");
//        adapter.addFragment(new RejectionNeverousnessFragment(), "Rejection Neverousness");
//        adapter.addFragment(new RelationShipFragment(), "RelationShip");
//
//        viewPager.setAdapter(adapter);
//    }



    @Override
    public void onClick(View v) {
        linearLayout.setVisibility(View.GONE);

        switch (v.getId()){
            case R.id.activity_free_spirit_Anixety:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_free_spirit_container,new AnxietyFragment()).addToBackStack(null).commit();
                break;

            case R.id.activity_free_spirit_depression:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_free_spirit_container,new DepressionFragment()).addToBackStack(null).commit();
                break;

            case R.id.activity_free_spirit_nervernous:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_free_spirit_container,new RejectionNeverousnessFragment()).addToBackStack(null).commit();
                break;

            case R.id.activity_free_spirit_relationship:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_free_spirit_container,new RelationShipFragment()).addToBackStack(null).commit();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
