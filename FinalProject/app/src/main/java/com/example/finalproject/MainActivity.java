package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBInteractor dbInteractor = new DBInteractor(this);

        List<NameItem> items = dbInteractor.getItems();
        RVAdapter adapter = new RVAdapter(items);

        EditText nameEditText = findViewById(R.id.name_edit_text);
        Button saveNameButton = findViewById(R.id.save_name_button);
        RecyclerView namesRV = findViewById(R.id.name_list);

        namesRV.setAdapter(adapter);
        namesRV.setLayoutManager(new LinearLayoutManager(this));

        saveNameButton.setOnClickListener(v -> {
            if (!nameEditText.getText().toString().equals("")) {
                NameItem newItem = new NameItem(nameEditText.getText().toString(), getRandomImageUrl());
                Runnable runnable = () -> dbInteractor.addItem(newItem);
                Thread thread = new Thread(runnable);
                thread.start();

                nameEditText.setText("");
                adapter.addItem(newItem);
            }
        });
    }

    private String getRandomImageUrl() {
        List<String> urls = new ArrayList<String>();
        urls.add("https://cdn.leroymerlin.ru/lmru/image/upload/v1645929715/b_white,c_pad,d_photoiscoming.png,f_auto,h_600,q_auto,w_600/lmcode/054GuJM_I0ei5YxVxDeBNA/90257331_02.jpg");
        urls.add("https://laplaya-rus.ru/wp-content/uploads/d/c/7/dc78bbe85f768c6686fb74ff8c603eda.jpeg");
        urls.add("https://www.fonstola.ru/images/202012/fonstola.ru_419624.jpg");
        urls.add("https://zeleniymir.org/wp-content/uploads/2019/04/Rys-69-1024x819.jpg");
        urls.add("https://animalreader.ru/wp-content/uploads/2014/10/sus-scrofa-e1413736415314.jpg");
        urls.add("https://klike.net/uploads/posts/2023-01/1675142525_3-68.jpg");
        urls.add("https://img-fotki.yandex.ru/get/171919/284276260.1f/0_1f0763_5c54b200_XL.jpg");

        Random random = new Random();
        int index = random.nextInt(urls.size());
        return urls.get(index);
    }
}