package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DbActivity extends AppCompatActivity {

    ListView lvMain;
    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        EditText editText = findViewById(R.id.text_name_car);
        EditText number = findViewById(R.id.num_age_car);
        Button button = findViewById(R.id.button_add_car);
        button.setOnClickListener(v -> {
            String name = editText.getText().toString();
            int age = Integer.parseInt(number.getText().toString());
            ContentValues cv = new ContentValues();
            SQLiteDatabase db = new DbHelper(this).getWritableDatabase();
            cv.put("name", name);
            cv.put("age", age);
            long rowID = db.insert("car", null, cv);
            db.close();
        });

        lvMain = (ListView) findViewById(R.id.list_view);

        LoadData();

    }
    private void LoadData() {
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, names);
//        lvMain.setAdapter(adapter);

        SQLiteDatabase db = new DbHelper(this).getReadableDatabase();
        Cursor c = db.query("car", null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int ageColIndex = c.getColumnIndex("age");
            ArrayList<String> cars = new ArrayList<>();
            do {
                cars.add(c.getString(nameColIndex));
            } while (c.moveToNext());

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_multiple_choice, cars);
            lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            lvMain.setAdapter(adapter);

        } else
        c.close();
    }
}