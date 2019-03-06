package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button btn= findViewById(R.id.button1);
        btn.setOnClickListener(FirstActivity.this);
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(FirstActivity.this,"You clicked button1",Toast.LENGTH_SHORT).show();
//        Intent intent=new Intent("com.example.activitytest.ACTION_START");
//        Intent intent=new Intent(Intent.ACTION_DIAL);
        Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//        intent.putExtra("extra_data",666);
//        intent.setData(Uri.parse("tel:10086"));
//        intent.addCategory("com.example.activitytest.MY_CATEGORY");
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
                break;
                default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }
}


