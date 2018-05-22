package com.x930073498.delegate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.x930073498.lib.delegate.activity.DefaultDelegateActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener((view) -> {
            Intent intent = new Intent(this, DefaultDelegateActivity.class);
            intent.putExtra("name", Test1Delegate.class);
            startActivity(intent);
        });
    }
}
