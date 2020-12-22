package com.capstone.group2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class user_home extends AppCompatActivity {

    Button btnMenu;
    Button btnSignOut;
    Button btnTransHist;
    Button btnSettings;
    ImageButton btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        btnMenu = findViewById(R.id.buttonMenu);
        btnSignOut = findViewById(R.id.buttonSignOut);
        btnTransHist = findViewById(R.id.btnTransactionHistory);
        btnSettings = findViewById(R.id.buttonSettings);
        btnCart = (ImageButton) findViewById(R.id.imageButton);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_home.this, Menu_List.class);
                startActivity(intent);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(user_home.this, Cart.class);
                startActivity(intent2);
            }
        });

        btnTransHist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(user_home.this, OrderStatus.class);
                startActivity(intent3);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(user_home.this, Settings.class);
                startActivity(intent4);
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(user_home.this, user_login.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent5);
            }
        });
    }
}