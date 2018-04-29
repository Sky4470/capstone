package com.sky.capstone.capstone;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton ib1,ib2,ib3,ib4;

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ib3=(ImageButton) findViewById(R.id.ib3);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i= new Intent(ProfileActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });
        ib2=(ImageButton) findViewById(R.id.ib2);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i= new Intent(ProfileActivity.this,Main6Activity.class);
                startActivity(i);
            }
        });
        ib1=(ImageButton) findViewById(R.id.ib1);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i= new Intent(ProfileActivity.this,Main7Activity.class);
                startActivity(i);
            }
        });
        ib4=(ImageButton) findViewById(R.id.ib4);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i= new Intent(ProfileActivity.this,Main8Activity.class);
                startActivity(i);
            }
        });




        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views

        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name


        //adding listener to button
        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}