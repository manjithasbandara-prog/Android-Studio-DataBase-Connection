package com.example.lab9;

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

public class update extends AppCompatActivity {

    Button back, updateBtn;
    EditText idUpdate, nameUpdate, ageUpdate;
    DBHelper db;

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
        updateBtn = findViewById(R.id.update);
        idUpdate = findViewById(R.id.idUpdate);
        nameUpdate = findViewById(R.id.nameUpdate);
        ageUpdate = findViewById(R.id.ageUpdate);
        db = new DBHelper(this);

        Animation clickAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        back.setOnClickListener(v -> finish());

        updateBtn.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            String newID = idUpdate.getText().toString().trim();
            String newName = nameUpdate.getText().toString().trim();
            String newAge = ageUpdate.getText().toString().trim();

            if (newID.isEmpty() || newName.isEmpty() || newAge.isEmpty()) {
                Toast.makeText(update.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int id = Integer.parseInt(newID);
                int age = Integer.parseInt(newAge);
                boolean updated = db.updateData(id, newName, age);

                if (updated) {
                    Toast.makeText(update.this, "Record Updated Successfully!", Toast.LENGTH_SHORT).show();
                    idUpdate.setText("");
                    nameUpdate.setText("");
                    ageUpdate.setText("");
                } else {
                    Toast.makeText(update.this, "Update Failed! Check if ID exists.", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(update.this, "ID and Age must be valid numbers!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}