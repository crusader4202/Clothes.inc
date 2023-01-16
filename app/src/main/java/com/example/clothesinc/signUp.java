package com.example.clothesinc;
import com.example.clothesinc.User;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        Username2 = (EditText) findViewById(R.id.registerUsername);
        Password2 = (EditText) findViewById(R.id.registerPassword);
        Login = (Button) findViewById(R.id.loginButton);
        SignUp = (Button) findViewById(R.id.signUpButton);

        SignUp.setOnClickListener(this);
        Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signUpButton){
            register();
        }

        if (v.getId() == R.id.loginButton){
            Intent intent = new Intent(signUp.this, login.class);
            startActivity(intent);
        }
    }

    private void Save (String Username, String Password){
        user.add(new User(Username, Password));
    }

    public void register(){
        String inputUsername = Username2.getText().toString();
        String inputPassword = Password2.getText().toString();

        if(inputUsername.isEmpty() || inputPassword.isEmpty()){
            Toast.makeText(signUp.this, "Please Enter your username & password",
                    Toast.LENGTH_SHORT).show();
        } else if(inputUsername.length() < 8 || inputPassword.length() < 1 || inputPassword.length() > 8){
            Toast.makeText(signUp.this, "Your Input doesn't met the requirements",
                    Toast.LENGTH_SHORT).show();
        } else{
            Save(inputUsername, inputPassword);
            Intent intent = new Intent(signUp.this, login.class);
            intent.putExtra("myData", user);
            startActivity(intent);

        }
    }
}