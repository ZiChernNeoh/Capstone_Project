package com.capstone.group2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.capstone.group2.ViewHolder.VorderViewHolder;

public class vendor_home extends AppCompatActivity {

    Button btnOrders;
    Button btnMenuEdit;
    Button btnOrderHistory;
    ImageButton btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_home);
        btnOrders = findViewById(R.id.button);
        btnMenuEdit = findViewById(R.id.button3);
        btnOrderHistory = findViewById(R.id.button4);
        btnSignOut = (ImageButton) findViewById(R.id.imageButton3);

        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vendor_home.this, vendor_orderStatus.class);
                startActivity(intent);
            }
        });

        btnMenuEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(vendor_home.this, vendor_menu.class);
                startActivity(intent2);
            }
        });

        btnOrderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(vendor_home.this, OrderStatus.class);
                startActivity(intent3);
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(vendor_home.this, vendor_login.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent5);
            }
        });
    }
}