package com.example.projekakhirjmp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    Button btninputedit;
    EditText ednama,edumur,edmoto ;
    databaseHelper dbmaster;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_insert);
        btninputedit=findViewById(R.id.btnsimpan);
        ednama=findViewById(R.id.inputNama);
        edumur=findViewById(R.id.inputUmur);
        edmoto=findViewById(R.id.inputMotto);
        dbmaster=new databaseHelper(this );

        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");

        if (id != null) {
            Cursor data = dbmaster.getAllData();
            if (data.moveToFirst()) {
                do {
                    if (data.getString(0).equals(id)) {
                        ednama.setText(((Cursor) data).getString(1));
                        edumur.setText(data.getString(2));
                        edmoto.setText(data.getString(3));
                        btninputedit.setText("Update Data");
                        break;
                    }
                } while (data.moveToNext());
            }

            btninputedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdated = dbmaster.updateData(id, ednama.getText().toString(), Integer.parseInt(edumur.getText().toString()),edmoto.getText().toString());
                    if (isUpdated)
                        Toast.makeText(Insert.this, "Data Updated", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Insert.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            btninputedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = dbmaster.insertData(ednama.getText().toString(), Integer.parseInt(edumur.getText().toString()),edmoto.getText().toString());
                    if (isInserted)
                        Toast.makeText(Insert.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Insert.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                }
            });
        }
            }


    }
