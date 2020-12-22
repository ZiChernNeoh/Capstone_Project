package com.capstone.group2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.capstone.group2.Model.Member;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_signup extends AppCompatActivity {

    TextInputEditText fullname;
    TextInputEditText email;
    TextInputEditText password;
    TextInputEditText dob;
    FirebaseAuth firebaseAuth;
    CheckBox checkBox;
    Button signup;
    TextView loginhere;
    FirebaseDatabase database;
    DatabaseReference ref;
    Member member;
    int maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullname=findViewById(R.id.signupfullname);
        email=findViewById(R.id.signupemail);
        password=findViewById(R.id.signuppassword);
        dob=findViewById(R.id.signupdob);
        checkBox=findViewById(R.id.checkBox);
        signup=findViewById(R.id.signup2);
        loginhere=findViewById(R.id.u_loginhere);
        firebaseAuth=FirebaseAuth.getInstance();
        member=new Member();
        ref=database.getInstance().getReference().child("User");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid=(int)snapshot.getChildrenCount();
                }
                else {
                    //do the code as you want
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_signup.this, term_of_service.class);
                activity_signup.this.startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=fullname.getText().toString().trim();
                String mail=email.getText().toString().trim();
                String pw=password.getText().toString().trim();
                String bd=dob.getText().toString().trim();
                boolean tos=checkBox.isChecked();

                member.setFullname(name);
                member.setEmail(mail);
                member.setDob(bd);
                member.setTermofservice(tos);

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pw) || TextUtils.isEmpty(bd)){
                    Toast.makeText(activity_signup.this, "Make sure all of the information are entered", Toast.LENGTH_SHORT).show();
                }
                else if (checkBox.isChecked()==false){
                    Toast.makeText(activity_signup.this, "Please tick the checkbox", Toast.LENGTH_SHORT).show();
                }
                else if (!mail.contains("newinti.edu.my")){
                    Toast.makeText(activity_signup.this, "This email address is not a school account.", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Register the user in Firebase
                    firebaseAuth.createUserWithEmailAndPassword(mail, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            FirebaseUser fuser=firebaseAuth.getCurrentUser();
                            fuser.reload();
                            if (task.isSuccessful()){
                                Toast.makeText(activity_signup.this, "Sign up successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(activity_signup.this, user_home.class);
                                startActivity(intent);
                                ref.child(String.valueOf(maxid+1)).setValue(member);
                            }
                            else {
                                Toast.makeText(activity_signup.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_signup.this, user_login.class);
                activity_signup.this.startActivity(intent);
            }
        });
    }
}
