package com.angel.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.angel.R;
import com.angel.Util.DatamodelUtils;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.activity.FreeSpiritActivity;
import com.angel.activity.HomeActivity;
import com.angel.model.UserQuestion;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import static com.angel.Util.DatamodelUtils.getValuesToStoreInDB;
import static com.angel.Util.DatamodelUtils.hashMap;
import static com.angel.Util.DatamodelUtils.userQuestionArrayList;


public class DepressionFragment extends Fragment {

    String dont_bother_me;
    String appetite_was_poor;
    String depressed__sad_even_assistance;
    String good_as_other_people;
    String concentration_on_what_I_was_doing;
    String depressed;
    String everything_I_did_was_an_effort;
    String future;
    String failure;
    String fearful;
    String restless;
    String happy;
    String usual;
    String lonely;
    String unfriendly;
    String life;
    String spells;
    String sad;
    String disliked;
    String get_going;

    TextView despressionbtn;

    TextView depressionTv1;
    TextView depressionTv2;
    TextView depressionTv3;
    TextView depressionTv4;
    TextView depressionTv5;
    TextView depressionTv6;
    TextView depressionTv7;
    TextView depressionTv8;
    TextView depressionTv9;
    TextView depressionTv10;
    TextView depressionTv11;
    TextView depressionTv12;
    TextView depressionTv13;
    TextView depressionTv14;
    TextView depressionTv15;
    TextView depressionTv16;
    TextView depressionTv17;
    TextView depressionTv18;
    TextView depressionTv19;
    TextView depressionTv20;



    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;
    RadioGroup radioGroup6;
    RadioGroup radioGroup7;
    RadioGroup radioGroup8;
    RadioGroup radioGroup9;
    RadioGroup radioGroup10;
    RadioGroup radioGroup11;
    RadioGroup radioGroup12;
    RadioGroup radioGroup13;
    RadioGroup radioGroup14;
    RadioGroup radioGroup15;
    RadioGroup radioGroup16;
    RadioGroup radioGroup17;
    RadioGroup radioGroup18;
    RadioGroup radioGroup19;
    RadioGroup radioGroup20;



    RadioButton radiobutton1;
    RadioButton radiobutton2;
    RadioButton radiobutton3;
    RadioButton radiobutton4;
    RadioButton radiobutton5;
    RadioButton radiobutton6;
    RadioButton radiobutton7;
    RadioButton radiobutton8;
    RadioButton radiobutton9;
    RadioButton radiobutton10;
    RadioButton radiobutton11;
    RadioButton radiobutton12;
    RadioButton radiobutton13;
    RadioButton radiobutton14;
    RadioButton radiobutton15;
    RadioButton radiobutton16;
    RadioButton radiobutton17;
    RadioButton radiobutton18;
    RadioButton radiobutton19;
    RadioButton radiobutton20;
    RadioButton radiobutton21;
    RadioButton radiobutton22;
    RadioButton radiobutton23;
    RadioButton radiobutton24;
    RadioButton radiobutton25;
    RadioButton radiobutton26;
    RadioButton radiobutton27;
    RadioButton radiobutton28;
    RadioButton radiobutton29;
    RadioButton radiobutton30;
    RadioButton radiobutton31;
    RadioButton radiobutton32;
    RadioButton radiobutton33;
    RadioButton radiobutton34;
    RadioButton radiobutton35;
    RadioButton radiobutton36;
    RadioButton radiobutton37;
    RadioButton radiobutton38;
    RadioButton radiobutton39;
    RadioButton radiobutton40;



