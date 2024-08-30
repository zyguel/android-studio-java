package com.example.personal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    // Step 3 declare your components
    TextView displaytxt;
    TextView displayname;
    EditText txtname;
    Button btnclickme;
    /*TextView displayid;
    EditText txtid;
    TextView displaycourse;
    EditText txtcourse;
    TextView displayyear;
    EditText txtyear;
    */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Step 4 Casting
        displaytxt = findViewById(R.id.displaytxt);
        displayname = findViewById(R.id.txtdisplayTitle);
        txtname = findViewById(R.id.txtname);
        /*txtid = findViewById(R.id.txtid);
        txtcourse = findViewById(R.id.txtcourse);
        txtyear = findViewById(R.id.txtyear);
*/
        btnclickme = findViewById(R.id.btnclickme);

        // Set default hint text
        txtname.setHint("Enter Name");
        /*txtid.setHint("Enter ID");
        txtcourse.setHint("Enter Course");
        txtyear.setHint("Enter Year");
*/
        btnclickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtname.getText().toString();
              /*  String id = txtid.getText().toString();
                String course = txtcourse.getText().toString();
                String year = txtyear.getText().toString();*/
                displaytxt.setText(name + "\n");
               // displaytxt.setText(name + "\n" + id + "\n" + course + "\n" + year);
            }
        });

        // Use OnFocusChangeListener to manage user input
        txtname.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && txtname.getText().toString().equals("Enter Name")) {
                txtname.setText(""); // Clear the hint text when user starts typing
            }
        });
/*
        txtid.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && txtid.getText().toString().equals("Enter ID")) {
                txtid.setText(""); // Clear the hint text when user starts typing
            }
        });

        txtcourse.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && txtcourse.getText().toString().equals("Enter Course")) {
                txtcourse.setText(""); // Clear the hint text when user starts typing
            }
        });

        txtyear.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && txtyear.getText().toString().equals("Enter Year")) {
                txtyear.setText(""); // Clear the hint text when user starts typing
            }
        });
*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
