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

public class MainActivity extends AppCompatActivity {

    Button send, view, update, delete;
    EditText nameInput, ageInput;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        send = findViewById(R.id.send);
        nameInput = findViewById(R.id.name);
        ageInput = findViewById(R.id.age);
        view = findViewById(R.id.view);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        db = new DBHelper(this);

        Animation clickAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        send.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            String name = nameInput.getText().toString().trim();
            String ageStr = ageInput.getText().toString().trim();

            if (name.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both name and age", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int age = Integer.parseInt(ageStr);
                long result = db.insertData(name, age);
                if (result != -1) {
                    Toast.makeText(MainActivity.this, "User saved successfully! ID: " + result, Toast.LENGTH_SHORT).show();
                    nameInput.setText("");
                    ageInput.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Failed to save user!", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Please enter a valid age number", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            Intent i = new Intent(MainActivity.this, data_show.class);
            startActivity(i);
        });

        update.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            Intent i = new Intent(MainActivity.this, update.class);
            startActivity(i);
        });

        delete.setOnClickListener(v -> {
            v.startAnimation(clickAnim);
            Intent i = new Intent(MainActivity.this, delete.class);
            startActivity(i);
        });
    }
}