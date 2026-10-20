package com.example.lab9;

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

public class delete extends AppCompatActivity {

    Button view, delete;
    EditText idDelete, nameDelete, ageDelete;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        view = findViewById(R.id.view);
        delete = findViewById(R.id.delete);
        idDelete = findViewById(R.id.idDelete);
        nameDelete = findViewById(R.id.nameDelete);
        ageDelete = findViewById(R.id.ageDelete);
        db = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(delete.this, data_show.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idstr = idDelete.getText().toString();
                if(idstr.isEmpty()){
                    Toast.makeText(delete.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                }

                int id = Integer.parseInt(idstr);
                boolean deleted = db.deleteData(id);

                if(deleted){
                    Toast.makeText(delete.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(delete.this, "Delete Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}