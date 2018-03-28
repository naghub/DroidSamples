package com.quantummlabs.android.droidsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;
    private String[] mDataset = {
            "Object Box",
            "FCM Storage",
            "Rx Java",
            "Dagger"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setHasFixedSize(true);
        ListAdapter adapter = new ListAdapter(mDataset, this);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setItemClickListener((position) -> {
            Toast.makeText(MainActivity.this, mDataset[position]
                    , Toast.LENGTH_SHORT).show();
        });
    }
}
