package com.x930073498.delegate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener((view) -> {
            Intent intent = new Intent(this, TestActivity.class);
            intent.putExtra("name", Test1Delegate.class);
            startActivity(intent);
        });
    }
}
