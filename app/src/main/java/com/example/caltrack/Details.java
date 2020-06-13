package com.example.caltrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myDB = new DataBaseHelper(this);

        //set listener for button


        addValues = findViewById(R.id.addEntryButton);
        addValues.setOnClickListener(addEntryButtonListener);

        nameEditText = findViewById(R.id.nameEditText);
        nameEditText.addTextChangedListener(nameEditTextWatcher);
             //get manipulated TextViews and Switch
        heightTextView = findViewById(R.id.heightTextView);
        weightTextView = findViewById(R.id.weightTextView);
        genderSwitch = (Switch) findViewById(R.id.genderSwitch);

        //set TextWatcher for ageEditText
        ageEditText = findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);

        profEditText = findViewById(R.id.profession);
        profEditText.addTextChangedListener(profEditTextWatcher);

        //set TextWatcher for heightSeekBar
        heightEditText =  findViewById(R.id.heightValue);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        //set Listener for weightSeekBar
        weightEditText = findViewById(R.id.weightValue);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
        //get radio buttons
        zero = (RadioButton) findViewById(R.id.zeroButton);
        oneToTwo = (RadioButton) findViewById(R.id.oneToTwoButton);
        threeToFive = (RadioButton) findViewById(R.id.threeToFiveButton);
        sixToSeven = (RadioButton) findViewById(R.id.sixToSevenButton);
    }

    DataBaseHelper myDB;
    private Button bmiButton;//will launch bmi activity
    private Button addValues;
    private EditText ageEditText;
    private EditText nameEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private EditText profEditText;

    public static double height = 480;
    public static int weight = 200;
    public static int age = 0;
    public static String prof = "";
    public static String name = "";
    private TextView heightTextView;//show User's height
    private TextView weightTextView;//show User's weight
    public static Switch genderSwitch;//gets User's gender
    //Radio buttons
    public static RadioButton zero;
    public static RadioButton oneToTwo;
    public static RadioButton threeToFive;
    public static RadioButton sixToSeven;

    private View.OnClickListener addEntryButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String prof1 = prof;
            String name1=name;
            int weight1 = weight;
            double height1 =  height;
            int age1 = age;
            double bmi = CalculateBmi();
                AddData(name1,prof1, weight1, bmi,age1,height1);

                /*ageEditText.setText("");
                weightEditText.setText("");
                heightEditText.setText("");*/

        }
    };
      private final TextWatcher ageEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {//get age and display it
                age = Integer.parseInt(s.toString());
            } catch (NumberFormatException e){//if its not a number or empty
                age = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                height = Double.parseDouble(s.toString());
            } catch (NumberFormatException e){//if its not a number or empty
                height = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            heightTextView.setText((height+"m"));
        }
    };
    private final TextWatcher nameEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            name = s.toString();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private final TextWatcher profEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            prof = s.toString();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {//get age and display it
                weight = Integer.parseInt(s.toString());
            } catch (NumberFormatException e){//if its not a number or empty
                weight = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            weightTextView.setText(weight + "kgs");
        }
    };





    public void AddData(String name, String prof, int weight, double bmi,int age,double height) {
        boolean insert = myDB.addData(name,prof, weight, bmi,age,height);
        Log.d("MI", insert + "");
        if (insert == true) {
            Toast.makeText(this, "Entered Data", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_LONG).show();
        }
    }

    private double CalculateBmi() {
        double bmi = ( (double) weight / ( (double) height * (double) height)) * 703;
        return bmi;
    }

}
