package com.angel.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.angel.R;
import com.angel.Util.Constants;
import com.angel.Util.DatamodelUtils;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.activity.FreeSpiritActivity;
import com.angel.activity.HomeActivity;
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

import static com.angel.Util.DatamodelUtils.getValuesToStoreInDB;
import static com.angel.Util.DatamodelUtils.hashMap;
import static com.angel.Util.DatamodelUtils.userQuestionArrayList;


public class AnxietyFragment extends Fragment {


    TextView anxietyTitleTv1;
    TextView anxietyTitleTv2;
    TextView anxietyTitleTv3;
    TextView anxietyTitleTv4;
    TextView anxietyTitleTv5;
    TextView anxietyTitleTv6;

    public String id;
    RadioGroup anxietyGroup1;
    RadioGroup anxietyGroup2;
    RadioGroup anxietyGroup3;
    RadioGroup anxietyGroup4;
    RadioGroup anxietyGroup5;
    RadioGroup anxietyGroup6;

    String nervous;
    String controlWorrying;
    String differentThings;
    String troubleRelaxing;
    String beingRestless;
    String awfulMightHappen;
    TextView submitBtn;




    RadioButton nervousRadioButton1;
    RadioButton nervousRadioButton2;
    RadioButton nervousRadioButton3;
    RadioButton nervousRadioButton4;
    RadioButton nervousRadioButton5;
    RadioButton nervousRadioButton6;
    RadioButton nervousRadioButton7;
    RadioButton nervousRadioButton8;
    RadioButton nervousRadioButton9;
    RadioButton nervousRadioButton10;
    RadioButton nervousRadioButton11;
    RadioButton nervousRadioButton12;
    RadioButton nervousRadioButton13;
    RadioButton nervousRadioButton14;
    RadioButton nervousRadioButton15;
    RadioButton nervousRadioButton16;
    RadioButton nervousRadioButton17;
    RadioButton nervousRadioButton18;
    RadioButton nervousRadioButton19;
    RadioButton nervousRadioButton20;
    RadioButton nervousRadioButton21;
    RadioButton nervousRadioButton22;
    RadioButton nervousRadioButton23;
    RadioButton nervousRadioButton24;



    FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;
    int randomPickedUser;

    ArrayList<LoggedInUser> adminUserList;
    LoggedInUser loggedInUser;


    public AnxietyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_one, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        submitBtn = (Button) view.findViewById(R.id.fragment_anixety_submit);

        anxietyTitleTv1 = (TextView) view.findViewById(R.id.anxietyTv1);
        anxietyTitleTv2 = (TextView) view.findViewById(R.id.anxietyTv2);
        anxietyTitleTv3 = (TextView) view.findViewById(R.id.anxietyTv3);
        anxietyTitleTv4 = (TextView) view.findViewById(R.id.anxietyTv4);
        anxietyTitleTv5 = (TextView) view.findViewById(R.id.anxietyTv5);
        anxietyTitleTv6 = (TextView) view.findViewById(R.id.anxietyTv6);

        anxietyGroup1 = (RadioGroup) view.findViewById(R.id.anxeity_radioGroup_1);
        anxietyGroup2 = (RadioGroup) view.findViewById(R.id.anxeity_radioGroup_2);
        anxietyGroup3 = (RadioGroup) view.findViewById(R.id.anxeity_radioGroup_3);
        anxietyGroup4 = (RadioGroup) view.findViewById(R.id.anxeity_radioGroup_4);
        anxietyGroup5 = (RadioGroup) view.findViewById(R.id.anxeity_radioGroup_5);
        anxietyGroup6 = (RadioGroup) view.findViewById(R.id.anxeity_radioGroup_6);


        nervousRadioButton1 = (RadioButton) view.findViewById(R.id.nervous_radioButton_1);
        nervousRadioButton2 = (RadioButton) view.findViewById(R.id.nervous_radioButton_2);
        nervousRadioButton3 = (RadioButton) view.findViewById(R.id.nervous_radioButton_3);
        nervousRadioButton4 = (RadioButton) view.findViewById(R.id.nervous_radioButton_4);

