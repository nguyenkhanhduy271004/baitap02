package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextSize;
    private Button buttonGenerate;
    private TextView textViewArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        editTextSize = findViewById(R.id.editTextSize);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        textViewArray = findViewById(R.id.textViewArray);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateAndDisplayArray();
            }
        });
    }

    private void generateAndDisplayArray() {
        try {
            String inputSize = editTextSize.getText().toString();

            if (!inputSize.isEmpty()) {
                int size = Integer.parseInt(inputSize);
                ArrayList<Integer> randomArray = generateRandomArray(size);

                textViewArray.setText("Mảng được tạo ngẫu nhiên: " + randomArray.toString());

                displaySquareNumbersToast(randomArray);
            } else {
                Toast.makeText(MainActivity3.this, "Vui lòng nhập kích thước mảng.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity3.this, "Giá trị nhập vào không hợp lệ. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<Integer> generateRandomArray(int size) {
        ArrayList<Integer> randomArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray.add(random.nextInt(100));
        }

        return randomArray;
    }

    private void displaySquareNumbersToast(ArrayList<Integer> array) {
        StringBuilder squareNumbers = new StringBuilder("Square Numbers: ");
        for (int number : array) {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == (int) squareRoot) {
                squareNumbers.append(number).append(", ");
            }
        }

        if (squareNumbers.length() > 0) {
            squareNumbers.delete(squareNumbers.length() - 2, squareNumbers.length()); // Remove the last comma
            Toast.makeText(MainActivity3.this, squareNumbers.toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity3.this, "Không tìm thấy số bình phương.", Toast.LENGTH_SHORT).show();
        }
    }
}
