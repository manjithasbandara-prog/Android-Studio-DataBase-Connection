package com.example.lab9;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class delete extends AppCompatActivity {

    Button view, deleteBtn, back;
    EditText idDelete;
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
        deleteBtn = findViewById(R.id.delete);
        back = findViewById(R.id.back);
        idDelete = findViewById(R.id.idDelete);
        db = new DBHelper(this);

        Animation clickAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        back.setOnClickListener(v -> finish());

        view.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            Intent i = new Intent(delete.this, data_show.class);
            startActivity(i);
        });

        deleteBtn.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            String idstr = idDelete.getText().toString().trim();
            if (idstr.isEmpty()) {
                Toast.makeText(delete.this, "Please enter an ID to delete!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int id = Integer.parseInt(idstr);
                boolean deleted = db.deleteData(id);

                if (deleted) {
                    Toast.makeText(delete.this, "User Deleted Successfully!", Toast.LENGTH_SHORT).show();
                    idDelete.setText("");
                } else {
                    Toast.makeText(delete.this, "Delete Failed! Check if ID exists.", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(delete.this, "ID must be a valid number!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}