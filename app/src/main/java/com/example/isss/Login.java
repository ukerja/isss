package com.example.isss;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText username,passowrd;
    private Button login;
    private Switch active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editTextUsername);
        passowrd = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.btn_login);
        active = findViewById(R.id.active);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReferance = FirebaseDatabase.getInstance().getReference();
                databaseReferance.child("login").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String input1 = username.getText().toString();
                        String input2 = passowrd.getText().toString();

                        if(dataSnapshot.child(input1).exists()) {
                            if (dataSnapshot.child(input1).child("password").getValue(String.class).equals(input2)) {
                                if (active.isChecked()) {
                                    if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("admin")) {
                                        preferences.setDataLogin(Login.this, true);
                                        preferences.setDataAs(Login.this, "admin");
                                        startActivity(new Intent(Login.this,MainActivity_Admin.class));
                                    } else if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("user")) {
                                        preferences.setDataLogin(Login.this, true);
                                        preferences.setDataAs(Login.this, "user");
                                        startActivity(new Intent(Login.this,MainActivity.class));
                                    }
                                } else {
                                    if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("admin")){
                                        preferences.setDataLogin(Login.this, false);
                                        startActivity(new Intent(Login.this,MainActivity_Admin.class));
                                    }else if (dataSnapshot.child(input1).child("as").getValue(String.class).equals("user")){
                                        preferences.setDataLogin(Login.this, false);
                                        startActivity(new Intent(Login.this,MainActivity.class));
                                    }

                                }
                            } else {
                                Toast.makeText(Login.this, "Kata Sandi Salah", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Login.this, "Data Belum Terdaftar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        if (preferences.getDataLogin(this)){
            if(preferences.getDataAs(this).equals("admin")){
                startActivity(new Intent(Login.this,MainActivity.class));
                finish();
            } else if (preferences.getDataAs(this).equals("user")){
                startActivity(new Intent(Login.this,MainActivity_Admin.class));
                finish();
            }
        }
    }

}
