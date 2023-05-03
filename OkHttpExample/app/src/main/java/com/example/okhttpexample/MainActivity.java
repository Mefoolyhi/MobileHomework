package com.example.okhttpexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    OkHttpClient client;
    String getUrl = "https://demo.codeseasy.com/apis/okhttp/get.php?key_name=value";
    String postUrl = "https://demo.codeseasy.com/apis/okhttp/post.php";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new OkHttpClient();
        textView = findViewById(R.id.textData);
        Button buttonGet = findViewById(R.id.btnGet);
        Button buttonPost = findViewById(R.id.btnPost);

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get();
            }
        });

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
            }
        });
    }

    private void proceed(Request request) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            textView.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void get() {
        Request request = new Request.Builder().url(getUrl).build();
        proceed(request);
    }

    private void post() {
        RequestBody requestBody = new FormBody.Builder()
                .add("key_name", "Demo Value")
                .build();
        Request request = new Request.Builder().url(postUrl).post(requestBody).build();
        proceed(request);
    }
}