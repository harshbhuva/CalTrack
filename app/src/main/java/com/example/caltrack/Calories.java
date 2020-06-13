package com.example.caltrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Calories extends Activity {
    String food_item = "";
    String food_cals = "";
    TextView food_text;
    private ProgressBar spinner;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        food_text = (TextView)findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        Log.v("com.example.rnky39.demo","saving...");
        Log.v("com.example.rnky39.demo",this.username);

        if (bundle.getString("food_item") !=null){
            String[] food_info=(bundle.getString("food_item")).split(",");
            if(food_info.length == 2){
                this.food_item=food_info[0];
                this.food_cals=food_info[1];
                spinner = (ProgressBar)findViewById(R.id.progressBar2);
                spinner.setVisibility(View.GONE);
            }
            food_text.setText(food_item+":\n"+food_cals);
        }else{
            System.out.println("NULL");
            food_text.setText("NULL");
        }
        username = bundle.getString("username");

    }

    public void cameraClass(View view){
        Intent intent=new Intent(this,ClassifierActivity.class);
        intent.putExtra("username",this.username);
        startActivity(intent);

    }


    }

