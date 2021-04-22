package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    // Array of strings...
    String phoneList[] = {"lumia","samsung","xiaom"};
    String similarphones[]={"lumia2","Samsung2","xiaom2"};
    int brands[] = {R.drawable.lumia3, R.drawable.samsung1,R.drawable.wiamo1 };
    int similar[] ={R.drawable.lumia2,R.drawable.samsung2,R.drawable.xiamo2};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.lv);

        CustomAdapter adapter = new CustomAdapter(ListActivity.this, phoneList,similarphones,brands,similar);
        listView.setAdapter(adapter);
    }

}