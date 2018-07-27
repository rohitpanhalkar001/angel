package com.angel.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.angel.activity.RegistrationActivity;
import com.angel.model.UserQuestion;

import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by user on 15/05/2017.
 */

public class SharedPreferencesUtils {

    //session
    public static void saveSelectedSession(ArrayList<UserQuestion> s, Context context){
        Gson gson = new Gson();
        String selectedSessionString = gson.toJson(s);
        // save to SP
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.usersQuestionsSharedPreferences, MODE_PRIVATE).edit();
        editor.putString(Constants.usersQuestionsSharedPreferencesKey, selectedSessionString);
        editor.commit();

    }


    public static String LoadUserQusetionToSaveInDB(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.usersQuestionsSharedPreferences, MODE_PRIVATE);
        // get the current connection
        String data = prefs.getString(Constants.usersQuestionsSharedPreferencesKey, "");

        return data;
    }

    public static void saveLoggedInUser(String from, Context context){

        // save to SP
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.USER_LOGGED_SHAREDPREFERENCES, MODE_PRIVATE).edit();
        editor.putString(Constants.IS_FROM, from);
        editor.commit();
    }


    public static String LoadFromWhichUser(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.USER_LOGGED_SHAREDPREFERENCES, MODE_PRIVATE);
        // get the current connection
        String data = prefs.getString(Constants.IS_FROM, "");

        return data;
    }

    public static void saveSelectedUser(String from, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.SELECTED_USER, MODE_PRIVATE).edit();
        editor.putString(Constants.WHICH_USER, from);
        editor.commit();
    }

    public static String LoadSelectedUser(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.SELECTED_USER, MODE_PRIVATE);
        // get the current connection
        String data = prefs.getString(Constants.WHICH_USER, "");

        return data;
    }


    public static void loggedInUser(String firebaseUserId, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.USER_LOGGED_SHAREDPREFERENCES, MODE_PRIVATE).edit();
        editor.putString(Constants.LOGGED_IN_USER, firebaseUserId);
        editor.commit();
    }

    public static String loadLoggedInUser(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.USER_LOGGED_SHAREDPREFERENCES, MODE_PRIVATE);
        // get the current connection
        String data = prefs.getString(Constants.LOGGED_IN_USER, "");

        return data;
    }

    public static void saveUserName(String username, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.LOGGED_IN_USER_SHAREDPREFERENCES, MODE_PRIVATE).edit();
        editor.putString(Constants.LOGGEDIN_USER_NAME, username);
        editor.commit();
    }

    public static String loadUserName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.LOGGED_IN_USER_SHAREDPREFERENCES, MODE_PRIVATE);
        // get the current connection
        String data = prefs.getString(Constants.LOGGEDIN_USER_NAME, "");

        return data;
    }
}
