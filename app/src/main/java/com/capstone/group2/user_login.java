package com.capstone.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class user_login extends AppCompatActivity {

    TextInputEditText email;
    TextInputEditText password;
    TextView forgetpassword;
    Button login;
    TextView signuphere;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        email=findViewById(R.id.u_loginemail);
        password=findViewById(R.id.u_loginpassword);
        forgetpassword=findViewById(R.id.u_forgotpassword);
        login=findViewById(R.id.u_loginbutton);
        signuphere=findViewById(R.id.u_signuphere);
        fAuth=FirebaseAuth.getInstance();

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final EditText resetemail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter your email address to receive reset link");
                passwordResetDialog.setView(resetemail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //extract the email address and send reset link
                        String mail=resetemail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(user_login.this, "Reset link sent to your email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(user_login.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //close the dialog
                    }
                });
                passwordResetDialog.create().show();
            }
        });

        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_login.this, activity_signup.class);
                user_login.this.startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString().trim();
                final String pw=password.getText().toString().trim();

                if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pw)){
                    Toast.makeText(user_login.this, "Make sure all of the information are entered", Toast.LENGTH_SHORT).show();
                }
                else if (mail=="inticafeteria@gmail.com"){
                    Toast.makeText(user_login.this, "This is not a school email address", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Authenticate the user
                    fAuth.signInWithEmailAndPassword(mail, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(user_login.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(user_login.this, user_home.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(user_login.this, "Invalid email address or password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }


}
