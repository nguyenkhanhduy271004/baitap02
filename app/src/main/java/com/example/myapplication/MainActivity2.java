package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final EditText editTextNumbers = findViewById(R.id.editTextNumbers);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editTextNumbers.getText().toString();
                ArrayList<Integer> numbers = parseNumbers(inputText);

                if (!numbers.isEmpty()) {
                    ArrayList<Integer> primeNumbers = findPrimeNumbers(numbers);
                    Log.d("Số nguyên tố: ", primeNumbers.toString());
                } else {
                    Log.e("Dữ liệu sai!!!", "Không có dữ liệu!!!");
                }
            }
        });
    }

    private ArrayList<Integer> parseNumbers(String inputText) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] inputArray = inputText.split(",");

        for (String item : inputArray) {
            try {
                int number = Integer.parseInt(item.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                Log.e("NumberFormatException", "Invalid input: " + item);
            }
        }

        return numbers;
    }

    private ArrayList<Integer> findPrimeNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
        }

        return primeNumbers;
    }

    private boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
