package com.example.yourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.yourgrade.R.id.textName;

public class ShowGradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grade);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String grade = intent.getStringExtra("grade");

        TextView textName = (TextView) findViewById(R.id.textName);
        textName.setText(name);
        TextView textScore = (TextView) findViewById(R.id.textScore);
        textScore.setText(grade);

    }
}
