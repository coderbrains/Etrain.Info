package com.example.etraininfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    private EditText editText;
    private EditText editText1;
    private TextView textView;
    private Button button;
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        editText = findViewById(R.id.edt1);
        editText1 = findViewById(R.id.edt2);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(editText.getText().toString(),editText1.getText().toString());
            }
        });
    }

    private void validate(String string, String string1) {


        if (string.length() == 0) {
            editText.setError("Please fill this");
            editText.requestFocus();
            return;
        } else if (string1.length() == 0) {
            editText1.setError("Please fill out this field");
            editText1.requestFocus();
            return;
        } else if (string.equals("admin@1234") && string1.equals("12345")) {
            Intent intent = new Intent(LoginPage.this, Main2Activity.class);
            startActivity(intent);
        } else {
            count--;
            textView.setText("number of attempts remaining : " + count);
            if (count == 0) {
                button.setEnabled(false);
            }
        }
    }
}
