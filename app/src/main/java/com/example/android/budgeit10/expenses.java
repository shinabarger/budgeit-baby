package com.example.android.budgeit10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class expenses extends AppCompatActivity {

    EditText housingExpense;
    EditText foodExpense;
    EditText transportExpense;
    EditText otherExpense;
    Button expensesButton;
    TextView addExpenses;

    double housing, food, transport, other, sum;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        housingExpense = (EditText) findViewById(R.id.housingExpense);
        foodExpense = (EditText) findViewById(R.id.foodExpense);
        transportExpense = (EditText) findViewById(R.id.transportExpense);
        otherExpense = (EditText) findViewById(R.id.otherExpense);
        expensesButton = (Button) findViewById(R.id.expensesButton);
        addExpenses = (TextView) findViewById(R.id.totalMonthlyExpenses);


        expensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                housing = Double.parseDouble(housingExpense.getText().toString());
                try {
                    Double.parseDouble(housingExpense.getText().toString());
                } catch (NumberFormatException nfe) {
                }
                food = Double.parseDouble(foodExpense.getText().toString());
                transport = Double.parseDouble(transportExpense.getText().toString());
                other = Double.parseDouble(otherExpense.getText().toString());
                sum = housing + food + transport + other;
                addExpenses.setText(Double.toString(sum));

            }
        });
        expensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(housingExpense.getText().toString()) ||
                        TextUtils.isEmpty(foodExpense.getText().toString()) ||
                        TextUtils.isEmpty(otherExpense.getText().toString()) ||
                        TextUtils.isEmpty(transportExpense.getText().toString())) {

                    addExpenses.setText("Please fill all fields."); // if any of the fields is empty, add nothing to textview

                } else {
                    Double housing = Double.parseDouble(housingExpense.getText().toString());
                    Double food = Double.parseDouble(foodExpense.getText().toString());
                    Double transport = Double.parseDouble(transportExpense.getText().toString());
                    Double other = Double.parseDouble(otherExpense.getText().toString());
                    Double sum = housing + food + transport + other;
                    addExpenses.setText(Double.toString(sum));
                }
            }
        });
    }
    public void fourthNext(View view) {
        Intent intent = new Intent(this, Goals.class);

        startActivity(intent);
    }
}