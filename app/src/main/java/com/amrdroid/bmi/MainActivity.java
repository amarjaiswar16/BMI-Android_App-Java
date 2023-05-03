package com.amrdroid.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //All view reference variable created
        EditText weight_edt,heightF_edt,heightI_edt;
        Button calculate_btn;
        TextView result_txt;
        LinearLayout root_ll;

        //assigning id values into reference variable
        weight_edt = findViewById(R.id.weight_edt);
        heightF_edt = findViewById(R.id.heightF_edt);
        heightI_edt = findViewById(R.id.heightI_edt);
        calculate_btn = findViewById(R.id.calculate_btn);
        result_txt = findViewById(R.id.result_txt);
        root_ll = findViewById(R.id.mainR_ll);

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int wt = Integer.parseInt(weight_edt.getText().toString());
             int htF = Integer.parseInt(heightF_edt.getText().toString());
             int htI = Integer.parseInt(heightI_edt.getText().toString());

             int totalIn = htF*12 + htI;  //ft*12 = in
             double totalCm = totalIn * 2.53;//in*2.53 = cm
             double totalM = totalCm/100; //cm/100 = m
             double bmi = wt/(totalM*totalM);
             if(bmi>25) {
                 result_txt.setText("You're Overweight!");
                 root_ll.setBackgroundColor(getResources().getColor(R.color.colorOw));
             }else if(bmi<18) {
                 result_txt.setText("You're Underweight!");
                 root_ll.setBackgroundColor(getResources().getColor(R.color.colorUw));
             }else {
                 result_txt.setText("You're Healthy!");
                 root_ll.setBackgroundColor(getResources().getColor(R.color.colorH));
             }


            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit?")
                .setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();


    }
}