package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBInteractor {

    private SQLiteDatabase dataBase;

    public DBInteractor(Context context) {
        dataBase = context.openOrCreateDatabase("namesApp.db", Context.MODE_PRIVATE, null);
        dataBase.execSQL("CREATE TABLE IF NOT EXISTS names (name TEXT, imageUrl TEXT, UNIQUE(name))");
    }

    public List<NameItem> getItems() {
        Cursor query = dataBase.rawQuery("SELECT * FROM names", null);
        List<NameItem> items = new ArrayList<>();
        while (query.moveToNext()) {
            items.add(new NameItem(query.getString(0), query.getString(1)));
        }
        query.close();

        return items;
    }

    public void addItem(NameItem item) {
        dataBase.execSQL(String.format("INSERT OR IGNORE INTO names VALUES ('%s', '%s');", item.name, item.imageUrl));
    }


    public void onDestroy() {
        dataBase.close();
    }
}
