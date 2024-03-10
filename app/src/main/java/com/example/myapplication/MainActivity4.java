package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplay();
            }
        });
    }

    private void calculateAndDisplay() {
        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số lượng phần tử:", Toast.LENGTH_SHORT).show();
            return;
        }

        int size = Integer.parseInt(input);
        StringBuilder result = new StringBuilder("Số chính phương: ");

        for (int i = 1; i * i <= size; i++) {
            result.append(i * i).append(" ");
        }

        textView.setText(result.toString());
    }
}
