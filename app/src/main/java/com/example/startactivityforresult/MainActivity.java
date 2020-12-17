package com.example.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView tvResult;
private EditText etNumber1;
private EditText etNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.TV_result);
        etNumber1 = findViewById(R.id.ET_number1);
        etNumber2 = findViewById(R.id.ET_number2);

        Button buttonOpenActivity2 = findViewById(R.id.btn_button1);
        buttonOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verify if both ET contains number or not
                if(etNumber1.getText().toString().equals("") || etNumber2.getText().toString().equals("")){
                    // popup msg if the field is empty
                    Toast.makeText( MainActivity.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
                } else {
                    //pour recuperer les deux nombres
                    int number1 = Integer.parseInt(etNumber1.getText().toString());
                    int number2 = Integer.parseInt(etNumber2.getText().toString());
                    //on va les transmettre dans activite 2
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    //firt for the key ans second for the value
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    //maintenant on va utiliser startactivityforresult
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                tvResult.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED) {
                tvResult.setText("Nothing selected");
            }
        }
    }
}
