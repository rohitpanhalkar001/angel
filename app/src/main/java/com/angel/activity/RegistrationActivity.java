package com.angel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.angel.R;
import com.angel.Util.SharedPreferencesUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    Button signUpBtn;
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    boolean validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signUpBtn = (Button) findViewById(R.id.activity_sign_in_btn_email_sign_up);

        firstName = (EditText) findViewById(R.id.activity_sign_in_edit_first_name);
        lastName = (EditText) findViewById(R.id.activity_sign_in_edit_last_name);
        email = (EditText) findViewById(R.id.activity_sign_in_edit_email);
        confirmPassword = (EditText) findViewById(R.id.activity_sign_in_edit_confirm_password);
        password = (EditText) findViewById(R.id.activity_sign_in_edit_new_password);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateUser()) {

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                            .child("FREE_USER").push();

                    String firebaseUserId = databaseReference.getKey();
                    Map<String, Object> userDetails = new HashMap<>();
                    userDetails.put("id", firebaseUserId);
                    userDetails.put("firstname", firstName.getText().toString());
                    userDetails.put("lastname", lastName.getText().toString());
                    userDetails.put("email", email.getText().toString());
                    userDetails.put("password", password.getText().toString());
                    userDetails.put("confirmPassword", confirmPassword.getText().toString());
                    userDetails.put("created_Date", new Date().getDate());

                    databaseReference.setValue(userDetails);

                    SharedPreferencesUtils.saveSelectedUser("FreeSpirit", RegistrationActivity.this);
                    SharedPreferencesUtils.loggedInUser(firebaseUserId, RegistrationActivity.this);

                    SharedPreferencesUtils.saveUserName(firstName.getText().toString() + " " + lastName.getText().toString(), RegistrationActivity.this);


                    Intent intent = new Intent(RegistrationActivity.this, FreeSpiritActivity.class);
//                intent.putExtra(Constants.USERID,firebaseUserId);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegistrationActivity.this, "Please Enter your Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateUser() {

        if (!email.getText().toString().matches(emailPattern) && email.getText().toString().length() <= 0) {
            validate = false;
        } else if (password.getText().toString().isEmpty()) {
            validate = false;
//            Toast.makeText(RegistrationActivity.this,"Enter your Password",Toast.LENGTH_SHORT).show();
        } else if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
            validate = false;
//            Toast.makeText(RegistrationActivity.this,"Enter valid Password",Toast.LENGTH_SHORT).show();
        } else if (lastName.getText().toString().isEmpty()) {
            validate = false;
        } else if (firstName.getText().toString().isEmpty()) {
            validate = false;
        } else {
            validate = true;
        }


        return validate;
    }
}
