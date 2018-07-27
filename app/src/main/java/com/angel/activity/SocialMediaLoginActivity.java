package com.angel.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.angel.R;
import com.angel.Util.Constants;
import com.angel.Util.SharedPreferencesUtils;
import com.angel.model.LoggedInUser;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialMediaLoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    ImageView imageView;
    TextView googleSignInBtn;
    JSONObject jsonObject;
    GoogleSignInOptions googleSignInOptions;

    FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;
    private GoogleApiClient mGoogleApiClient;

    protected static final int RC_SIGN_IN = 200;

    boolean verifedUser;
    boolean isFound = false;
    String firebaseUserId = "";
    DataSnapshot storeSpanShot;
    LoggedInUser savedLoggedInUser;
    ArrayList<LoggedInUser> loggedInUserArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        imageView = (ImageView) findViewById(R.id.linkedin_loginbtn_img);

        googleSignInBtn = (TextView) findViewById(R.id.activity_login_google_sign_in_btn);

        imageView.setOnClickListener(this);
        googleSignInBtn.setOnClickListener(this);
        loggedInUserArrayList = new ArrayList<>();
        initGoogleClient();

        generateKeyHash();


    }

    private void initGoogleClient() {
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }

    private void generateKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.angel",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    private void handleLogin() {
        LISessionManager.getInstance(getApplicationContext()).init(SocialMediaLoginActivity.this, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
                fetchPermissions();
            }

            @Override
            public void onAuthError(LIAuthError error) {
                // Handle authentication errors
                Log.i("onAuthError","Error");
            }
        }, true);
    }

    private void fetchPermissions() {
        String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,public-profile-url,picture-url,email-address,picture-urls::(original))";

        APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.getRequest(this, url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                // Success!
                try {

                    jsonObject =apiResponse.getResponseDataAsJson();
                    LoggedInUser loggedInUser = new LoggedInUser();
                    loggedInUser.setEmail(jsonObject.getString("emailAddress"));
                    loggedInUser.setLast_name(jsonObject.getString("lastName"));
                    loggedInUser.setFirst_name(jsonObject.getString("firstName"));
                    loggedInUser.setUsername(jsonObject.getString("firstName")+" "+jsonObject.getString("lastName"));
                    loggedInUser.setUserID(jsonObject.getString("id"));
                    loggedInUser.setProfilePic(jsonObject.getString("pictureUrl"));
                    Log.i("SocialMediaActivity", "fetchPermissions called always");
                    getVerifiedUser(loggedInUser);
                } catch (Exception e) {
                    Log.i("SocialMediaActivity", e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onApiError(LIApiError liApiError) {
                // Error making GET request!
            }
        });
    }

    private void getVerifiedUser(final LoggedInUser apiResponse) {

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseDatabase.getReference().child("LOGIN_USER");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("SocialMediaActivity", "called always");
                if (dataSnapshot.getValue() == null){
                    insertUserDataInDB(apiResponse);

                }else {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        try {
                            storeSpanShot = postSnapshot;
                            LoggedInUser message = postSnapshot.getValue(LoggedInUser.class);
                            loggedInUserArrayList.add(message);
                            Log.i("SocialMediaActivity", "json value "+loggedInUserArrayList.size());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    Collections.reverse(loggedInUserArrayList);

                    for (int i = 0;i<loggedInUserArrayList.size(); i++){
                        if(loggedInUserArrayList.get(i).getEmail().equals(apiResponse.getEmail().toString())){
                            savedLoggedInUser = loggedInUserArrayList.get(i);
                            isFound = true;
                        }
                    }


                    if (!isFound){
                        insertUserDataInDB(apiResponse);
                    }else {
//                        SharedPreferencesUtils.loggedInUser(savedLoggedInUser.getId(),SocialMediaLoginActivity.this);
                        Intent intent = new Intent(SocialMediaLoginActivity.this, HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra(Constants.LINKEDIN_USER_DATA, loggedInUserArrayList);
                        startActivity(intent);
                    }
                    }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("SocialMediaActivity", "databaseError"+databaseError);
            }
        });

    }



    private void insertUserDataInDB(LoggedInUser apiResponse) {
        try {
            Log.i("SocialMediaActivity", "Inserting Values");
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                    .child("LOGIN_USER").push();

            firebaseUserId = databaseReference.getKey();
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("id", firebaseUserId);
            userDetails.put("userId", apiResponse.getUserID());
            userDetails.put("username", apiResponse.getFirst_name()+" "+apiResponse.getLast_name());
            userDetails.put("email", apiResponse.getEmail());
            userDetails.put("firstname", apiResponse.getFirst_name());
            userDetails.put("lastName", apiResponse.getLast_name());
            userDetails.put("profilePic", apiResponse.getProfilePic());
            userDetails.put("created_Date", new Date().getDate());

            databaseReference.setValue(userDetails);


            LoggedInUser loggedInUser = new LoggedInUser();
            loggedInUser.setId(firebaseUserId);
            loggedInUser.setUserID(apiResponse.getUserID());
            loggedInUser.setUsername(apiResponse.getFirst_name()+" "+apiResponse.getLast_name());
            loggedInUser.setFirst_name(apiResponse.getFirst_name());
            loggedInUser.setLast_name(apiResponse.getLast_name());
            loggedInUser.setEmail(apiResponse.getEmail());
            loggedInUser.setProfilePic(apiResponse.getProfilePic());

            SharedPreferencesUtils.saveSelectedUser("Angel",SocialMediaLoginActivity.this);

            SharedPreferencesUtils.loggedInUser(firebaseUserId,SocialMediaLoginActivity.this);

            Intent intent = new Intent(SocialMediaLoginActivity.this,HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra(Constants.LINKEDIN_USER_DATA, loggedInUser);
            startActivity(intent);
            finish();





        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE, Scope.R_EMAILADDRESS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Add this line to your existing onActivityResult() method

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }else  {
            LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
        }

    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            Log.e("result","Exception"+acct.getEmail());


            String fullName = acct.getDisplayName();
            String userName[] = fullName.split(" ");
            String first_name = userName[0];
            String last_name = userName[1];
            LoggedInUser loggedInUser = new LoggedInUser();
            loggedInUser.setEmail(acct.getEmail());
            loggedInUser.setLast_name(last_name);
            loggedInUser.setFirst_name(first_name);
            loggedInUser.setUsername(acct.getDisplayName());
            loggedInUser.setUserID(acct.getId());
            if (acct.getPhotoUrl() == null){

            }else {
                loggedInUser.setProfilePic(acct.getPhotoUrl().toString());
            }
            Log.i("SocialMediaActivity", "handleSignInResult called always");
            getVerifiedUser(loggedInUser);

        } else {
            Log.i("Error", "handleSignInResult"+result.isSuccess());

        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferencesUtils.saveSelectedUser("Angel",SocialMediaLoginActivity.this);

        switch (v.getId()){
            case R.id.activity_login_google_sign_in_btn:

                handleGoogleLogin();
                break;
            case R.id.linkedin_loginbtn_img:

                handleLogin();
                break;
            default:
                break;
        }
    }

    private void handleGoogleLogin() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
