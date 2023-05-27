package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonExit = findViewById(R.id.btnExit);
        buttonExit.setOnClickListener(this);

        findViewById(R.id.btnStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnStart) {
            Intent intent = new Intent(this, GameActivity.class);
            startActivityForResult(intent, 0);
        } else if (view.getId() == R.id.btnExit) {
            finish();
        }
    }
}