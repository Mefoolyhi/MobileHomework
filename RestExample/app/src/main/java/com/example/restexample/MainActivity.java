package com.example.restexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private TextView translated;
    private Button translateBtn;

    private final String URL = "https://translate.yandex.ru";
    private final String KEY = "";

    private Gson gson = new GsonBuilder().create();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();

    private Link intf = retrofit.create(Link.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.originalET);
        translated = findViewById(R.id.translatedTV);
        translateBtn = findViewById(R.id.translateBtn);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> mapJson = new HashMap<>();
                mapJson.put("key", KEY);
                mapJson.put("lang", "en-ru");
                mapJson.put("text", text.getText().toString());

                Call<Object> call = intf.translate(mapJson);

                try {
                    Response<Object> res = call.execute();

                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            translated.setText(e.getValue().toString());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}