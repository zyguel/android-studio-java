package com.example.cabogoy_zyguel_11300246;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView displayLoginTitle;
    EditText userID;
    EditText password;
    Button loginButton;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Step 4 Casting
        displayLoginTitle = (TextView) findViewById(R.id.logintitle);
        userID = (EditText) findViewById(R.id.inputUser);
        password =(EditText) findViewById(R.id.inputPassword);


        loginButton = (Button) findViewById(R.id.loginbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "zyguelcabogoy";
                String pass ="admin";
                if(userID.getText().toString().equals(user) && password.getText().toString().equals(pass)) {

                    Intent mainLogin = new Intent(MainActivity.this, HomeActivity.class);
                    mainLogin.putExtra("username", user);
                    startActivity(mainLogin);
                    Toast.makeText(MainActivity.this,"Successfully Login",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"User Credentials Invalid!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}