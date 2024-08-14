package com.example.projekakhirjmp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button binsert, blistdata, binfo, blogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        binsert = findViewById(R.id.btninsert);
        blistdata = findViewById(R.id.btnlistdata);
        binfo = findViewById(R.id.btninformation);
        blogout = findViewById(R.id.btnlogout);

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Insert.class);
                startActivity(intent);
            }
        });

        blistdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListData.class);
                startActivity(intent);
            }
        });

        binfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Information.class);
                startActivity(intent);
            }
        });

        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aksi untuk logout, kembali ke layar login
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish(); // Tutup MainActivity setelah logout
            }
        });
    }
}
