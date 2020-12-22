package com.capstone.group2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class loginsignup_selection extends AppCompatActivity {

    Button login;
    Button vendorlogin;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup_selection);
        login=findViewById(R.id.login1);
        vendorlogin=findViewById(R.id.vendorlogin1);
        signup=findViewById(R.id.signup1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginsignup_selection.this, user_login.class);
                loginsignup_selection.this.startActivity(intent);
            }
        });

        vendorlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginsignup_selection.this, vendor_login.class);
                loginsignup_selection.this.startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginsignup_selection.this, activity_signup.class);
                loginsignup_selection.this.startActivity(intent);
            }
        });
    }
}
