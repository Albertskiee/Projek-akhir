package com.example.projekakhirjmp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button areg;
    EditText aduser,apassword;
    databaseHelper dblogin;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        areg =findViewById(R.id.btnregister);
        aduser=findViewById(R.id.eduser);
        apassword=findViewById(R.id.edpassword);
        dblogin=new databaseHelper(this);

        areg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = aduser.getText().toString();
                String password = apassword.getText().toString();
                Boolean checkUser = dblogin.checkUser(user);
                if(checkUser == false) {
                    Boolean insert = dblogin.insertUser(user, password);
                    if(insert == true) {
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Registered Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "User Already Exit", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}