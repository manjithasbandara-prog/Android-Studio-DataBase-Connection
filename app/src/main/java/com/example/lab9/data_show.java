package com.example.lab9;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class data_show extends AppCompatActivity {

    Button back;
    DBHelper db;
    ListView list;

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
        list = findViewById(R.id.list);
        db = new DBHelper(this);

        ArrayList<String> dataList = new ArrayList<>();
        Cursor res = db.getAllData();

        if(res.getCount() == 0){
            dataList.add("No Data Found");
        }
        else {
            while(res.moveToNext()){
                String record = "ID: " + res.getInt(0) +
                        "\nName: " + res.getString(1) +
                        "\nAge: " + res.getInt(2);
                dataList.add(record);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        list.setAdapter(adapter);

    }
}