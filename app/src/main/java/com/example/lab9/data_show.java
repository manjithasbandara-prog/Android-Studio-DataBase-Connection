package com.example.lab9;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class data_show extends AppCompatActivity {

    Button back;
    DBHelper db;
    RecyclerView recyclerView;
    LinearLayout emptyStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_show);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recyclerView);
        emptyStateView = findViewById(R.id.emptyStateView);
        db = new DBHelper(this);

        List<User> userList = new ArrayList<>();
        Cursor res = db.getAllData();

        if (res != null) {
            while (res.moveToNext()) {
                int id = res.getInt(0);
                String name = res.getString(1);
                int age = res.getInt(2);
                userList.add(new User(id, name, age));
            }
            res.close();
        }

        if (userList.isEmpty()) {
            emptyStateView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyStateView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            UserAdapter adapter = new UserAdapter(userList);
            recyclerView.setAdapter(adapter);
        }

        back.setOnClickListener(v -> finish());
    }
}