    RadioButton radiobutton41;
    RadioButton radiobutton42;
    RadioButton radiobutton43;
    RadioButton radiobutton44;
    RadioButton radiobutton45;
    RadioButton radiobutton46;
    RadioButton radiobutton47;
    RadioButton radiobutton48;
    RadioButton radiobutton49;
    RadioButton radiobutton50;
    RadioButton radiobutton51;
    RadioButton radiobutton52;
    RadioButton radiobutton53;
    RadioButton radiobutton54;
    RadioButton radiobutton55;
    RadioButton radiobutton56;
    RadioButton radiobutton57;
    RadioButton radiobutton58;
    RadioButton radiobutton59;
    RadioButton radiobutton60;
    RadioButton radiobutton61;
    RadioButton radiobutton62;
    RadioButton radiobutton63;
    RadioButton radiobutton64;
    RadioButton radiobutton65;
    RadioButton radiobutton66;
    RadioButton radiobutton67;
    RadioButton radiobutton68;
    RadioButton radiobutton69;
    RadioButton radiobutton70;
    RadioButton radiobutton71;
    RadioButton radiobutton72;
    RadioButton radiobutton73;
    RadioButton radiobutton74;
    RadioButton radiobutton75;
    RadioButton radiobutton76;
    RadioButton radiobutton77;
    RadioButton radiobutton78;
    RadioButton radiobutton79;
    RadioButton radiobutton80;


    ArrayList<UserQuestion> userQuestionArrayList;

    Button submitBtn;

    public DepressionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_depression, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {

        submitBtn = (Button) view.findViewById(R.id.fragment_depression_submit);

        depressionTv1 = (TextView) view.findViewById(R.id.depression_fagr_tv1);
        depressionTv2 = (TextView) view.findViewById(R.id.depression_fagr_tv2);
        depressionTv3 = (TextView) view.findViewById(R.id.depression_fagr_tv3);
        depressionTv4 = (TextView) view.findViewById(R.id.depression_fagr_tv4);
        depressionTv5 = (TextView) view.findViewById(R.id.depression_fagr_tv5);
        depressionTv6 = (TextView) view.findViewById(R.id.depression_fagr_tv6);
        depressionTv7 = (TextView) view.findViewById(R.id.depression_fagr_tv7);
        depressionTv8 = (TextView) view.findViewById(R.id.depression_fagr_tv8);
        depressionTv9 = (TextView) view.findViewById(R.id.depression_fagr_tv9);
        depressionTv10 = (TextView) view.findViewById(R.id.depression_fagr_tv10);
        depressionTv11 = (TextView) view.findViewById(R.id.depression_fagr_tv11);
        depressionTv12 = (TextView) view.findViewById(R.id.depression_fagr_tv12);
        depressionTv13 = (TextView) view.findViewById(R.id.depression_fagr_tv13);
        depressionTv14 = (TextView) view.findViewById(R.id.depression_fagr_tv14);
        depressionTv15 = (TextView) view.findViewById(R.id.depression_fagr_tv15);
        depressionTv16 = (TextView) view.findViewById(R.id.depression_fagr_tv16);
        depressionTv17 = (TextView) view.findViewById(R.id.depression_fagr_tv17);
        depressionTv18 = (TextView) view.findViewById(R.id.depression_fagr_tv18);
        depressionTv19 = (TextView) view.findViewById(R.id.depression_fagr_tv19);
        depressionTv20 = (TextView) view.findViewById(R.id.depression_fagr_tv20);






        radioGroup1 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_1);
        radioGroup2 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_2);
        radioGroup3 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_3);
        radioGroup4 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_4);
        radioGroup5 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_5);
        radioGroup6 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_6);
        radioGroup7 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_7);
        radioGroup8 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_8);
        radioGroup9 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_9);
        radioGroup10 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_10);
        radioGroup11 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_11);
        radioGroup12 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_12);
        radioGroup13 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_13);
        radioGroup14 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_14);
        radioGroup15 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_15);
        radioGroup16 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_16);
        radioGroup17 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_17);
        radioGroup18 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_18);
        radioGroup19 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_19);
        radioGroup20 = (RadioGroup) view.findViewById(R.id.depression_radioGroup_20);


