package com.example.isss;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    //private Button button;
//
//    private EditText editTextEmail;
//    private EditText editTextPassword;
//    private AppCompatButton buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        //Initializing views
////
//        editTextEmail = (EditText) findViewById(R.id.txt_username);
//        editTextPassword = (EditText) findViewById(R.id.txt_password);
//        buttonLogin = (AppCompatButton) findViewById(R.id.btn_login);
//
//        //Adding click listener
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login();
//            }
//        });
//    }
//    private void login() {
//        //Getting values from edit texts
//        final String email = editTextEmail.getText().toString().trim();
//        final String password = editTextPassword.getText().toString().trim();
//
////        showDialog();
//        //Creating a string request
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, LoginApi.LOGIN_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        //If we are getting success from server
//                        if (response.contains(LoginApi.LOGIN_SUCCESS)) {
////                            hideDialog();
//                            gotoCourseActivity();
//
//                        } else {
////                            hideDialog();
//                            //Displaying an error message on toast
//                            Toast.makeText(getApplicationContext(), "Username & Password Salah", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //You can handle error here if you want
////                        hideDialog();
//                        Toast.makeText(getApplicationContext(), "The server unreachable", Toast.LENGTH_LONG).show();
//
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                //Adding parameters to request
//                params.put(LoginApi.KEY_EMAIL, email);
//                params.put(LoginApi.KEY_PASSWORD, password);
//
//                //returning parameter
//                return params;
//            }
//        };
//
//        //Adding the string request to the queue
//        Volley.newRequestQueue(this).add(stringRequest);
//
//    }
//
//    private void gotoCourseActivity() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }

//    private void showDialog() {
//        if (!pDialog.isShowing())
//            pDialog.show();
//    }
//
//    private void hideDialog() {
//        if (pDialog.isShowing())
//            pDialog.dismiss();
//    }

        Button btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                this.finish();
            }

            private void finish() {
            }
        });

        Button btnadmin = (Button) findViewById(R.id.btn_login_admin);
        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this, MainActivity_Admin.class);
                startActivity(i);
                onBackPressed();
            }


        });


    }
    //@Override
//public void onBackPressed() {
//    // Do Here what ever you want do on back press;
//
//}
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }
}
