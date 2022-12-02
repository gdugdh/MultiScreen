package com.example.multiscreen;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] countries = { "Аргентина", "Бразилия", "Чили", "Колумбия", "Уругвай", "Россия"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, countries);
        setListAdapter(mAdapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, Argentina.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, Brasilia.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Chili.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, Columbia.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, Urugvai.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, Russia.class);
                        break;
                }

                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Вы выбрали " +
                        parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        };

        getListView().setOnItemClickListener(itemListener);
    }
}
