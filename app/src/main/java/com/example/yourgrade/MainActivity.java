package com.example.yourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    private EditText editName, editScore;
    private Button btnConfirm, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editScore = (EditText) findViewById(R.id.editScore);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnExit = (Button) findViewById(R.id.btnExit);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String strScore = editScore.getText().toString();
                boolean checkName = editName.getText().toString().trim().equalsIgnoreCase("");
                boolean checkScore = editScore.getText().toString().trim().equalsIgnoreCase("");
                if(checkName){
                    editName.setError("ป้อนชื่อ");
                }
                if(checkScore){
                    editScore.setError("ป้อนคะแนน");
                }
                if(!checkName && !checkScore){
                    int score = Integer.valueOf(strScore);
                    String grade = calGrade(score);
                    Intent intent = new Intent(MainActivity.this, ShowGradeActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("grade",grade);
                    startActivity(intent);
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setNegativeButton("ยกเลิก",null);
                dialog.show();
            }
        });
    }
    public String calGrade(int score){
        String grade = "";
        if(score >= 80){
            grade = "A";
        }
        else if (score >= 70){
            grade = "B";
        }
        else if (score >= 60){
            grade = "C";
        }
        else if (score >= 50){
            grade = "D";
        }
        else{
            grade = "F";
        }
        return grade;
    }
}
