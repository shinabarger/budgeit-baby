package com.example.android.budgeit10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);
    }

    /** Called when the user clicks this Second next button */
    public void secondNext(View view) {
        Intent intent = new Intent(this, incomePage.class);

        startActivity(intent);
    }
}