package com.example.pankaj.deepaktask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TechnicalAdapter adapter;
    ArrayList<TechnicalBean> beens;
    TechnicalBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ListView listView = (ListView) findViewById(R.id.mylist);

        beens = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bean = new TechnicalBean();
            bean.setSkill("");
            bean.setPerformance("");
            beens.add(bean);
        }
        adapter = new TechnicalAdapter(this, beens);
        listView.setAdapter(adapter);
        findViewById(R.id.addmore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean = new TechnicalBean();
                beens.add(bean);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