///Radio button
        radiobutton1 = (RadioButton) view.findViewById(R.id.dont_bother_me_radioButton_1);
        radiobutton2 = (RadioButton) view.findViewById(R.id.dont_bother_me_radioButton_2);
        radiobutton3 = (RadioButton) view.findViewById(R.id.dont_bother_me_radioButton_3);
        radiobutton4 = (RadioButton) view.findViewById(R.id.dont_bother_me_radioButton_4);

        radiobutton5 = (RadioButton) view.findViewById(R.id.appetite_was_poor_radioButton_1);
        radiobutton6 = (RadioButton) view.findViewById(R.id.appetite_was_poor_radioButton_2);
        radiobutton7 = (RadioButton) view.findViewById(R.id.appetite_was_poor_radioButton_3);
        radiobutton8 = (RadioButton) view.findViewById(R.id.appetite_was_poor_radioButton_4);

        radiobutton9 = (RadioButton) view.findViewById(R.id.depressed__sad_even_assistance_radioButton_1);
        radiobutton10 = (RadioButton) view.findViewById(R.id.depressed__sad_even_assistance_radioButton_2);
        radiobutton11 = (RadioButton) view.findViewById(R.id.depressed__sad_even_assistance_radioButton_3);
        radiobutton12 = (RadioButton) view.findViewById(R.id.depressed__sad_even_assistance_radioButton_4);

        radiobutton13 = (RadioButton) view.findViewById(R.id.good_as_other_people_radioButton1);
        radiobutton14 = (RadioButton) view.findViewById(R.id.good_as_other_people_radioButton2);
        radiobutton15 = (RadioButton) view.findViewById(R.id.good_as_other_people_radioButton3);
        radiobutton16 = (RadioButton) view.findViewById(R.id.good_as_other_people_radioButton4);

        radiobutton17 = (RadioButton) view.findViewById(R.id.concentration_on_what_I_was_doing_radiobutton1);
        radiobutton18 = (RadioButton) view.findViewById(R.id.concentration_on_what_I_was_doing_radiobutton2);
        radiobutton19 = (RadioButton) view.findViewById(R.id.concentration_on_what_I_was_doing_radiobutton3);
        radiobutton20 = (RadioButton) view.findViewById(R.id.concentration_on_what_I_was_doing_radiobutton4);

        radiobutton21 = (RadioButton) view.findViewById(R.id.depressed_radioButton1);
        radiobutton22 = (RadioButton) view.findViewById(R.id.depressed_radioButton2);
        radiobutton23 = (RadioButton) view.findViewById(R.id.depressed_radioButton3);
        radiobutton24 = (RadioButton) view.findViewById(R.id.depressed_radioButton4);

        radiobutton25 = (RadioButton) view.findViewById(R.id.everything_I_did_was_an_effort_radioButton_1);
        radiobutton26 = (RadioButton) view.findViewById(R.id.everything_I_did_was_an_effort_radioButton_2);
        radiobutton27 = (RadioButton) view.findViewById(R.id.everything_I_did_was_an_effort_radioButton_3);
        radiobutton28 = (RadioButton) view.findViewById(R.id.everything_I_did_was_an_effort_radioButton_4);

        radiobutton29 = (RadioButton) view.findViewById(R.id.future_radioButton_1);
        radiobutton30 = (RadioButton) view.findViewById(R.id.future_radioButton_2);
        radiobutton31 = (RadioButton) view.findViewById(R.id.future_radioButton_3);
        radiobutton32 = (RadioButton) view.findViewById(R.id.future_radioButton_4);

        radiobutton33 = (RadioButton) view.findViewById(R.id.failure_radioButton_1);
        radiobutton34 = (RadioButton) view.findViewById(R.id.failure_radioButton_2);
        radiobutton35 = (RadioButton) view.findViewById(R.id.failure_radioButton_3);
        radiobutton36 = (RadioButton) view.findViewById(R.id.failure_radioButton_4);

        radiobutton37 = (RadioButton) view.findViewById(R.id.fearful_radioButton1);
        radiobutton38 = (RadioButton) view.findViewById(R.id.fearful_radioButton2);
        radiobutton39 = (RadioButton) view.findViewById(R.id.fearful_radioButton3);
        radiobutton40 = (RadioButton) view.findViewById(R.id.fearful_radioButton4);

        radiobutton41 = (RadioButton) view.findViewById(R.id.restless_radiobutton1);
        radiobutton42 = (RadioButton) view.findViewById(R.id.restless_radiobutton2);
        radiobutton43 = (RadioButton) view.findViewById(R.id.restless_radiobutton3);
        radiobutton44 = (RadioButton) view.findViewById(R.id.restless_radiobutton4);

        radiobutton45 = (RadioButton) view.findViewById(R.id.happy_radioButton1);
        radiobutton46 = (RadioButton) view.findViewById(R.id.happy_radioButton2);
        radiobutton47 = (RadioButton) view.findViewById(R.id.happy_radioButton3);
        radiobutton48 = (RadioButton) view.findViewById(R.id.happy_radioButton4);

        radiobutton49 = (RadioButton) view.findViewById(R.id.usual_radioButton_1);
        radiobutton50 = (RadioButton) view.findViewById(R.id.usual_radioButton_2);
        radiobutton51 = (RadioButton) view.findViewById(R.id.usual_radioButton_3);
        radiobutton52 = (RadioButton) view.findViewById(R.id.usual_radioButton_4);

        radiobutton53 = (RadioButton) view.findViewById(R.id.lonely_radioButton_1);
        radiobutton54 = (RadioButton) view.findViewById(R.id.lonely_radioButton_2);
        radiobutton55 = (RadioButton) view.findViewById(R.id.lonely_radioButton_3);
        radiobutton56 = (RadioButton) view.findViewById(R.id.lonely_radioButton_4);

        radiobutton57 = (RadioButton) view.findViewById(R.id.unfriendly_radioButton_1);
        radiobutton58 = (RadioButton) view.findViewById(R.id.unfriendly_radioButton_2);
        radiobutton59 = (RadioButton) view.findViewById(R.id.unfriendly_radioButton_3);
        radiobutton60 = (RadioButton) view.findViewById(R.id.unfriendly_radioButton_4);

        radiobutton61 = (RadioButton) view.findViewById(R.id.life_radioButton1);
        radiobutton62 = (RadioButton) view.findViewById(R.id.life_radioButton2);
        radiobutton63 = (RadioButton) view.findViewById(R.id.life_radioButton3);
        radiobutton64 = (RadioButton) view.findViewById(R.id.life_radioButton4);

        radiobutton65 = (RadioButton) view.findViewById(R.id.spells_radiobutton1);
        radiobutton66 = (RadioButton) view.findViewById(R.id.spells_radiobutton2);
        radiobutton67 = (RadioButton) view.findViewById(R.id.spells_radiobutton3);
        radiobutton68 = (RadioButton) view.findViewById(R.id.spells_radiobutton4);

        radiobutton69 = (RadioButton) view.findViewById(R.id.sad_radioButton1);
        radiobutton70 = (RadioButton) view.findViewById(R.id.sad_radioButton2);
        radiobutton71 = (RadioButton) view.findViewById(R.id.sad_radioButton3);
        radiobutton72 = (RadioButton) view.findViewById(R.id.sad_radioButton4);

        radiobutton73 = (RadioButton) view.findViewById(R.id.disliked_radiobutton1);
        radiobutton74 = (RadioButton) view.findViewById(R.id.disliked_radiobutton2);
        radiobutton75 = (RadioButton) view.findViewById(R.id.disliked_radiobutton3);
        radiobutton76 = (RadioButton) view.findViewById(R.id.disliked_radiobutton4);

        radiobutton77 = (RadioButton) view.findViewById(R.id.depression_radioButton1);
        radiobutton78 = (RadioButton) view.findViewById(R.id.depression_radioButton2);
        radiobutton79 = (RadioButton) view.findViewById(R.id.depression_radioButton3);
        radiobutton80 = (RadioButton) view.findViewById(R.id.depression_radioButton4);


      radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId){
                  case R.id.dont_bother_me_radioButton_1:
                      dont_bother_me = "Rarely or None of the Time (Less than 1 day)";
                      hashMap.put(depressionTv1.getText().toString(),dont_bother_me);
                      break;
                  case R.id.dont_bother_me_radioButton_2:
                      dont_bother_me = "Some or a Little of the Time (1-2 days)";
                      hashMap.put(depressionTv1.getText().toString(),dont_bother_me);
                      break;
                  case R.id.dont_bother_me_radioButton_3:
                      dont_bother_me = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                      hashMap.put(depressionTv1.getText().toString(),dont_bother_me);
                      break;
                  case R.id.dont_bother_me_radioButton_4:
                      dont_bother_me = "All of the Time (5-7 days)";
                      hashMap.put(depressionTv1.getText().toString(),dont_bother_me);
                      break;
                      default:
                          break;
              }
          }
      });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.appetite_was_poor_radioButton_1:
                        appetite_was_poor = "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv2.getText().toString(),appetite_was_poor);
                        break;
                    case R.id.appetite_was_poor_radioButton_2:
                        appetite_was_poor = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv2.getText().toString(),appetite_was_poor);
                        break;
                    case R.id.appetite_was_poor_radioButton_3:
                        appetite_was_poor = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv2.getText().toString(),appetite_was_poor);
                        break;
                    case R.id.appetite_was_poor_radioButton_4:
                        appetite_was_poor = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv2.getText().toString(),appetite_was_poor);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.depressed__sad_even_assistance_radioButton_1:
                        depressed__sad_even_assistance =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv3.getText().toString(),depressed__sad_even_assistance);
                        break;
                    case R.id.depressed__sad_even_assistance_radioButton_2:
                        depressed__sad_even_assistance = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv3.getText().toString(),depressed__sad_even_assistance);
                        break;
                    case R.id.depressed__sad_even_assistance_radioButton_3:
                        depressed__sad_even_assistance = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv3.getText().toString(),depressed__sad_even_assistance);
                        break;
                    case R.id.depressed__sad_even_assistance_radioButton_4:
                        depressed__sad_even_assistance = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv3.getText().toString(),depressed__sad_even_assistance);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.good_as_other_people_radioButton1:

                        good_as_other_people =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv4.getText().toString(),good_as_other_people);
                        break;
                    case R.id.good_as_other_people_radioButton2:
                        good_as_other_people = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv4.getText().toString(),good_as_other_people);

                        break;
                    case R.id.good_as_other_people_radioButton3:
                        good_as_other_people ="Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv4.getText().toString(),good_as_other_people);

                        break;
                    case R.id.good_as_other_people_radioButton4:
                        good_as_other_people = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv4.getText().toString(),good_as_other_people);

                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.concentration_on_what_I_was_doing_radiobutton1:
                        concentration_on_what_I_was_doing =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv5.getText().toString(),concentration_on_what_I_was_doing);

                        break;
                    case R.id.concentration_on_what_I_was_doing_radiobutton2:
                        concentration_on_what_I_was_doing = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv5.getText().toString(),concentration_on_what_I_was_doing);
                        break;
                    case R.id.concentration_on_what_I_was_doing_radiobutton3:
                        concentration_on_what_I_was_doing = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv5.getText().toString(),concentration_on_what_I_was_doing);
                        break;
                    case R.id.concentration_on_what_I_was_doing_radiobutton4:
                        concentration_on_what_I_was_doing = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv5.getText().toString(),concentration_on_what_I_was_doing);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.depressed_radioButton1:
                        depressed =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv6.getText().toString(),depressed);

                        break;
                    case R.id.depressed_radioButton2:
                        depressed = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv6.getText().toString(),depressed);
                        break;
                    case R.id.depressed_radioButton3:
                        depressed ="Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv6.getText().toString(),depressed);
                        break;
                    case R.id.depressed_radioButton4:
                        depressed = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv6.getText().toString(),depressed);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.everything_I_did_was_an_effort_radioButton_1:
                        everything_I_did_was_an_effort =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv7.getText().toString(),everything_I_did_was_an_effort);
                        break;
                    case R.id.everything_I_did_was_an_effort_radioButton_2:
                        everything_I_did_was_an_effort = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv7.getText().toString(),everything_I_did_was_an_effort);
                        break;
                    case R.id.everything_I_did_was_an_effort_radioButton_3:
                        everything_I_did_was_an_effort = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv7.getText().toString(),everything_I_did_was_an_effort);
                        break;
                    case R.id.everything_I_did_was_an_effort_radioButton_4:
                        everything_I_did_was_an_effort = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv7.getText().toString(),everything_I_did_was_an_effort);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.future_radioButton_1:
                        future =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv8.getText().toString(),future);
                        break;
                    case R.id.future_radioButton_2:
                        future = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv8.getText().toString(),future);
                        break;
                    case R.id.future_radioButton_3:
                        future = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv8.getText().toString(),future);
                        break;
                    case R.id.future_radioButton_4:
                        future = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv8.getText().toString(),future);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.failure_radioButton_1:
                        failure =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv9.getText().toString(),failure);
                        break;
                    case R.id.failure_radioButton_2:
                        failure = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv9.getText().toString(),failure);

                        break;
                    case R.id.failure_radioButton_3:
                        failure = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv9.getText().toString(),failure);

                        break;
                    case R.id.failure_radioButton_4:
                        failure = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv9.getText().toString(),failure);

                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.fearful_radioButton1:
                        fearful =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv10.getText().toString(),fearful);

                        break;
                    case R.id.fearful_radioButton2:
                        fearful = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv10.getText().toString(),fearful);
                        break;
                    case R.id.fearful_radioButton3:
                        fearful = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv10.getText().toString(),fearful);
                        break;
                    case R.id.fearful_radioButton4:
                        fearful = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv10.getText().toString(),fearful);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.restless_radiobutton1:
                        restless =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv11.getText().toString(),restless);
                        break;
                    case R.id.restless_radiobutton2:
                        restless = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv11.getText().toString(),restless);
                        break;
                    case R.id.restless_radiobutton3:
                        restless = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv11.getText().toString(),restless);
                        break;
                    case R.id.restless_radiobutton4:
                        restless = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv11.getText().toString(),restless);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.happy_radioButton1:
                        happy =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv12.getText().toString(),happy);

                        break;
                    case R.id.happy_radioButton2:
                        happy = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv12.getText().toString(),happy);

                        break;
                    case R.id.happy_radioButton3:
                        happy = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv12.getText().toString(),happy);

                        break;
                    case R.id.happy_radioButton4:
                        happy = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv12.getText().toString(),happy);

                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.usual_radioButton_1:
                        usual =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv13.getText().toString(),usual);

                        break;
                    case R.id.usual_radioButton_2:
                        usual = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv13.getText().toString(),usual);
                        break;
                    case R.id.usual_radioButton_3:
                        usual = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv13.getText().toString(),usual);
                        break;
                    case R.id.usual_radioButton_4:
                        usual = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv13.getText().toString(),usual);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.lonely_radioButton_1:
                        lonely =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv14.getText().toString(),lonely);
                        break;
                    case R.id.lonely_radioButton_2:
                        lonely = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv14.getText().toString(),lonely);
                        break;
                    case R.id.lonely_radioButton_3:
                        lonely = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv14.getText().toString(),lonely);
                        break;
                    case R.id.lonely_radioButton_4:
                        lonely = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv14.getText().toString(),lonely);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.unfriendly_radioButton_1:
                        unfriendly =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv15.getText().toString(),unfriendly);
                        break;
                    case R.id.unfriendly_radioButton_2:
                        hashMap.put(depressionTv15.getText().toString(),unfriendly);
                        unfriendly = "Some or a Little of the Time (1-2 days)";
                        break;
                    case R.id.unfriendly_radioButton_3:
                        hashMap.put(depressionTv15.getText().toString(),unfriendly);
                        unfriendly = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        break;
                    case R.id.unfriendly_radioButton_4:
                        hashMap.put(depressionTv15.getText().toString(),unfriendly);
                        unfriendly = "All of the Time (5-7 days)";
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.life_radioButton1:
                        life =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv16.getText().toString(),life);
                        break;
                    case R.id.life_radioButton2:
                        life = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv16.getText().toString(),life);
                        break;
                    case R.id.life_radioButton3:
                        life = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv16.getText().toString(),life);
                        break;
                    case R.id.life_radioButton4:
                        life = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv16.getText().toString(),life);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.spells_radiobutton1:
                        spells =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv17.getText().toString(),spells);
                        break;
                    case R.id.spells_radiobutton2:
                        spells = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv17.getText().toString(),spells);
                        break;
                    case R.id.spells_radiobutton3:
                        spells = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv17.getText().toString(),spells);
                        break;
                    case R.id.spells_radiobutton4:
                        spells = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv17.getText().toString(),spells);

                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sad_radioButton1:
                        sad =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv18.getText().toString(),sad);
                        break;
                    case R.id.sad_radioButton2:
                        sad = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv18.getText().toString(),sad);
                        break;
                    case R.id.sad_radioButton3:
                        sad = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv18.getText().toString(),sad);
                        break;
                    case R.id.sad_radioButton4:
                        sad = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv18.getText().toString(),sad);
                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.disliked_radiobutton1:
                        disliked =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv19.getText().toString(),disliked);
                        break;
                    case R.id.disliked_radiobutton2:
                        disliked = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv19.getText().toString(),disliked);

                        break;
                    case R.id.disliked_radiobutton3:
                        disliked = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv19.getText().toString(),disliked);

                        break;
                    case R.id.disliked_radiobutton4:
                        disliked = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv19.getText().toString(),disliked);

                        break;
                    default:
                        break;
                }
            }
        });

        radioGroup20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.depression_radioButton1:
                        get_going =  "Rarely or None of the Time (Less than 1 day)";
                        hashMap.put(depressionTv20.getText().toString(),get_going);

                        break;
                    case R.id.depression_radioButton2:
                        get_going = "Some or a Little of the Time (1-2 days)";
                        hashMap.put(depressionTv20.getText().toString(),get_going);

                        break;
                    case R.id.depression_radioButton3:
                        get_going = "Occasionally or a Moderate Amount of the Time (3-4 days)";
                        hashMap.put(depressionTv20.getText().toString(),get_going);

                        break;
                    case R.id.depression_radioButton4:
                        get_going = "All of the Time (5-7 days)";
                        hashMap.put(depressionTv20.getText().toString(),get_going);

                        break;
                    default:
                        break;
                }
            }
        });



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                id = getActivity().getIntent().getStringExtra(Constants.USERID).toString();

                new DatamodelUtils(getActivity());
                getValuesToStoreInDB();
                insertUserQuestionInDB(userQuestionArrayList);
            }
        });
    }

    public void insertUserQuestionInDB(ArrayList<UserQuestion> userQuestionArrayList) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("QUESTIONS").push();

        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("id", SharedPreferencesUtils.LoadSelectedUser(getActivity()).toString());
        userDetails.put("question_Ans",userQuestionArrayList);
        databaseReference.setValue(userDetails);

        new DatamodelUtils(getActivity());
        DatamodelUtils.getAdminUserToChat(getActivity());
//        Intent intent = new Intent(getActivity(), HomeActivity.class);
//        startActivity(intent);
    }

}
