package com.example.xuepeng.connectservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     private EditText etData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etData = findViewById(R.id.etData);
        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStartService:
                Intent i =new Intent(this,MyService.class);
                i.putExtra("data",etData.getText().toString());
                startService(i);
                break;
            case R.id.btnStopService:
                stopService(new Intent(this,MyService.class));

                break;
        }


    }
}
