package com.sahil.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Bundle bundle;
    private TextView title;
    private TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title = findViewById(R.id.second_activity_title);
        body = findViewById(R.id.second_activity_body_txt);

        bundle = getIntent().getExtras();

        if (bundle != null) {
            String title_txt = bundle.getString("title");
            title.setText(title_txt);
            body.setText("Data pertaining to " + title_txt);
        } else {
            body.setText("Error fetching information");
            body.setTextColor(Color.RED);
        }

    }
}
