package com.example.cabogoy_zyguel_11300246;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    Button logoutBtn;
    TextView txtMessage;
    TextView appTitle;
    TextView currentNum;
    Button minusBtn;
    Button addBtn;
    int currnum = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        logoutBtn =(Button)findViewById(R.id.backbtn);
        txtMessage = findViewById(R.id.txtmessage);
        txtMessage.setText(getIntent().getStringExtra("username"));
        appTitle = (TextView)findViewById(R.id.apptitle);
        currentNum = (TextView)findViewById(R.id.currentnum);
        minusBtn = (Button)findViewById(R.id.reducebtn);
        addBtn = (Button)findViewById(R.id.addbtn);

        currentNum.setText(String.valueOf(currnum));

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currnum > 0){
                    currnum--;
                    currentNum.setText(String.valueOf(currnum));
                }else{
                    Toast.makeText(HomeActivity.this,"Negative Values Prohibited!",Toast.LENGTH_LONG).show();
                }
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currnum++;
                currentNum.setText(String.valueOf(currnum));
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "zyguelcabogoy";
                String pass ="admin";


                    Intent home = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(home);
                    Toast.makeText(HomeActivity.this,"Successfully Logged out!",Toast.LENGTH_LONG).show();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}