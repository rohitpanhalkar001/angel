package com.angel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.angel.R;

public class UserSelectionActivity extends AppCompatActivity implements View.OnClickListener{

    Button adminBtn;
    Button freeSpiritBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);

        freeSpiritBtn = (Button)findViewById(R.id.activity_user_selection_free_sprit);
        adminBtn = (Button)findViewById(R.id.activity_user_selection_admin);
        adminBtn.setOnClickListener(this);
        freeSpiritBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_user_selection_admin:
                startActivity(new Intent(UserSelectionActivity.this,SocialMediaLoginActivity.class));
                break;

            case R.id.activity_user_selection_free_sprit:
                startActivity(new Intent(UserSelectionActivity.this,RegistrationActivity.class));
                break;

                default:
                    break;
        }
    }
}
