package ru.gb.lesson4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String NUMBER_1 = "NUMBER_1";
    public static final String NUMBER_2 = "NUMBER_2";
    public static final String SYMBOL = "SYMBOL";
    public static final String RESULT = "RESULT";
    private EditText num1View;
    private TextView symbolView;
    private EditText num2View;
    private TextView resultView;
    String a;
    String b;
    char c;
    String x;
    Buttons buttons = new Buttons();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);

        num1View = findViewById(R.id.num1View);
        symbolView = findViewById(R.id.symbolView);
        num2View = findViewById(R.id.num2View);
        resultView = findViewById(R.id.resultView);

        Button butn0 = findViewById(R.id.button0);
        butn0.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "0";
            } else {
                b = "0";
            }

            updateView();
        });

        Button butn1 = findViewById(R.id.button1);
        butn1.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "1";
            } else {
                b = "1";
            }

            updateView();
        });

        Button butn2 = findViewById(R.id.button2);
        butn2.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "2";
            } else {
                b = "2";
            }
            updateView();
        });

        Button butn3 = findViewById(R.id.button3);
        butn3.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "3";
            } else {
                b = "3";
            }
            updateView();
        });

        Button butn4 = findViewById(R.id.button4);
        butn4.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "4";
            } else {
                b = "4";
            }
            updateView();
        });

        Button butn5 = findViewById(R.id.button5);
        butn5.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "5";
            } else {
                b = "5";
            }
            updateView();
        });

        Button butn6 = findViewById(R.id.button6);
        butn6.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "6";
            } else {
                b = "6";
            }
            updateView();
        });

        Button butn7 = findViewById(R.id.button7);
        butn7.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "7";
            } else {
                b = "7";
            }
            updateView();
        });

        Button butn8 = findViewById(R.id.button8);
        butn8.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "8";
            } else {
                b = "8";
            }
            updateView();
        });

        Button butn9 = findViewById(R.id.button9);
        butn9.setOnClickListener(v -> {
            if (a == null || a == " ") {
                a = "9";
            } else {
                b = "9";
            }
            updateView();
        });

        Button butnPlus = findViewById(R.id.buttonPlus);
        butnPlus.setOnClickListener(v -> {
            c = '+';
            updateView();
        });

        Button butnDigit = findViewById(R.id.buttonDigit);
        butnDigit.setOnClickListener(v -> {
            c = '÷';
            updateView();
        });

        Button butnClear = findViewById(R.id.buttonClear);
        butnClear.setOnClickListener(v -> {
            a = " ";
            b = " ";
            c = ' ';
            x = " ";
            updateView();
            updateResultView();
        });

        Button butnMultiply = findViewById(R.id.buttonMultiply);
        butnMultiply.setOnClickListener(v -> {
            c = 'x';
            updateView();
        });

        Button butnMinus = findViewById(R.id.buttonMinus);
        butnMinus.setOnClickListener(v -> {
            c = '-';
            updateView();
        });

        Button butnEquals = findViewById(R.id.buttonEquals);
        butnEquals.setOnClickListener(v -> {
            if (a != null && b != null && c == '+') {
                x = buttons.setPlusResult(a, b);
                updateResultView();
            }

            if (a != null && b != null && c == '-') {
                x = buttons.setMinusResult(a, b);
                updateResultView();
            }

            if (b.equals("0") && c == ('÷')) {
                resultView.setText("Ошибка");
            } else if (a != null && c == '÷') {
                x = buttons.setDigitResult(a, b);
                updateResultView();
            }

            if (a != null && b != null && c == 'x') {
                x = buttons.setMultiplyResult(a, b);
                updateResultView();
            }
        });
    }

    private void updateView() {
        if (a != null) {
            num1View.setText(a);
        }
        if (b != null) {
            num2View.setText(b);
        }
        symbolView.setText(String.valueOf(c));
    }

    private void updateResultView() {
        resultView.setText(String.valueOf(x));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        a = savedInstanceState.getString(NUMBER_1);
        b = savedInstanceState.getString(NUMBER_2);
        c = savedInstanceState.getChar(SYMBOL);
        updateView();
        x = savedInstanceState.getString(RESULT);
        updateResultView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NUMBER_1, a);
        outState.putString(NUMBER_2, b);
        outState.putChar(SYMBOL, c);
        outState.putString(RESULT, x);
    }
}