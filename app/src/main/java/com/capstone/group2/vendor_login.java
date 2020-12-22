package com.capstone.group2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class vendor_login extends AppCompatActivity {

    TextInputEditText email;
    TextInputEditText password;
    Button login;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_login);
        email=findViewById(R.id.v_loginemail);
        password=findViewById(R.id.v_loginpassword);
        login=findViewById(R.id.v_loginbutton);
        fAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString().trim();
                String pw=password.getText().toString().trim();

                if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pw)){
                    Toast.makeText(vendor_login.this, "Make sure all of the information are entered", Toast.LENGTH_SHORT).show();
                }
                else if (mail.equals("intibitesbusiness@gmail.com") && pw.equals("acc0unt_inti")){
                    Toast.makeText(vendor_login.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(vendor_login.this, vendor_home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(vendor_login.this, "Invalid email address or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
