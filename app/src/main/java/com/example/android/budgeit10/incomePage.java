package com.example.android.budgeit10;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class incomePage extends AppCompatActivity {

    AppCompatActivity appCompatActivity;
    EditText perYearAmount;
    EditText perMonthAmount;
    EditText perWeekAmount;
    Button totalButton;
    TextView addResult;

    double year, month, week, sum;

    public final static String INCOME_TOTAL = "com.example.budgeitbaby.MESSAGE";
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_page);
        perYearAmount = (EditText) findViewById(R.id.perYearAmount);
        perMonthAmount = (EditText) findViewById(R.id.perMonthAmount);
        perWeekAmount = (EditText) findViewById(R.id.perWeekAmount);
        totalButton = (Button) findViewById(R.id.totalButton);
        addResult = (TextView) findViewById(R.id.totalMonthlyIncome);


        totalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = Double.parseDouble(perYearAmount.getText().toString());
                try {
                    Double.parseDouble(perYearAmount.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                month = Double.parseDouble(perMonthAmount.getText().toString());
                week = Double.parseDouble(perWeekAmount.getText().toString());
                sum = year + month + week;
                addResult.setText(Double.toString(sum));

            }
        });
        totalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(perYearAmount.getText().toString()) ||
                        TextUtils.isEmpty(perMonthAmount.getText().toString()) ||
                        TextUtils.isEmpty(perWeekAmount.getText().toString())) {

                    addResult.setText(""); // if any of the fields is empty, add nothing to textview

                } else {
                    Double year = Double.parseDouble(perYearAmount.getText().toString());
                    Double month = Double.parseDouble(perMonthAmount.getText().toString());
                    Double week = Double.parseDouble(perWeekAmount.getText().toString());
                    Double sum = year / 12 + month + week * 52;
                    addResult.setText(Double.toString(sum));
                }
            }
        });
    }

    public void thirdNext(View view) {
        Intent intent = new Intent(this, expenses.class);
        TextView textView = (TextView) findViewById(R.id.totalMonthlyIncome);

        String income = textView.getText().toString();
        startActivity(intent);

    }
}
