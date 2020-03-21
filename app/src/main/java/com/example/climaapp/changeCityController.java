package com.example.climaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class changeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_city_controller);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        final EditText editTextField = findViewById(R.id.queryET);
        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back and destroy the ChangeCityController
                finish();
            }
        });

        // Buttons can have a listener for clicks.
        // EditTexts can have listeners for keyboard presses like hitting the enter key.
        editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String newCity = editTextField.getText().toString();
                Intent newCityIntent = new Intent(changeCityController.this, WeatherController.class);

                // Adds what was entered in the EditText as an extra to the intent.
                newCityIntent.putExtra("City", newCity);

                // We started this activity for a result, so now we are setting the result.
                setResult(Activity.RESULT_OK, newCityIntent);

                // This destroys the ChangeCityController.
                finish();
                return true;
            }
        });

    }
}
