package com.example.caltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details_button = findViewById(R.id.button_details);
        details_button.setOnClickListener(details_buttonlistener);

        scan =findViewById(R.id.button_scan);
        scan.setOnClickListener(scan_listener);

        bmi_button = findViewById(R.id.button_BMI);
        bmi_button.setOnClickListener(bmi_listener);
    }
    private Button details_button;
    private  View.OnClickListener details_buttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(android.view.View view) {
            startActivity(new Intent(MainActivity.this, Details.class));

        }
    };
    private Button scan;
    private View.OnClickListener scan_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, ClassifierActivity.class));
        }
    };
    private Button bmi_button;
    private View.OnClickListener bmi_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, BMI.class));
        }
    };

    private View.OnClickListener details = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Details.class));//launch bmr activity
        }
    };
}
