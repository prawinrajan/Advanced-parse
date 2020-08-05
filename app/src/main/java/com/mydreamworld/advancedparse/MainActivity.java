package com.mydreamworld.advancedparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("toDFX5qv0RIm5PVHJwuVsc9hN3qcLTNT6PShGqMD")
                // if defined
                .clientKey("kGD9JUjuU4r2ybRWfeJSaCfeUWmpcM9WPa6dE3RY")
                .server("https://parseapi.back4app.com/")
                .build()
        );

       /*
        // retrive a parse object from parse server

        ParseQuery<ParseObject> query=ParseQuery.getQuery("GameScore");

        query.getInBackground("K309XCjdqV", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
           if(e==null && object!=null){
               Log.i("objectvalue",object.getString("playerName"));
               Log.i("objectvalue",Integer.toString(object.getInt("score")));
           }
            }
        });

       ParseQuery<ParseObject> objectParseQuery=ParseQuery.getQuery("GameScore");

       objectParseQuery.whereEqualTo("username","prawin");

       objectParseQuery.setLimit(2);

       objectParseQuery.findInBackground(new FindCallback<ParseObject>() {
           @Override
           public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    Log.i("findinbackground","Retrived"+objects.size()+"objects");

                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            Log.i("Result",Integer.toString(object.getInt("score")));
                        }
                    }
                }
           }
       });
*/
  /*     //parse user creation like a signup
        ParseUser user=new ParseUser();

        user.setUsername("PrawinN");
        user.setPassword("pass");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
           if(e==null){
               Log.i("signup","suceesfull");
           }else{
               Log.i("signup","failed");
           }
            }
        });
*/
/*
        ParseUser.logInInBackground("PrawinN", "abcds", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user!=null){
                    Log.i("login","suceessfull");
                }else{
                    Log.i("login","failed");
                }
            }
        });
*/
        //retrive current userlist
        ParseUser.logOut();

        if(ParseUser.getCurrentUser()!=null){
            Log.i("loginform","user logged"+ParseUser.getCurrentUser().getUsername());
        }else{
            Log.i("loginform","user not loggedin");
        }

       // ParseUser.enableAutomaticUser();
        ParseACL defaultACL= new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL,true);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}
