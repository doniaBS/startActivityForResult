package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setTitle("Activity 2");
        //get the data from activity 1
        Intent intent = getIntent();
        int number1 = intent.getIntExtra("number1", 0);
        int number2 = intent.getIntExtra("number2", 0);
        // creer refference pour textview
        TextView textViewNumbers = findViewById(R.id.TV_numbers);
        textViewNumbers.setText("Numbers: " + number1 + ", " + number2);

        //les buttons mnt on va les declarer
        Button buttonAdd = findViewById(R.id.btn_add);
        Button buttonSubtract = findViewById(R.id.btn_subtract);

        // onclick listener des deux bouttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;
                //send the information back
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                // setResult is what mainactivity will get back after calling startactivityforresult
                //result ok is to check if our request was sucssesful or not
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;
                //send the information back
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                // setResult is what mainactivity will get back after calling startactivityforresult
                //result ok is to check if our request was sucssesful or not
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });
    }
}