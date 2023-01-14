package com.example.clothesinc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class login extends AppCompatActivity implements View.OnClickListener {

    ArrayList<User> user;
    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText) findViewById(R.id.loginUsername);
        Password = (EditText) findViewById(R.id.loginPassword);
        Login = (Button) findViewById(R.id.signInButton);
        Register = (Button) findViewById(R.id.registerButton);

        Intent intent = getIntent();
        user = intent.getParcelableArrayListExtra("myData");

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signInButton){
            validate(Username.getText().toString(), Password.getText().toString());
        }

        if(v.getId() == R.id.registerButton){
            Intent intent = new Intent(login.this, signUp.class);
            startActivity(intent);
        }
    }

    private void validate(String valUsername, String valPassword){
        for(int idx = 0; idx < user.size(); idx++){
            String UserPassword = user.get(idx).getPassword();
            String UserName = user.get(idx).getUsername();
            if(valUsername.isEmpty() || valPassword.isEmpty()){
                Toast.makeText(login.this, "Please Enter your username & password",
                        Toast.LENGTH_SHORT).show();
            } else if(valUsername.equals(UserName) && valPassword.equals(UserPassword)){
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}