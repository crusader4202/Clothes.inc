package com.example.clothesinc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private Button changeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        oldUsername = (TextView) findViewById(R.id.oldUsername);
        newUsername = (EditText) findViewById(R.id.newUsername);
        oldPassword = (TextView) findViewById(R.id.oldPassword);
        newPassword = (EditText) findViewById(R.id.newPassword);
        confirmPassword = (EditText) findViewById(R.id.confirmNewPassword);
        changeData = (Button) findViewById(R.id.changeDataBtn);

        user = (ArrayList<User>) getIntent().getSerializableExtra("myData");

        if(user != null && !user.isEmpty()){
            User oldName = user.get(0);
            String currUsername = oldName.getUsername();
            oldUsername.setText(currUsername);

            User oldPass = user.get(0);
            String currPassword = oldPass.getPassword();
            oldPassword.setText(currPassword);
        }

        changeData.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                Intent cartActivity = new Intent(settings.this, Cart.class);
                startActivity(cartActivity);
                break;
            case R.id.home:
                Intent mainActivity = new Intent(settings.this, MainActivity.class);
                startActivity(mainActivity);
                return true;
            case R.id.transaction:
                return true;
            case R.id.shop:
                Intent shopActivity = new Intent(settings.this, ShopActivity.class);
                startActivity(shopActivity);
                break;
            case R.id.settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.changeDataBtn){
            changeData();
        }
    }

    public void changeData(){
        String newUsernameInput = newUsername.getText().toString();
        String newPasswordInput = newPassword.getText().toString();
        String confirmPasswordInput = confirmPassword.getText().toString();

        if(newUsernameInput.isEmpty() || newPasswordInput.isEmpty()) {
            Toast.makeText(settings.this, "Please fill the empty form",
                    Toast.LENGTH_SHORT).show();
        } else if(!newPasswordInput.equals(confirmPasswordInput)){
            Toast.makeText(settings.this, "Your Password does not match",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            user.get(0).setUsername(newUsernameInput);
            user.get(0).setPassword(newPasswordInput);
            Intent intent = new Intent(settings.this, login.class);
            intent.putExtra("myData", user);
            startActivity(intent);
        }
    }
}