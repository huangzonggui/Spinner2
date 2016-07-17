package com.example.hzg.spinner2;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //    private List<String> list = new ArrayList<String>();
    private TextView textView;
    private Spinner spinner;
    //    private ArrayAdapter<String> arrAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dataList = new ArrayList<Map<String, Object>>();
        getData();
        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);

        simpleAdapter = new SimpleAdapter(this, dataList, R.layout.item, new String[]{"image", "text"}, new int[]{R.id.image, R.id.text});
        simpleAdapter.setDropDownViewResource(R.layout.item);

        spinner.setAdapter(simpleAdapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("你选择的是：" + dataList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("NONE");
            }
        });
    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", R.drawable.ic_launcher);
            map.put("text", "黄宗贵");
            dataList.add(map);
        }
        return dataList;
    }

}
