package com.example.lab9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class update extends AppCompatActivity {

    Button back, update;
    EditText idUpdate, nameUpdate, ageUpdate;
    DBHelper db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back = findViewById(R.id.back);
        update = findViewById(R.id.update);
        idUpdate = findViewById(R.id.idUpdate);
        nameUpdate = findViewById(R.id.nameUpdate);
        ageUpdate = findViewById(R.id.ageUpdate);
        db = new DBHelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(update.this, MainActivity.class);
                startActivity(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newID = idUpdate.getText().toString();
                String newName = nameUpdate.getText().toString();
                String newAge = ageUpdate.getText().toString();

                if(newID.isEmpty() || newName.isEmpty() || newAge.isEmpty()){
                    Toast.makeText(update.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                updateing the values
                int id = Integer.parseInt(newID);
                boolean updated = db.updateData(id, newName, Integer.parseInt(newAge));

                if(updated){
                    Toast.makeText(update.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(update.this, "Update Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}