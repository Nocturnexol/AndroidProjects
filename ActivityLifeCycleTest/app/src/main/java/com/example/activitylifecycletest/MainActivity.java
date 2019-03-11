package com.example.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button startNormalActivity;
    Button startDialogActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            String tempData=savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }
        startNormalActivity=findViewById(R.id.start_normal_activity);
        startDialogActivity=findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(MainActivity.this);
        startDialogActivity.setOnClickListener(MainActivity.this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData="Sth. you just typed";
        outState.putString("data_key",tempData);
    }

    @Override
    public void onClick(View v) {
        if (v==startNormalActivity){
            Intent intent=new Intent(MainActivity.this,NormalActivity.class);
            startActivity(intent);
        }else if (v==startDialogActivity){
            Intent intent=new Intent(MainActivity.this,DialogActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