        nervousRadioButton5 = (RadioButton) view.findViewById(R.id.control_worrying_radioButton_1);
        nervousRadioButton6 = (RadioButton) view.findViewById(R.id.control_worrying_radioButton_2);
        nervousRadioButton7 = (RadioButton) view.findViewById(R.id.control_worrying_radioButton_3);
        nervousRadioButton8 = (RadioButton) view.findViewById(R.id.control_worrying_radioButton_4);


        nervousRadioButton9 = (RadioButton) view.findViewById(R.id.different_things_radioButton_1);
        nervousRadioButton10 = (RadioButton) view.findViewById(R.id.different_things_radioButton_2);
        nervousRadioButton11 = (RadioButton) view.findViewById(R.id.different_things_radioButton_3);
        nervousRadioButton12 = (RadioButton) view.findViewById(R.id.different_things_radioButton_4);

        nervousRadioButton13 = (RadioButton) view.findViewById(R.id.trouble_relaxing_radioButton1);
        nervousRadioButton14 = (RadioButton) view.findViewById(R.id.trouble_relaxing_radioButton2);
        nervousRadioButton15 = (RadioButton) view.findViewById(R.id.trouble_relaxing_radioButton3);
        nervousRadioButton16 = (RadioButton) view.findViewById(R.id.trouble_relaxing_radioButton4);


        nervousRadioButton17 = (RadioButton) view.findViewById(R.id.being_restless_radiobutton1);
        nervousRadioButton18 = (RadioButton) view.findViewById(R.id.being_restless_radiobutton2);
        nervousRadioButton19 = (RadioButton) view.findViewById(R.id.being_restless_radiobutton3);
        nervousRadioButton20 = (RadioButton) view.findViewById(R.id.being_restless_radiobutton4);


        nervousRadioButton21 = (RadioButton) view.findViewById(R.id.awful_might_happen_radioButton1);
        nervousRadioButton22 = (RadioButton) view.findViewById(R.id.awful_might_happen_radioButton2);
        nervousRadioButton23 = (RadioButton) view.findViewById(R.id.awful_might_happen_radioButton3);
        nervousRadioButton24 = (RadioButton) view.findViewById(R.id.awful_might_happen_radioButton4);


        anxietyGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.nervous_radioButton_1:
                        nervous = "Not At All";
                        hashMap.put(anxietyTitleTv1.getText().toString(), nervous);
                        break;
                    case R.id.nervous_radioButton_2:
                        nervous = "Several Days";
                        hashMap.put(anxietyTitleTv1.getText().toString(), nervous);
                        break;
                    case R.id.nervous_radioButton_3:
                        nervous = "More Than Half the Days";
                        hashMap.put(anxietyTitleTv1.getText().toString(), nervous);
                        break;
                    case R.id.nervous_radioButton_4:
                        nervous = "Nearly Every Day";
                        hashMap.put(anxietyTitleTv1.getText().toString(), nervous);
                        break;
                }
            }
        });

        anxietyGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.control_worrying_radioButton_1:
                        controlWorrying = "Not At All";
                        hashMap.put(anxietyTitleTv2.getText().toString(), controlWorrying);

                        break;
                    case R.id.control_worrying_radioButton_2:
                        controlWorrying = "Several Days";
                        hashMap.put(anxietyTitleTv2.getText().toString(), controlWorrying);
                        break;
                    case R.id.control_worrying_radioButton_3:
                        controlWorrying = "More Than Half the Days";
                        hashMap.put(anxietyTitleTv2.getText().toString(), controlWorrying);
                        break;
                    case R.id.control_worrying_radioButton_4:
                        controlWorrying = "Nearly Every Day";
                        hashMap.put(anxietyTitleTv2.getText().toString(), controlWorrying);
                        break;
                }
            }
        });

        anxietyGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.different_things_radioButton_1:
                        differentThings = "Not At All";
                        hashMap.put(anxietyTitleTv3.getText().toString(), differentThings);

                        break;
                    case R.id.different_things_radioButton_2:
                        differentThings = "Several Days";
                        hashMap.put(anxietyTitleTv3.getText().toString(), differentThings);
                        break;
                    case R.id.different_things_radioButton_3:
                        differentThings = "More Than Half the Days";
                        hashMap.put(anxietyTitleTv3.getText().toString(), differentThings);
                        break;
                    case R.id.different_things_radioButton_4:
                        differentThings = "Nearly Every Day";
                        hashMap.put(anxietyTitleTv3.getText().toString(), differentThings);
                        break;
                }
            }
        });

        anxietyGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.trouble_relaxing_radioButton1:
                        troubleRelaxing = "Not At All";
                        hashMap.put(anxietyTitleTv4.getText().toString(), troubleRelaxing);
                        break;
                    case R.id.trouble_relaxing_radioButton2:
                        troubleRelaxing = "Several Days";
                        hashMap.put(anxietyTitleTv4.getText().toString(), troubleRelaxing);
                        break;
                    case R.id.trouble_relaxing_radioButton3:
                        troubleRelaxing = "More Than Half the Days";
                        hashMap.put(anxietyTitleTv4.getText().toString(), troubleRelaxing);
                        break;
                    case R.id.trouble_relaxing_radioButton4:
                        troubleRelaxing = "Nearly Every Day";
                        hashMap.put(anxietyTitleTv4.getText().toString(), troubleRelaxing);
                        break;
                }
            }
        });

        anxietyGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.being_restless_radiobutton1:
                        beingRestless = "Not At All";
                        hashMap.put(anxietyTitleTv5.getText().toString(), beingRestless);
                        break;
                    case R.id.being_restless_radiobutton2:
                        beingRestless = "Several Days";
                        hashMap.put(anxietyTitleTv5.getText().toString(), beingRestless);
                        break;
                    case R.id.being_restless_radiobutton3:
                        beingRestless = "More Than Half the Days";
                        hashMap.put(anxietyTitleTv5.getText().toString(), beingRestless);
                        break;
                    case R.id.being_restless_radiobutton4:
                        beingRestless = "Nearly Every Day";
                        hashMap.put(anxietyTitleTv5.getText().toString(), beingRestless);
                        break;
                }
            }
        });

        anxietyGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.awful_might_happen_radioButton1:
                        awfulMightHappen = "Not At All";
                        hashMap.put(anxietyTitleTv6.getText().toString(), awfulMightHappen);
                        break;
                    case R.id.awful_might_happen_radioButton2:
                        awfulMightHappen = "Several Days";
                        hashMap.put(anxietyTitleTv6.getText().toString(), awfulMightHappen);
                        break;
                    case R.id.awful_might_happen_radioButton3:
                        awfulMightHappen = "More Than Half the Days";
                        hashMap.put(anxietyTitleTv6.getText().toString(), awfulMightHappen);
                        break;
                    case R.id.awful_might_happen_radioButton4:
                        awfulMightHappen = "Nearly Every Day";
                        hashMap.put(anxietyTitleTv6.getText().toString(), awfulMightHappen);
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


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        adminUserList = new ArrayList<>();
        new DatamodelUtils(getActivity());
        DatamodelUtils.getAdminUserToChat(getActivity());

    }


//    private void getAdminUserToChat(Context activity) {
//        mDatabase = mFirebaseDatabase.getReference().child("LOGIN_USER");
//        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.i("SocialMediaActivity", "called always");
//
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    try {
//                        LoggedInUser message = postSnapshot.getValue(LoggedInUser.class);
//                        adminUserList.add(message);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                Random random = new Random();
//                randomPickedUser = random.nextInt(adminUserList.size());
//
//                Log.i("SocialMediaActivity", "called randomPickedUser "+randomPickedUser);
//                loggedInUser = adminUserList.get(randomPickedUser);
//
//                Intent intent = new Intent(getActivity(), HomeActivity.class);
//                intent.putExtra("loggerUser",loggedInUser);
//                startActivity(intent);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.i("SocialMediaActivity", "databaseError"+databaseError);
//            }
//        });
//    }



}
