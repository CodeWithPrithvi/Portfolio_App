package com.prithviraj.myportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView gridView = findViewById(R.id.gridView);
        ArrayList<String> data = new ArrayList<>();
        data.add("About Me");
        data.add("Technical Skills");
        data.add("Relevant Course Subjects");
        data.add("Languages");




        MyAdapter adapter = new MyAdapter(this, data);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = data.get(position);
                Intent intent;

                // Determine which activity to open based on the selected item
                switch (selectedItem) {
                    case "About Me":
                        intent = new Intent(menu.this, AboutMeActivity.class);
                        break;
                    case "Technical Skills":
                        intent = new Intent(menu.this, TechnicalSkillsActivity.class);
                        break;
                    case "Relevant Course Subjects":
                        intent = new Intent(menu.this, RelevantCourseSubjectsActivity.class);
                        break;
                    case "Languages":
                        intent = new Intent(menu.this, LanguagesActivity.class);
                        break;
                    default:

                        return;
                }


                startActivity(intent);
            }
        });


    }
}