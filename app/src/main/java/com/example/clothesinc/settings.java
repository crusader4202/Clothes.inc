package com.example.clothesinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class settings extends AppCompatActivity implements View.OnClickListener{

    ArrayList<User> user;
    private TextView oldUsername;
    private EditText newUsername;
    private TextView oldPassword;
    private EditText newPassword;
    private EditText confirmPassword;
    private Button changeUsername;
    private Button changePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        oldUsername = (TextView) findViewById(R.id.oldUsername);
        newUsername = (EditText) findViewById(R.id.newUsername);
        oldPassword = (TextView) findViewById(R.id.oldPassword);
        newPassword = (EditText) findViewById(R.id.newPassword);
//        confirmPassword = (EditText) findViewById(R.id.confirmNewPassword);
        changeUsername = (Button) findViewById(R.id.changeUsernameBtn);
        changePassword = (Button) findViewById(R.id.changePasswordBtn);

        Intent intent = getIntent();
        user = intent.getParcelableArrayListExtra("myData");

        for(int idx = 0; idx < user.size(); idx++){
            String currentUsername = user.get(idx).getUsername();
            String currentPassword = user.get(idx).getPassword();

            oldUsername.setText(currentUsername);
            oldPassword.setText(currentPassword);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.changeUsernameBtn || v.getId() == R.id.changePasswordBtn){
            changeData();
        }
    }

    private void Save (String Username, String Password){
        user.add(new User(Username, Password));
    }

    public void changeData(){
        String newUsernameInput = newUsername.getText().toString();
        String newPasswordInput = newPassword.getText().toString();

        if(newUsernameInput.isEmpty() || newPasswordInput.isEmpty()) {
            Toast.makeText(settings.this, "Please fill the empty form",
                    Toast.LENGTH_SHORT).show();
        } else{
            user.clear();
            Save(newUsernameInput, newPasswordInput);
            Intent intent = new Intent(settings.this, login.class);
            intent.putParcelableArrayListExtra("myData", user);
            startActivity(intent);
        }
    }
}