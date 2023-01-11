package com.example.clothesinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class signUp extends AppCompatActivity implements View.OnClickListener{

    ArrayList<User> user = new ArrayList<>();
    private EditText Username2;
    private EditText Password2;
    private Button Login;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username2 = (EditText) findViewById(R.id.username);
        Password2 = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.loginButton);
        SignUp = (Button) findViewById(R.id.signUpButton);
    }



    private void Save (String Username, String Password){
        user.add(new User(Username, Password));
    }

    public void register(View v){
        String inputUsername = Username2.getText().toString();
        String inputPassword = Password2.getText().toString();
        Save(inputUsername, inputPassword);

        Intent intent = new Intent(signUp.this, login.class);
        intent.putParcelableArrayListExtra("myData", user);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.loginButton){
            Intent intent = new Intent(signUp.this, login.class);
            startActivity(intent);
        }
    }
}